package com.hikerzuser.hikerzuser.controller;

import com.hikerzuser.hikerzuser.dto.PaginatedResponse;
import com.hikerzuser.hikerzuser.dto.UserRequest;
import com.hikerzuser.hikerzuser.dto.UserResponse;
import com.hikerzuser.hikerzuser.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private final String TEST_USERNAME = "testuser";
    private UserRequest userRequest;
    private UserResponse userResponse;

    @BeforeEach
    void setUp() {
        userRequest = UserRequest.builder()
                .username(TEST_USERNAME)
                .name("Test User")
                .email("test@example.com")
                .build();

        userResponse = UserResponse.builder()
                .username(TEST_USERNAME)
                .name("Test User")
                .followers(Collections.emptySet())
                .following(Collections.emptySet())
                .build();
    }

    @Test
    @DisplayName("createUser should delegate to service")
    void createUser_DelegatesToService() {
        userController.createUser(userRequest);
        verify(userService, times(1)).createUser(userRequest);
    }

    @Test
    @DisplayName("populateUsers should delegate to service")
    void populateUsers_DelegatesToService() {
        userController.populateUsers();
        verify(userService, times(1)).populateUsers();
    }

    @Test
    @DisplayName("getUser should return UserResponse from service")
    void getUser_ReturnsUserResponse() {
        when(userService.getUser(TEST_USERNAME)).thenReturn(userResponse);

        UserResponse result = userController.getUser(TEST_USERNAME);

        assertEquals(userResponse, result);
        verify(userService, times(1)).getUser(TEST_USERNAME);
    }

    @Test
    @DisplayName("handleNotFound should return exception message")
    void handleNotFound_ReturnsMessage() {
        NoSuchElementException ex = new NoSuchElementException("User not found.");
        String message = userController.handleNotFound(ex);
        assertEquals("User not found.", message);
    }

    @Test
    @DisplayName("handleBadRequest should return exception message")
    void handleBadRequest_ReturnsMessage() {
        IllegalArgumentException ex = new IllegalArgumentException("Invalid input.");
        String message = userController.handleBadRequest(ex);
        assertEquals("Invalid input.", message);
    }

    @Test
    @DisplayName("getAllUsers should delegate to service with default and null query")
    void getAllUsers_DefaultParams_DelegatesCorrectly() {
        PaginatedResponse<UserResponse> expectedResponse = PaginatedResponse.<UserResponse>builder().data(List.of(userResponse)).build();
        when(userService.getAllUsers(TEST_USERNAME, 0, 10, null)).thenReturn(expectedResponse);

        PaginatedResponse<UserResponse> result = userController.getAllUsers(TEST_USERNAME, 0, 10, null);

        assertEquals(expectedResponse, result);
        verify(userService, times(1)).getAllUsers(TEST_USERNAME, 0, 10, null);
    }

    @Test
    @DisplayName("getAllUsers should pass trimmed query string")
    void getAllUsers_WithQuery_PassesQuery() {
        String rawQuery = "  search  ";
        String expectedQuery = "search";
        PaginatedResponse<UserResponse> expectedResponse = PaginatedResponse.<UserResponse>builder().data(Collections.emptyList()).build();
        when(userService.getAllUsers(TEST_USERNAME, 0, 10, expectedQuery)).thenReturn(expectedResponse);

        userController.getAllUsers(TEST_USERNAME, 0, 10, rawQuery);

        verify(userService, times(1)).getAllUsers(TEST_USERNAME, 0, 10, expectedQuery);
    }

    @Test
    @DisplayName("getAllUsersNotPaginated should delegate with null query if q is null")
    void getAllUsersNotPaginated_NullQuery_DelegatesCorrectly() {
        List<UserResponse> expectedResponse = List.of(userResponse);
        when(userService.getAllUsersNotPaginated(TEST_USERNAME, null)).thenReturn(expectedResponse);

        List<UserResponse> result = userController.getAllUsersNotPaginated(TEST_USERNAME, null);

        assertEquals(expectedResponse, result);
        verify(userService, times(1)).getAllUsersNotPaginated(TEST_USERNAME, null);
    }

    @Test
    @DisplayName("getAllUsersNotPaginated should pass trimmed query string")
    void getAllUsersNotPaginated_WithQuery_PassesQuery() {
        String rawQuery = "  term  ";
        String expectedQuery = "term";
        List<UserResponse> expectedResponse = Collections.emptyList();
        when(userService.getAllUsersNotPaginated(TEST_USERNAME, expectedQuery)).thenReturn(expectedResponse);

        userController.getAllUsersNotPaginated(TEST_USERNAME, rawQuery);

        verify(userService, times(1)).getAllUsersNotPaginated(TEST_USERNAME, expectedQuery);
    }
}