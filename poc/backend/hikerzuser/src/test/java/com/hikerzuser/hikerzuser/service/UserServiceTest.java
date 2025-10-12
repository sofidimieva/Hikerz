package com.hikerzuser.hikerzuser.service;

import com.hikerzuser.hikerzuser.dto.PaginatedResponse;
import com.hikerzuser.hikerzuser.dto.UserRequest;
import com.hikerzuser.hikerzuser.dto.UserResponse;
import com.hikerzuser.hikerzuser.model.User;
import com.hikerzuser.hikerzuser.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user1;
    private UserRequest userRequest1;
    private User followerUser;
    private User followedByUser;

    @BeforeEach
    void setUp() {
        // Dummy users for relationship testing
        followerUser = User.builder().username("follower1").build();
        followedByUser = User.builder().username("followed1").build();

        // Main user object setup
        user1 = User.builder()
                .username("testuser1")
                .name("Test User One")
                .email("test1@example.com")
                .description("Desc 1")
                .avatar_url("url1")
                // Initialize the Sets with test data
                .followers(new HashSet<>(Set.of(followerUser))) // 1 follower
                .following(new HashSet<>(Set.of(followedByUser, followerUser))) // 2 following
                .build();

        // DTO for creation request
        userRequest1 = UserRequest.builder()
                .username("testuser1")
                .name("Test User One")
                .email("test1@example.com")
                .description("Desc 1")
                .avatar_url("url1")
                .build();
    }

    // --- createUser Tests ---

    @Test
    @DisplayName("Should create user successfully when username is unique")
    void createUser_Success() {
        // Arrange
        when(userRepository.existsById(userRequest1.getUsername())).thenReturn(false);

        // Act
        userService.createUser(userRequest1);

        // Assert
        verify(userRepository, times(1)).existsById(userRequest1.getUsername());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when username already exists")
    void createUser_UserExists_Failure() {
        // Arrange
        when(userRepository.existsById(userRequest1.getUsername())).thenReturn(true);

        // Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(userRequest1);
        });

        assertEquals("User with username " + userRequest1.getUsername() + " already exists.", thrown.getMessage());
        verify(userRepository, times(1)).existsById(userRequest1.getUsername());
        verify(userRepository, never()).save(any(User.class));
    }

    // --- getUser Tests ---

    @Test
    @DisplayName("Should return UserResponse with correct relationship counts when user is found")
    void getUser_UserFound_Success() {
        // Arrange
        String username = "testuser1";
        when(userRepository.findById(username)).thenReturn(Optional.of(user1));

        // Act
        UserResponse response = userService.getUser(username);

        // Assert
        assertNotNull(response);
        assertEquals(username, response.getUsername());
        // Check that the Set sizes are mapped correctly (assuming UserResponse also has Set<User> fields)
        assertEquals(user1.getFollowers().size(), response.getFollowers().size()); // Expect 1 follower
        assertEquals(user1.getFollowing().size(), response.getFollowing().size()); // Expect 2 following
        verify(userRepository, times(1)).findById(username);
    }

    @Test
    @DisplayName("Should throw NoSuchElementException when user is not found by username")
    void getUser_UserNotFound_Failure() {
        // Arrange
        String nonExistentUsername = "nonexistent";
        when(userRepository.findById(nonExistentUsername)).thenReturn(Optional.empty());

        // Act & Assert
        NoSuchElementException thrown = assertThrows(NoSuchElementException.class, () -> {
            userService.getUser(nonExistentUsername);
        });

        assertEquals("User not found with username: " + nonExistentUsername, thrown.getMessage());
        verify(userRepository, times(1)).findById(nonExistentUsername);
    }

    // --- getAllUsers Tests (Paginated) ---

    @Test
    @DisplayName("Should return paginated response with correct data and metadata")
    void getAllUsers_Success() {
        // Arrange
        String currentUsername = "currentuser";
        int page = 0;
        int size = 10;
        String query = "";
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "username"));

        User user2 = User.builder().username("user2").name("User Two").build();
        List<User> userList = Arrays.asList(user1, user2);
        Page<User> userPage = new PageImpl<>(userList, pageable, 100);

        when(userRepository.searchAllExcludingCurrent(currentUsername, query, pageable)).thenReturn(userPage);

        // Act
        PaginatedResponse<UserResponse> response = userService.getAllUsers(currentUsername, page, size, query);

        // Assert
        assertNotNull(response);
        assertEquals(2, response.getData().size());
        assertEquals(page, response.getCurrentPage());
        assertEquals(10, response.getTotalPages());
        assertEquals(100, response.getTotalItems());
        assertEquals("testuser1", response.getData().get(0).getUsername());
        verify(userRepository, times(1)).searchAllExcludingCurrent(currentUsername, query, pageable);
    }

    @Test
    @DisplayName("Should return empty paginated response when no users are found")
    void getAllUsers_EmptyResult() {
        // Arrange
        String currentUsername = "currentuser";
        int page = 0;
        int size = 10;
        String query = "nonexistent";
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "username"));

        Page<User> userPage = new PageImpl<>(Collections.emptyList(), pageable, 0);

        when(userRepository.searchAllExcludingCurrent(currentUsername, query, pageable)).thenReturn(userPage);

        // Act
        PaginatedResponse<UserResponse> response = userService.getAllUsers(currentUsername, page, size, query);

        // Assert
        assertNotNull(response);
        assertTrue(response.getData().isEmpty());
        assertEquals(0, response.getTotalItems());
        assertEquals(0, response.getTotalPages());
        verify(userRepository, times(1)).searchAllExcludingCurrent(currentUsername, query, pageable);
    }

    // --- getAllUsersNotPaginated Tests ---

    @Test
    @DisplayName("Should return list of users excluding the current user, not paginated")
    void getAllUsersNotPaginated_Success() {
        // Arrange
        String currentUsername = "testuser1";
        String query = "test";
        User user2 = User.builder().username("testuser2").name("Test User Two").build();
        User user3 = User.builder().username("testuser3").name("Test User Three").build();
        // Repository returns all users matching the query, including the current one.
        List<User> repositoryResult = Arrays.asList(user1, user2, user3);

        when(userRepository.searchAllExcludingCurrentNonPaginated(currentUsername, query)).thenReturn(repositoryResult);

        // Act
        List<UserResponse> response = userService.getAllUsersNotPaginated(currentUsername, query);

        // Assert
        assertNotNull(response);
        // The list should contain only user2 and user3, as user1 (current user) is filtered out in the service layer.
        assertEquals(2, response.size());
        assertEquals("testuser2", response.get(0).getUsername());
        assertEquals("testuser3", response.get(1).getUsername());
        verify(userRepository, times(1)).searchAllExcludingCurrentNonPaginated(currentUsername, query);
    }

    @Test
    @DisplayName("Should return empty list when only the current user is found in non-paginated search")
    void getAllUsersNotPaginated_OnlyCurrentUserFound() {
        // Arrange
        String currentUsername = "testuser1";
        String query = "unique";

        // Repository returns only the current user (who will be filtered out)
        when(userRepository.searchAllExcludingCurrentNonPaginated(currentUsername, query)).thenReturn(Collections.singletonList(user1));

        // Act
        List<UserResponse> response = userService.getAllUsersNotPaginated(currentUsername, query);

        // Assert
        assertNotNull(response);
        assertTrue(response.isEmpty());
        verify(userRepository, times(1)).searchAllExcludingCurrentNonPaginated(currentUsername, query);
    }

    // --- populateUsers Tests ---

    @Test
    @DisplayName("Should save a batch of 1000 dummy users")
    void populateUsers_SavesBatch() {
        // Act
        userService.populateUsers();

        verify(userRepository, times(1)).saveAll(argThat(list -> {
            if (list instanceof List) {
                return ((List<?>) list).size() == 1000;
            }
            return false;
        }));
    }
}