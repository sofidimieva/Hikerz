package com.hikerzactivity.hikerzactivity.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hikerzactivity.hikerzactivity.dto.ActivityRequest;
import com.hikerzactivity.hikerzactivity.dto.ActivityResponse;
import com.hikerzactivity.hikerzactivity.service.ActivityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ActivityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ActivityService activityService;

    private ActivityResponse activityResponse1;
    private ActivityResponse activityResponse2;
    private ActivityRequest activityRequest;

    @BeforeEach
    void setUp() {
        activityResponse1 = ActivityResponse.builder()
                .id(1L)
                .title("Morning Hike")
                .description("A beautiful morning hike")
                .build();

        activityResponse2 = ActivityResponse.builder()
                .id(2L)
                .title("Evening Walk")
                .description("Relaxing evening walk")
                .build();

        activityRequest = ActivityRequest.builder()
                .title("New Activity")
                .description("Test activity description")
                .build();
    }

    @Test
    @DisplayName("POST /api/activity - Should create activity successfully")
    void testCreateActivity() throws Exception {
        // Arrange
        doNothing().when(activityService).createActivity(any(ActivityRequest.class));

        // Act & Assert
        mockMvc.perform(post("/api/activity")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(activityRequest)))
                .andExpect(status().isCreated());

        verify(activityService, times(1)).createActivity(any(ActivityRequest.class));
    }

    @Test
    @DisplayName("POST /api/activity - Should handle empty request body")
    void testCreateActivityInvalidRequest() throws Exception {
        // Arrange
        doNothing().when(activityService).createActivity(any(ActivityRequest.class));

        // Act & Assert - Empty JSON is still valid, just creates activity with null fields
        mockMvc.perform(post("/api/activity")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("POST /api/activity/upload-gpx - Should upload GPX file successfully")
    void testUploadGpx() throws Exception {
        // Arrange
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "test.gpx",
                "application/gpx+xml",
                "<?xml version=\"1.0\"?><gpx></gpx>".getBytes()
        );

        doNothing().when(activityService).importGpx(any());

        // Act & Assert
        mockMvc.perform(multipart("/api/activity/upload-gpx")
                        .file(file))
                .andExpect(status().isOk())
                .andExpect(content().string("GPX uploaded"));

        verify(activityService, times(1)).importGpx(any());
    }

    @Test
    @DisplayName("GET /api/activity - Should get all activities successfully")
    void testGetAllActivities() throws Exception {
        // Arrange
        List<ActivityResponse> activities = Arrays.asList(activityResponse1, activityResponse2);
        when(activityService.getAllActivities()).thenReturn(activities);

        // Act & Assert
        mockMvc.perform(get("/api/activity")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("Morning Hike")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].title", is("Evening Walk")));

        verify(activityService, times(1)).getAllActivities();
    }

    @Test
    @DisplayName("GET /api/activity - Should return empty list when no activities")
    void testGetAllActivitiesEmpty() throws Exception {
        // Arrange
        when(activityService.getAllActivities()).thenReturn(Collections.emptyList());

        // Act & Assert
        mockMvc.perform(get("/api/activity")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));

        verify(activityService, times(1)).getAllActivities();
    }

    @Test
    @DisplayName("GET /api/activity/{id}/geojson - Should get GeoJSON successfully")
    void testGetHikeGeoJson() throws Exception {
        // Arrange
        Long hikeId = 1L;
        String geoJson = "{\"type\":\"FeatureCollection\",\"features\":[]}";
        when(activityService.getHikeAsGeoJson(hikeId)).thenReturn(geoJson);

        // Act & Assert
        mockMvc.perform(get("/api/activity/{id}/geojson", hikeId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(geoJson));

        verify(activityService, times(1)).getHikeAsGeoJson(hikeId);
    }

    @Test
    @DisplayName("GET /api/activity/{id}/mapbox-static - Should get static map successfully")
    void testGetHikeStatic() throws Exception {
        // Arrange
        Long hikeId = 1L;
        byte[] pngData = new byte[]{1, 2, 3, 4};
        when(activityService.getMapboxStaticPng(eq(hikeId), anyInt(), anyInt())).thenReturn(pngData);

        // Act & Assert
        mockMvc.perform(get("/api/activity/{id}/mapbox-static", hikeId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.IMAGE_PNG))
                .andExpect(content().bytes(pngData));

        verify(activityService, times(1)).getMapboxStaticPng(hikeId, 800, 600);
    }

    @Test
    @DisplayName("GET /api/activity/{id}/mapbox-static - Should handle custom dimensions")
    void testGetHikeStaticCustomDimensions() throws Exception {
        // Arrange
        Long hikeId = 1L;
        int width = 1024;
        int height = 768;
        byte[] pngData = new byte[]{1, 2, 3, 4};
        when(activityService.getMapboxStaticPng(hikeId, width, height)).thenReturn(pngData);

        // Act & Assert
        mockMvc.perform(get("/api/activity/{id}/mapbox-static", hikeId)
                        .param("w", String.valueOf(width))
                        .param("h", String.valueOf(height)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.IMAGE_PNG));

        verify(activityService, times(1)).getMapboxStaticPng(hikeId, width, height);
    }

    @Test
    @DisplayName("GET /api/activity/{username}/friends-activities - Should get friends activities")
    void testGetFriendsActivities() throws Exception {
        // Arrange
        String username = "testuser";
        List<ActivityResponse> activities = Arrays.asList(activityResponse1, activityResponse2);
        when(activityService.getFriendsActivities(username)).thenReturn(activities);

        // Act & Assert
        mockMvc.perform(get("/api/activity/{username}/friends-activities", username))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].title", is("Morning Hike")))
                .andExpect(jsonPath("$[1].title", is("Evening Walk")));

        verify(activityService, times(1)).getFriendsActivities(username);
    }

    @Test
    @DisplayName("GET /api/activity/{username}/friends-activities - Should return empty list")
    void testGetFriendsActivitiesEmpty() throws Exception {
        // Arrange
        String username = "testuser";
        when(activityService.getFriendsActivities(username)).thenReturn(Collections.emptyList());

        // Act & Assert
        mockMvc.perform(get("/api/activity/{username}/friends-activities", username))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));

        verify(activityService, times(1)).getFriendsActivities(username);
    }

    @Test
    @DisplayName("GET /api/activity/user/{username} - Should get all activities of user")
    void testGetAllActivitiesOfUser() throws Exception {
        // Arrange
        String username = "testuser";
        List<ActivityResponse> activities = Collections.singletonList(activityResponse1);
        when(activityService.getAllActivitiesOfUser(username)).thenReturn(activities);

        // Act & Assert
        mockMvc.perform(get("/api/activity/user/{username}", username))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is("Morning Hike")));

        verify(activityService, times(1)).getAllActivitiesOfUser(username);
    }

    @Test
    @DisplayName("GET /api/activity/user/{username} - Should return empty list when user has no activities")
    void testGetAllActivitiesOfUserEmpty() throws Exception {
        // Arrange
        String username = "testuser";
        when(activityService.getAllActivitiesOfUser(username)).thenReturn(Collections.emptyList());

        // Act & Assert
        mockMvc.perform(get("/api/activity/user/{username}", username))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));

        verify(activityService, times(1)).getAllActivitiesOfUser(username);
    }
}
