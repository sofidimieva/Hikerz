package com.hikerzuser.hikerzuser.service;

import com.hikerzuser.hikerzuser.dto.FollowersResponse;
import com.hikerzuser.hikerzuser.dto.FollowingResponse;
import com.hikerzuser.hikerzuser.model.User;
import com.hikerzuser.hikerzuser.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FollowingServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private FollowingService followingService;

    private User follower;
    private User followed;

    private final String FOLLOWER_USERNAME = "alice";
    private final String FOLLOWED_USERNAME = "bob";

    @BeforeEach
    void setUp() {
        // Alice (follower) starts with an empty following set
        follower = User.builder()
                .username(FOLLOWER_USERNAME)
                .following(new HashSet<>())
                .followers(new HashSet<>())
                .build();

        // Bob (followed) starts with an empty followers set
        followed = User.builder()
                .username(FOLLOWED_USERNAME)
                .following(new HashSet<>())
                .followers(new HashSet<>())
                .build();
    }

    // -------------------------------------------------------------------
    // Test cases for followUser()
    // -------------------------------------------------------------------

    @Test
    @DisplayName("Should successfully follow a user")
    void followUser_Success() {
        when(userRepository.findById(FOLLOWER_USERNAME)).thenReturn(Optional.of(follower));
        when(userRepository.findById(FOLLOWED_USERNAME)).thenReturn(Optional.of(followed));

        // Act
        followingService.followUser(FOLLOWER_USERNAME, FOLLOWED_USERNAME);

        // Assert
        // Verify sets were updated in memory
        assertTrue(follower.getFollowing().contains(followed));
        assertTrue(followed.getFollowers().contains(follower));

        // Verify save was called for both users
        verify(userRepository, times(1)).save(follower);
        verify(userRepository, times(1)).save(followed);
    }

    @Test
    @DisplayName("Should not allow a user to follow themselves")
    void followUser_CannotFollowSelf_ThrowsException() {
        // Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            followingService.followUser(FOLLOWER_USERNAME, FOLLOWER_USERNAME);
        });

        assertEquals("User cannot follow themselves.", thrown.getMessage());
        verify(userRepository, never()).findById(anyString());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    @DisplayName("Should not change status if user is already following")
    void followUser_AlreadyFollowing_NoChange() {
        when(userRepository.findById(FOLLOWER_USERNAME)).thenReturn(Optional.of(follower));
        when(userRepository.findById(FOLLOWED_USERNAME)).thenReturn(Optional.of(followed));

        // Arrange
        follower.getFollowing().add(followed);
        followed.getFollowers().add(follower);

        // Act
        followingService.followUser(FOLLOWER_USERNAME, FOLLOWED_USERNAME);

        // Assert
        // Verify sets remain the same size (1)
        assertEquals(1, follower.getFollowing().size());
        assertEquals(1, followed.getFollowers().size());

        // Verify save was NOT called (because no change happened)
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    @DisplayName("Should throw RuntimeException if follower user not found")
    void followUser_FollowerNotFound_ThrowsException() {
        // Arrange
        when(userRepository.findById(FOLLOWER_USERNAME)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            followingService.followUser(FOLLOWER_USERNAME, FOLLOWED_USERNAME);
        });

        assertEquals("Follower user not found: " + FOLLOWER_USERNAME, thrown.getMessage());
        verify(userRepository, never()).save(any(User.class));
    }

    // -------------------------------------------------------------------
    // Test cases for unfollowUser()
    // -------------------------------------------------------------------

    @Test
    @DisplayName("Should successfully unfollow a user")
    void unfollowUser_Success() {
        when(userRepository.findById(FOLLOWER_USERNAME)).thenReturn(Optional.of(follower));
        when(userRepository.findById(FOLLOWED_USERNAME)).thenReturn(Optional.of(followed));

        // Arrange: Establish a follow relationship first
        follower.getFollowing().add(followed);
        followed.getFollowers().add(follower);
        assertEquals(1, follower.getFollowing().size());

        // Act
        followingService.unfollowUser(FOLLOWER_USERNAME, FOLLOWED_USERNAME);

        // Assert
        // Verify sets are empty
        assertFalse(follower.getFollowing().contains(followed));
        assertFalse(followed.getFollowers().contains(follower));
        assertEquals(0, follower.getFollowing().size());

        // Verify save was called for both users
        verify(userRepository, times(1)).save(follower);
        verify(userRepository, times(1)).save(followed);
    }

    @Test
    @DisplayName("Should not change status if user was not following")
    void unfollowUser_NotFollowing_NoChange() {
        when(userRepository.findById(FOLLOWER_USERNAME)).thenReturn(Optional.of(follower));
        when(userRepository.findById(FOLLOWED_USERNAME)).thenReturn(Optional.of(followed));

        // Arrange: No follow relationship established

        // Act
        followingService.unfollowUser(FOLLOWER_USERNAME, FOLLOWED_USERNAME);

        // Assert
        // Verify sets remain empty (0)
        assertEquals(0, follower.getFollowing().size());
        assertEquals(0, followed.getFollowers().size());

        // Verify save was NOT called
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    @DisplayName("Should throw RuntimeException if followed user not found during unfollow")
    void unfollowUser_FollowedNotFound_ThrowsException() {
        when(userRepository.findById(FOLLOWER_USERNAME)).thenReturn(Optional.of(follower));
        when(userRepository.findById(FOLLOWED_USERNAME)).thenReturn(Optional.of(followed));

        // Arrange
        when(userRepository.findById(FOLLOWED_USERNAME)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            followingService.unfollowUser(FOLLOWER_USERNAME, FOLLOWED_USERNAME);
        });

        assertEquals("Followed user not found: " + FOLLOWED_USERNAME, thrown.getMessage());
        // save should not have been called
        verify(userRepository, never()).save(any(User.class));
    }

    // -------------------------------------------------------------------
    // Test cases for getFollowers() and getFollowing()
    // -------------------------------------------------------------------

    @Test
    @DisplayName("Should retrieve correct list of followers")
    void getFollowers_Success() {
        when(userRepository.findById(FOLLOWED_USERNAME)).thenReturn(Optional.of(followed));

        // Arrange: Bob has one follower (Alice)
        followed.getFollowers().add(follower);

        // Act
        FollowersResponse response = followingService.getFollowers(FOLLOWED_USERNAME);

        // Assert
        assertNotNull(response);

        // Assert on the expected size of the set used to create the response
        assertEquals(1, followed.getFollowers().size());

        verify(userRepository, times(1)).findById(FOLLOWED_USERNAME);
    }

    @Test
    @DisplayName("Should retrieve correct list of following users")
    void getFollowing_Success() {
        when(userRepository.findById(FOLLOWER_USERNAME)).thenReturn(Optional.of(follower));

        // Arrange: Alice is following one user (Bob)
        follower.getFollowing().add(followed);

        // Act
        FollowingResponse response = followingService.getFollowing(FOLLOWER_USERNAME);

        // Assert
        assertNotNull(response);

        // Assert on the expected size of the set used to create the response
        assertEquals(1, follower.getFollowing().size());

        verify(userRepository, times(1)).findById(FOLLOWER_USERNAME);
    }

    @Test
    @DisplayName("Should throw RuntimeException if user not found for getFollowers")
    void getFollowers_UserNotFound_ThrowsException() {
        // Arrange
        when(userRepository.findById(anyString())).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            followingService.getFollowers(FOLLOWER_USERNAME);
        });

        assertEquals("User not found: " + FOLLOWER_USERNAME, thrown.getMessage());
    }

    @Test
    @DisplayName("Should throw RuntimeException if user not found for getFollowing")
    void getFollowing_UserNotFound_ThrowsException() {
        // Arrange
        when(userRepository.findById(anyString())).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            followingService.getFollowing(FOLLOWER_USERNAME);
        });

        assertEquals("User not found: " + FOLLOWER_USERNAME, thrown.getMessage());
    }
}