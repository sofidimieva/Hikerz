package com.hikerzactivity.hikerzactivity.service;
import com.hikerzactivity.hikerzactivity.repository.ActivityRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hikerzactivity.hikerzactivity.model.Activity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hikerzactivity.hikerzactivity.client.UserMicroserviceClient;
import com.hikerzactivity.hikerzactivity.dto.ActivityRequest;
import com.hikerzactivity.hikerzactivity.dto.ActivityResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import org.locationtech.jts.simplify.DouglasPeuckerSimplifier;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.springframework.beans.factory.annotation.Value;


@Service
@Slf4j
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final ObjectMapper objectMapper;
    private final WebClient webClient;
        private final UserMicroserviceClient userMicroserviceClient;


    private final String mapboxToken;
    
    public ActivityService(ActivityRepository activityRepository, 
            UserMicroserviceClient userMicroserviceClient,
            @Value("${mapbox.token:${MAPBOX_TOKEN:}}") String mapboxToken) {
        this.activityRepository = activityRepository;
        this.objectMapper = new ObjectMapper();
        this.webClient = WebClient.builder().build();
        this.userMicroserviceClient = userMicroserviceClient;
        this.mapboxToken = mapboxToken;
        }
    public void createActivity(ActivityRequest activityrequest){
        Activity activity = Activity.builder().title(activityrequest.getTitle())
        .description(activityrequest.getDescription())
        .userId(activityrequest.getUserId())
        .build();
        activityRepository.save(activity);
        log.info("Activity {} is saved", activity.getId());
    }

    public List<ActivityResponse> getAllActivities(){
        List<Activity> activities = activityRepository.findAll(); 
        return activities.stream().map(activity -> mapToActivityResponse(activity)).toList();
    }

    public List<ActivityResponse> getAllActivitiesOfUser(String username) {
        List<Activity> activities = activityRepository.findByUserId(username);
        return activities.stream()
            .map(this::mapToActivityResponse)
            .toList();
    }

    public List<ActivityResponse> getFriendsActivities(String username) {
        var followedUsernames = userMicroserviceClient.getFollowing(username);
         System.out.println("Followed usernames: " + followedUsernames);
        if (followedUsernames == null || followedUsernames.isEmpty()) {
            return new ArrayList<>();
        }
        
        List<Activity> activities = activityRepository.findByUsernameInOrderByDateDesc(followedUsernames);
        
        return activities.stream()
                .map(this::mapToActivityResponse)
                .toList();
    }

    public String getHikeAsGeoJson(Long id) {
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Hike not found: " + id));

        String geomJson = activityRepository.findGeomGeoJsonById(id);
        if (geomJson == null) {
            throw new NoSuchElementException("Geometry not found for hike: " + id);
        }

        try {
            // parse the geometry JSON string so we don’t double-quote it
            Object geometry = objectMapper.readValue(geomJson, Object.class);

            Map<String, Object> feature = new LinkedHashMap<>();
            feature.put("type", "Feature");
            feature.put("geometry", geometry);
        feature.put("properties", Map.of(
            "id", activity.getId(),
            "name", activity.getTitle()
        ));

            Map<String, Object> fc = new LinkedHashMap<>();
            fc.put("type", "FeatureCollection");
            fc.put("features", List.of(feature));

            // token is injected via constructor binding by Spring when the bean is created

            return objectMapper.writeValueAsString(fc);
        } catch (Exception e) {
            throw new RuntimeException("Failed to build GeoJSON for hike " + id, e);
        }
    }

    public byte[] getMapboxStaticPng(Long id, int width, int height) {
        if (mapboxToken == null || mapboxToken.isBlank()) {
            throw new IllegalStateException("Mapbox token not configured (mapbox.token).");
        }

        // clamp to Mapbox limits (1..1280)
        int w = Math.max(1, Math.min(width, 1280));
        int h = Math.max(1, Math.min(height, 1280));

        // Fetch the Activity entity and use the mapped LineString directly
        Activity activity = activityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Hike not found: " + id));

        LineString route = activity.getRoute();
        if (route == null) {
            throw new NoSuchElementException("Geometry not found for hike: " + id);
        }

        try {
            int pts = route.getNumPoints();
            double tolerance = 0.0;
            if (pts > 5000) tolerance = 0.001;
            else if (pts > 2000) tolerance = 0.0005;
            else if (pts > 1000) tolerance = 0.0002;

            Geometry toUse = route;
            if (tolerance > 0.0) {
                toUse = DouglasPeuckerSimplifier.simplify(route, tolerance);
            }

            // Construct GeoJSON geometry object from simplified coordinates
            List<List<Double>> coords = new java.util.ArrayList<>();
            for (org.locationtech.jts.geom.Coordinate c : toUse.getCoordinates()) {
                coords.add(List.of(c.x, c.y));
            }
            Map<String, Object> geometry = new LinkedHashMap<>();
            geometry.put("type", "LineString");
            geometry.put("coordinates", coords);

            Map<String, Object> feature = new LinkedHashMap<>();
            feature.put("type", "Feature");
            feature.put("geometry", geometry);
            feature.put("properties", Map.of("id", id, "name", activity.getTitle()));

            Map<String, Object> fcMap = new LinkedHashMap<>();
            fcMap.put("type", "FeatureCollection");
            fcMap.put("features", List.of(feature));

            String fc = objectMapper.writeValueAsString(fcMap);
            String overlay = "geojson(" + fc + ")";

            URI uri = UriComponentsBuilder
                    .fromUriString("https://api.mapbox.com")
                    .path("/styles/v1/mapbox/outdoors-v12/static/{overlay}/auto/{w}x{h}")
                    .queryParam("access_token", mapboxToken)
                    .buildAndExpand(Map.of("overlay", overlay, "w", w, "h", h))
                    .encode(StandardCharsets.UTF_8)
                    .toUri();

            return webClient.get()
                    .uri(uri)
                    .accept(MediaType.IMAGE_PNG)
                    .retrieve()
                    .onStatus(HttpStatusCode::isError, resp ->
                            resp.bodyToMono(String.class).flatMap(body ->
                                    Mono.error(new RuntimeException("Mapbox error " + resp.statusCode() + ": " + body))))
                    .bodyToMono(byte[].class)
                    .block();
        } catch (Exception e) {
            throw new RuntimeException("Failed to produce Mapbox static image for hike " + id, e);
        }
        
    }

    public void importGpx(MultipartFile file) throws Exception {
        // Parse GPX and persist route as LineString
        log.info("Received file: {}", file.getOriginalFilename());

        try (var in = file.getInputStream()) {
            // Minimal GPX parser: extract <trkpt lat="..." lon="..."> attributes
            javax.xml.stream.XMLInputFactory factory = javax.xml.stream.XMLInputFactory.newInstance();
            javax.xml.stream.XMLStreamReader xmlr = factory.createXMLStreamReader(in);

            java.util.List<org.locationtech.jts.geom.Coordinate> coords = new java.util.ArrayList<>();
            while (xmlr.hasNext()) {
                int event = xmlr.next();
                if (event == javax.xml.stream.XMLStreamConstants.START_ELEMENT) {
                    String localName = xmlr.getLocalName();
                    if ("trkpt".equals(localName) || "wpt".equals(localName)) {
                        String lat = xmlr.getAttributeValue(null, "lat");
                        String lon = xmlr.getAttributeValue(null, "lon");
                        if (lat != null && lon != null) {
                            try {
                                double dlat = Double.parseDouble(lat);
                                double dlon = Double.parseDouble(lon);
                                coords.add(new org.locationtech.jts.geom.Coordinate(dlon, dlat));
                            } catch (NumberFormatException e) {
                                // ignore malformed point
                            }
                        }
                    }
                }
            }

            if (coords.size() < 2) {
                throw new IllegalArgumentException("GPX contains insufficient points to form a LineString");
            }

            org.locationtech.jts.geom.GeometryFactory gf = new org.locationtech.jts.geom.GeometryFactory(new org.locationtech.jts.geom.PrecisionModel(), 4326);
            org.locationtech.jts.geom.LineString ls = gf.createLineString(coords.toArray(new org.locationtech.jts.geom.Coordinate[0]));

            Activity activity = Activity.builder()
                    .title(file.getOriginalFilename())
                    .description("Imported from GPX")
                    .route(ls)
                    .build();

            activityRepository.save(activity);
            log.info("Imported GPX and saved activity id={}", activity.getId());
        }
    }

    private ActivityResponse mapToActivityResponse(Activity activity){
        return ActivityResponse.builder().id(activity.getId()).title(activity.getTitle()).description(activity.getDescription()).build();
    }
}
