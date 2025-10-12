package com.hikerzuser.hikerzuser.controller;

import com.hikerzuser.hikerzuser.dto.FollowersResponse;
import com.hikerzuser.hikerzuser.dto.FollowingResponse;
import com.hikerzuser.hikerzuser.model.User;
import com.hikerzuser.hikerzuser.service.FollowingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FollowingControllerTest {

    @Mock
    private FollowingService followingService;

    @InjectMocks
    private FollowingController followingController;

    private final String USERNAME = "testuser";
    private final String FOLLOW_USERNAME = "followuser";

    // --- Existing Tests ---

    @Test
    @DisplayName("followUser should call the service method")
    void followUser_CallsService() {
        followingController.followUser(USERNAME, FOLLOW_USERNAME);
        verify(followingService, times(1)).followUser(USERNAME, FOLLOW_USERNAME);
    }

    @Test
    @DisplayName("unfollowUser should call the service method")
    void unfollowUser_CallsService() {
        followingController.unfollowUser(USERNAME, FOLLOW_USERNAME);
        verify(followingService, times(1)).unfollowUser(USERNAME, FOLLOW_USERNAME);
    }

    @Test
    @DisplayName("getFollowers should return service response")
    void getFollowers_ReturnsResponse() {
        FollowersResponse expectedResponse = new FollowersResponse(List.of(User.builder().username("f1").build()));
        when(followingService.getFollowers(USERNAME)).thenReturn(expectedResponse);

        FollowersResponse actualResponse = followingController.getFollowers(USERNAME);

        assertEquals(expectedResponse, actualResponse);
        verify(followingService, times(1)).getFollowers(USERNAME);
    }

    // --- New Tests ---

    @Test
    @DisplayName("getFollowing should return service response")
    void getFollowing_ReturnsResponse() {
        // Arrange
        FollowingResponse expectedResponse = new FollowingResponse(List.of(User.builder().username("d1").build()));
        when(followingService.getFollowing(USERNAME)).thenReturn(expectedResponse);

        // Act
        FollowingResponse actualResponse = followingController.getFollowing(USERNAME);

        // Assert
        assertEquals(expectedResponse, actualResponse);
        verify(followingService, times(1)).getFollowing(USERNAME);
    }

    @Test
    @DisplayName("followUser should re-throw IllegalArgumentException from service")
    void followUser_IllegalArgument_ThrowsException() {
        // Arrange: Simulate service throwing exception (e.g., cannot follow self)
        doThrow(new IllegalArgumentException("Cannot follow self"))
                .when(followingService).followUser(USERNAME, FOLLOW_USERNAME);

        // Act & Assert: The controller should just let the exception bubble up to be handled by Spring
        assertThrows(IllegalArgumentException.class, () -> {
            followingController.followUser(USERNAME, FOLLOW_USERNAME);
        });

        verify(followingService, times(1)).followUser(USERNAME, FOLLOW_USERNAME);
    }

    @Test
    @DisplayName("unfollowUser should re-throw RuntimeException from service (User not found)")
    void unfollowUser_RuntimeException_ThrowsException() {
        // Arrange: Simulate service throwing a custom RuntimeException (e.g., User not found)
        doThrow(new RuntimeException("Follower user not found"))
                .when(followingService).unfollowUser(USERNAME, FOLLOW_USERNAME);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> {
            followingController.unfollowUser(USERNAME, FOLLOW_USERNAME);
        });

        verify(followingService, times(1)).unfollowUser(USERNAME, FOLLOW_USERNAME);
    }
}