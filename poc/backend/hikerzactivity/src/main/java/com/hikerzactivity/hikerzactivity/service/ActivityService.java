package com.hikerzactivity.hikerzactivity.service;
import com.hikerzactivity.hikerzactivity.repository.ActivityRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.charset.StandardCharsets;
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
import com.hikerzactivity.hikerzactivity.dto.ActivityRequest;
import com.hikerzactivity.hikerzactivity.dto.ActivityResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;


@Service
@Slf4j
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final ObjectMapper objectMapper;
    private final WebClient webClient;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
        this.objectMapper = new ObjectMapper();
        this.webClient = WebClient.builder().build();
    }

    private final String mapboxToken = "pk.eyJ1IjoiYm9nZGFucGFyYW1vbiIsImEiOiJjbWZvYjZpdnEwMzRwMmtzNXBuNmF5M3JpIn0.appf2tqsZnfTzfoL8IQrfw";

    public void createActivity(ActivityRequest activityrequest){
        Activity activity = Activity.builder().title(activityrequest.getTitle()).description(activityrequest.getDescription()).build();
        activityRepository.save(activity);
        log.info("Activity {} is saved", activity.getId());
    }

    public List<ActivityResponse> getAllActivities(){
        List<Activity> activities = activityRepository.findAll(); 
        return activities.stream().map(activity -> mapToActivityResponse(activity)).toList();
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

        // get your hike as a FeatureCollection JSON string (UN-encoded)
        String fc = getHikeAsGeoJson(id);

        // DO NOT pre-encode; builder will encode exactly once
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
    }

    public void importGpx(MultipartFile file) throws Exception {
    // TODO: parse the GPX file, convert it to LineString and save to DB

    // Example: log filename just to verify
    System.out.println("Received file: " + file.getOriginalFilename());

    // Later: parse GPX and persist route as LineString
    }

    private ActivityResponse mapToActivityResponse(Activity activity){
        return ActivityResponse.builder().id(activity.getId()).title(activity.getTitle()).description(activity.getDescription()).build();
    }
}
