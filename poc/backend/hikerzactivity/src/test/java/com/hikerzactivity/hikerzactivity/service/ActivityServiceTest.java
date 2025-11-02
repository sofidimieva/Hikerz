package com.hikerzactivity.hikerzactivity.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hikerzactivity.hikerzactivity.client.UserMicroserviceClient;
import com.hikerzactivity.hikerzactivity.dto.ActivityRequest;
import com.hikerzactivity.hikerzactivity.dto.ActivityResponse;
import com.hikerzactivity.hikerzactivity.model.Activity;
import com.hikerzactivity.hikerzactivity.repository.ActivityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.PrecisionModel;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ActivityServiceTest {

    @Mock
    private ActivityRepository activityRepository;

    @Mock
    private UserMicroserviceClient userMicroserviceClient;

    @Mock
    private WebClient webClient;

    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;

    @Spy
    private ObjectMapper objectMapper = new ObjectMapper();

    private ActivityService activityService;

    private Activity activity1;
    private Activity activity2;
    private ActivityRequest activityRequest;
    private GeometryFactory geometryFactory;
    private LineString testLineString;

    @BeforeEach
    void setUp() {
        // Initialize geometry factory
        geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);

        // Create a test LineString
        Coordinate[] coordinates = new Coordinate[]{
                new Coordinate(4.3571, 50.8503),  // Brussels
                new Coordinate(4.3676, 50.8503),
                new Coordinate(4.3676, 50.8603)
        };
        testLineString = geometryFactory.createLineString(coordinates);

        // Create test activities
        activity1 = Activity.builder()
                .id(1L)
                .title("Morning Hike")
                .description("A beautiful morning hike")
                .userId("testuser")
                .route(testLineString)
                .createdAt(LocalDateTime.now())
                .build();

        activity2 = Activity.builder()
                .id(2L)
                .title("Evening Walk")
                .description("Relaxing evening walk")
                .userId("anotheruser")
                .route(testLineString)
                .createdAt(LocalDateTime.now().minusDays(1))
                .build();

        activityRequest = ActivityRequest.builder()
                .title("New Activity")
                .description("Test activity description")
                .build();

        // Initialize ActivityService with a mock mapbox token
        activityService = new ActivityService(
                activityRepository,
                userMicroserviceClient,
                "test-mapbox-token"
        );
    }

    @Test
    @DisplayName("Should create activity successfully")
    void testCreateActivity() {
        // Arrange
        when(activityRepository.save(any(Activity.class))).thenReturn(activity1);

        // Act
        activityService.createActivity(activityRequest);

        // Assert
        ArgumentCaptor<Activity> activityCaptor = ArgumentCaptor.forClass(Activity.class);
        verify(activityRepository, times(1)).save(activityCaptor.capture());

        Activity savedActivity = activityCaptor.getValue();
        assertEquals(activityRequest.getTitle(), savedActivity.getTitle());
        assertEquals(activityRequest.getDescription(), savedActivity.getDescription());
    }

    @Test
    @DisplayName("Should get all activities successfully")
    void testGetAllActivities() {
        // Arrange
        List<Activity> activities = Arrays.asList(activity1, activity2);
        when(activityRepository.findAll()).thenReturn(activities);

        // Act
        List<ActivityResponse> result = activityService.getAllActivities();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Morning Hike", result.get(0).getTitle());
        assertEquals("Evening Walk", result.get(1).getTitle());
        verify(activityRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should return empty list when no activities exist")
    void testGetAllActivitiesEmpty() {
        // Arrange
        when(activityRepository.findAll()).thenReturn(Collections.emptyList());

        // Act
        List<ActivityResponse> result = activityService.getAllActivities();

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(activityRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should get all activities of a specific user")
    void testGetAllActivitiesOfUser() {
        // Arrange
        String username = "testuser";
        List<Activity> userActivities = Collections.singletonList(activity1);
        when(activityRepository.findByUserId(username)).thenReturn(userActivities);

        // Act
        List<ActivityResponse> result = activityService.getAllActivitiesOfUser(username);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Morning Hike", result.get(0).getTitle());
        verify(activityRepository, times(1)).findByUserId(username);
    }

    @Test
    @DisplayName("Should return empty list when user has no activities")
    void testGetAllActivitiesOfUserEmpty() {
        // Arrange
        String username = "nonexistentuser";
        when(activityRepository.findByUserId(username)).thenReturn(Collections.emptyList());

        // Act
        List<ActivityResponse> result = activityService.getAllActivitiesOfUser(username);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(activityRepository, times(1)).findByUserId(username);
    }

    @Test
    @DisplayName("Should get friends activities successfully")
    void testGetFriendsActivities() {
        // Arrange
        String username = "testuser";
        List<String> followedUsernames = Arrays.asList("friend1", "friend2");
        List<Activity> friendActivities = Arrays.asList(activity1, activity2);

        when(userMicroserviceClient.getFollowing(username)).thenReturn(followedUsernames);
        when(activityRepository.findByUsernameInOrderByDateDesc(followedUsernames))
                .thenReturn(friendActivities);

        // Act
        List<ActivityResponse> result = activityService.getFriendsActivities(username);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(userMicroserviceClient, times(1)).getFollowing(username);
        verify(activityRepository, times(1)).findByUsernameInOrderByDateDesc(followedUsernames);
    }

    @Test
    @DisplayName("Should return empty list when user has no friends")
    void testGetFriendsActivitiesNoFriends() {
        // Arrange
        String username = "testuser";
        when(userMicroserviceClient.getFollowing(username)).thenReturn(Collections.emptyList());

        // Act
        List<ActivityResponse> result = activityService.getFriendsActivities(username);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(userMicroserviceClient, times(1)).getFollowing(username);
        verify(activityRepository, never()).findByUsernameInOrderByDateDesc(anyList());
    }

    @Test
    @DisplayName("Should return empty list when user microservice returns null")
    void testGetFriendsActivitiesNullResponse() {
        // Arrange
        String username = "testuser";
        when(userMicroserviceClient.getFollowing(username)).thenReturn(null);

        // Act
        List<ActivityResponse> result = activityService.getFriendsActivities(username);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(userMicroserviceClient, times(1)).getFollowing(username);
        verify(activityRepository, never()).findByUsernameInOrderByDateDesc(anyList());
    }

    @Test
    @DisplayName("Should get hike as GeoJSON successfully")
    void testGetHikeAsGeoJson() throws Exception {
        // Arrange
        Long hikeId = 1L;
        String mockGeoJson = "{\"type\":\"LineString\",\"coordinates\":[[4.3571,50.8503],[4.3676,50.8503],[4.3676,50.8603]]}";

        when(activityRepository.findById(hikeId)).thenReturn(Optional.of(activity1));
        when(activityRepository.findGeomGeoJsonById(hikeId)).thenReturn(mockGeoJson);

        // Act
        String result = activityService.getHikeAsGeoJson(hikeId);

        // Assert
        assertNotNull(result);
        assertTrue(result.contains("\"type\":\"FeatureCollection\""));
        assertTrue(result.contains("\"type\":\"Feature\""));
        assertTrue(result.contains("Morning Hike"));
        verify(activityRepository, times(1)).findById(hikeId);
        verify(activityRepository, times(1)).findGeomGeoJsonById(hikeId);
    }

    @Test
    @DisplayName("Should throw exception when hike not found for GeoJSON")
    void testGetHikeAsGeoJsonNotFound() {
        // Arrange
        Long hikeId = 999L;
        when(activityRepository.findById(hikeId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> {
            activityService.getHikeAsGeoJson(hikeId);
        });
        verify(activityRepository, times(1)).findById(hikeId);
        verify(activityRepository, never()).findGeomGeoJsonById(anyLong());
    }

    @Test
    @DisplayName("Should throw exception when geometry not found for GeoJSON")
    void testGetHikeAsGeoJsonNoGeometry() {
        // Arrange
        Long hikeId = 1L;
        when(activityRepository.findById(hikeId)).thenReturn(Optional.of(activity1));
        when(activityRepository.findGeomGeoJsonById(hikeId)).thenReturn(null);

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> {
            activityService.getHikeAsGeoJson(hikeId);
        });
        verify(activityRepository, times(1)).findById(hikeId);
        verify(activityRepository, times(1)).findGeomGeoJsonById(hikeId);
    }

    @Test
    @DisplayName("Should throw exception when hike not found for static map")
    void testGetMapboxStaticPngNotFound() {
        // Arrange
        Long hikeId = 999L;
        when(activityRepository.findById(hikeId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> {
            activityService.getMapboxStaticPng(hikeId, 800, 600);
        });
        verify(activityRepository, times(1)).findById(hikeId);
    }

    @Test
    @DisplayName("Should throw exception when activity has no route for static map")
    void testGetMapboxStaticPngNoRoute() {
        // Arrange
        Long hikeId = 1L;
        Activity activityWithoutRoute = Activity.builder()
                .id(hikeId)
                .title("No Route Activity")
                .description("Activity without route")
                .route(null)
                .build();

        when(activityRepository.findById(hikeId)).thenReturn(Optional.of(activityWithoutRoute));

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> {
            activityService.getMapboxStaticPng(hikeId, 800, 600);
        });
        verify(activityRepository, times(1)).findById(hikeId);
    }

    @Test
    @DisplayName("Should import GPX file successfully")
    void testImportGpx() throws Exception {
        // Arrange
        String gpxContent = """
                <?xml version="1.0" encoding="UTF-8"?>
                <gpx version="1.1">
                  <trk>
                    <trkseg>
                      <trkpt lat="50.8503" lon="4.3571"></trkpt>
                      <trkpt lat="50.8503" lon="4.3676"></trkpt>
                      <trkpt lat="50.8603" lon="4.3676"></trkpt>
                    </trkseg>
                  </trk>
                </gpx>
                """;

        MockMultipartFile file = new MockMultipartFile(
                "file",
                "test.gpx",
                "application/gpx+xml",
                gpxContent.getBytes(StandardCharsets.UTF_8)
        );

        when(activityRepository.save(any(Activity.class))).thenReturn(activity1);

        // Act
        activityService.importGpx(file);

        // Assert
        ArgumentCaptor<Activity> activityCaptor = ArgumentCaptor.forClass(Activity.class);
        verify(activityRepository, times(1)).save(activityCaptor.capture());

        Activity savedActivity = activityCaptor.getValue();
        assertEquals("test.gpx", savedActivity.getTitle());
        assertEquals("Imported from GPX", savedActivity.getDescription());
        assertNotNull(savedActivity.getRoute());
        assertEquals(3, savedActivity.getRoute().getNumPoints());
    }

    @Test
    @DisplayName("Should throw exception when GPX has insufficient points")
    void testImportGpxInsufficientPoints() {
        // Arrange
        String gpxContent = """
                <?xml version="1.0" encoding="UTF-8"?>
                <gpx version="1.1">
                  <trk>
                    <trkseg>
                      <trkpt lat="50.8503" lon="4.3571"></trkpt>
                    </trkseg>
                  </trk>
                </gpx>
                """;

        MockMultipartFile file = new MockMultipartFile(
                "file",
                "test.gpx",
                "application/gpx+xml",
                gpxContent.getBytes(StandardCharsets.UTF_8)
        );

        // Act & Assert
        Exception exception = assertThrows(Exception.class, () -> {
            activityService.importGpx(file);
        });

        assertTrue(exception.getMessage().contains("insufficient points"));
        verify(activityRepository, never()).save(any(Activity.class));
    }

    @Test
    @DisplayName("Should handle GPX with waypoints")
    void testImportGpxWithWaypoints() throws Exception {
        // Arrange
        String gpxContent = """
                <?xml version="1.0" encoding="UTF-8"?>
                <gpx version="1.1">
                  <wpt lat="50.8503" lon="4.3571"></wpt>
                  <wpt lat="50.8503" lon="4.3676"></wpt>
                  <wpt lat="50.8603" lon="4.3676"></wpt>
                </gpx>
                """;

        MockMultipartFile file = new MockMultipartFile(
                "file",
                "waypoints.gpx",
                "application/gpx+xml",
                gpxContent.getBytes(StandardCharsets.UTF_8)
        );

        when(activityRepository.save(any(Activity.class))).thenReturn(activity1);

        // Act
        activityService.importGpx(file);

        // Assert
        ArgumentCaptor<Activity> activityCaptor = ArgumentCaptor.forClass(Activity.class);
        verify(activityRepository, times(1)).save(activityCaptor.capture());

        Activity savedActivity = activityCaptor.getValue();
        assertNotNull(savedActivity.getRoute());
        assertEquals(3, savedActivity.getRoute().getNumPoints());
    }

    @Test
    @DisplayName("Should map activity to activity response correctly")
    void testMapToActivityResponse() {
        // Act
        List<ActivityResponse> responses = activityService.getAllActivities();

        // Arrange
        when(activityRepository.findAll()).thenReturn(Collections.singletonList(activity1));
        responses = activityService.getAllActivities();

        // Assert
        assertNotNull(responses);
        assertEquals(1, responses.size());
        ActivityResponse response = responses.get(0);
        assertEquals(activity1.getId(), response.getId());
        assertEquals(activity1.getTitle(), response.getTitle());
        assertEquals(activity1.getDescription(), response.getDescription());
    }
}
