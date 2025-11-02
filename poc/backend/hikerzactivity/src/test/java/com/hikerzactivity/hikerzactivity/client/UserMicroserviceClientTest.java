package com.hikerzactivity.hikerzactivity.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserMicroserviceClientTest {

    @Mock
    private RestTemplate restTemplate;

    private UserMicroserviceClient userMicroserviceClient;

    private String userServiceUrl = "http://localhost:8090";

    @BeforeEach
    void setUp() {
        userMicroserviceClient = new UserMicroserviceClient(restTemplate, userServiceUrl);
    }

    @Test
    @DisplayName("Should get following list successfully")
    void testGetFollowingSuccess() {
        // Arrange
        String username = "testuser";
        String url = userServiceUrl + "/api/follow/" + username + "/following";

        UserMicroserviceClient.FollowersResponse response = new UserMicroserviceClient.FollowersResponse();
        UserMicroserviceClient.UserDto user1 = new UserMicroserviceClient.UserDto();
        user1.setUsername("friend1");
        UserMicroserviceClient.UserDto user2 = new UserMicroserviceClient.UserDto();
        user2.setUsername("friend2");
        response.setFollowers(Arrays.asList(user1, user2));

        when(restTemplate.getForEntity(eq(url), eq(UserMicroserviceClient.FollowersResponse.class)))
                .thenReturn(new ResponseEntity<>(response, HttpStatus.OK));

        // Act
        List<String> result = userMicroserviceClient.getFollowing(username);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains("friend1"));
        assertTrue(result.contains("friend2"));
        verify(restTemplate, times(1)).getForEntity(eq(url), eq(UserMicroserviceClient.FollowersResponse.class));
    }

    @Test
    @DisplayName("Should return empty list when user has no followers")
    void testGetFollowingNoFollowers() {
        // Arrange
        String username = "testuser";
        String url = userServiceUrl + "/api/follow/" + username + "/following";

        UserMicroserviceClient.FollowersResponse response = new UserMicroserviceClient.FollowersResponse();
        response.setFollowers(Collections.emptyList());

        when(restTemplate.getForEntity(eq(url), eq(UserMicroserviceClient.FollowersResponse.class)))
                .thenReturn(new ResponseEntity<>(response, HttpStatus.OK));

        // Act
        List<String> result = userMicroserviceClient.getFollowing(username);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(restTemplate, times(1)).getForEntity(eq(url), eq(UserMicroserviceClient.FollowersResponse.class));
    }

    @Test
    @DisplayName("Should return empty list when response body is null")
    void testGetFollowingNullBody() {
        // Arrange
        String username = "testuser";
        String url = userServiceUrl + "/api/follow/" + username + "/following";

        when(restTemplate.getForEntity(eq(url), eq(UserMicroserviceClient.FollowersResponse.class)))
                .thenReturn(new ResponseEntity<>(null, HttpStatus.OK));

        // Act
        List<String> result = userMicroserviceClient.getFollowing(username);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(restTemplate, times(1)).getForEntity(eq(url), eq(UserMicroserviceClient.FollowersResponse.class));
    }

    @Test
    @DisplayName("Should return empty list when followers list is null")
    void testGetFollowingNullFollowers() {
        // Arrange
        String username = "testuser";
        String url = userServiceUrl + "/api/follow/" + username + "/following";

        UserMicroserviceClient.FollowersResponse response = new UserMicroserviceClient.FollowersResponse();
        response.setFollowers(null);

        when(restTemplate.getForEntity(eq(url), eq(UserMicroserviceClient.FollowersResponse.class)))
                .thenReturn(new ResponseEntity<>(response, HttpStatus.OK));

        // Act
        List<String> result = userMicroserviceClient.getFollowing(username);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(restTemplate, times(1)).getForEntity(eq(url), eq(UserMicroserviceClient.FollowersResponse.class));
    }

    @Test
    @DisplayName("Should handle REST client exception")
    void testGetFollowingRestClientException() {
        // Arrange
        String username = "testuser";
        String url = userServiceUrl + "/api/follow/" + username + "/following";

        when(restTemplate.getForEntity(eq(url), eq(UserMicroserviceClient.FollowersResponse.class)))
                .thenThrow(new RestClientException("Connection refused"));

        // Act
        List<String> result = userMicroserviceClient.getFollowing(username);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(restTemplate, times(1)).getForEntity(eq(url), eq(UserMicroserviceClient.FollowersResponse.class));
    }

    @Test
    @DisplayName("Should handle generic exception")
    void testGetFollowingGenericException() {
        // Arrange
        String username = "testuser";
        String url = userServiceUrl + "/api/follow/" + username + "/following";

        when(restTemplate.getForEntity(eq(url), eq(UserMicroserviceClient.FollowersResponse.class)))
                .thenThrow(new RuntimeException("Unexpected error"));

        // Act
        List<String> result = userMicroserviceClient.getFollowing(username);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(restTemplate, times(1)).getForEntity(eq(url), eq(UserMicroserviceClient.FollowersResponse.class));
    }

    @Test
    @DisplayName("Should construct correct URL with username")
    void testGetFollowingUrlConstruction() {
        // Arrange
        String username = "user@123";
        String expectedUrl = userServiceUrl + "/api/follow/" + username + "/following";

        UserMicroserviceClient.FollowersResponse response = new UserMicroserviceClient.FollowersResponse();
        response.setFollowers(Collections.emptyList());

        when(restTemplate.getForEntity(eq(expectedUrl), eq(UserMicroserviceClient.FollowersResponse.class)))
                .thenReturn(new ResponseEntity<>(response, HttpStatus.OK));

        // Act
        userMicroserviceClient.getFollowing(username);

        // Assert
        verify(restTemplate, times(1)).getForEntity(eq(expectedUrl), eq(UserMicroserviceClient.FollowersResponse.class));
    }

    @Test
    @DisplayName("Should use configured service URL")
    void testCustomServiceUrl() {
        // Arrange
        String customUrl = "http://custom-service:9090";
        UserMicroserviceClient customClient = new UserMicroserviceClient(restTemplate, customUrl);
        String username = "testuser";
        String expectedUrl = customUrl + "/api/follow/" + username + "/following";

        UserMicroserviceClient.FollowersResponse response = new UserMicroserviceClient.FollowersResponse();
        response.setFollowers(Collections.emptyList());

        when(restTemplate.getForEntity(eq(expectedUrl), eq(UserMicroserviceClient.FollowersResponse.class)))
                .thenReturn(new ResponseEntity<>(response, HttpStatus.OK));

        // Act
        customClient.getFollowing(username);

        // Assert
        verify(restTemplate, times(1)).getForEntity(eq(expectedUrl), eq(UserMicroserviceClient.FollowersResponse.class));
    }
}
