package com.hikerzuser.hikerzuser.service;

import com.hikerzuser.hikerzuser.dto.FollowersResponse;
import com.hikerzuser.hikerzuser.dto.FollowingResponse;
import com.hikerzuser.hikerzuser.model.User;
import com.hikerzuser.hikerzuser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Slf4j
public class FollowingService {

    private final UserRepository userRepository;

    @Transactional
    public void followUser(String followerUsername, String followedUsername) {
        if (followerUsername.equals(followedUsername)) {
            throw new IllegalArgumentException("User cannot follow themselves.");
        }

        User follower = userRepository.findById(followerUsername)
                .orElseThrow(() -> new RuntimeException("Follower user not found: " + followerUsername));
        User followed = userRepository.findById(followedUsername)
                .orElseThrow(() -> new RuntimeException("Followed user not found: " + followedUsername));

        if (!follower.getFollowing().add(followed)) {

            log.warn("User {} is already following User {}", followerUsername, followedUsername);
            return;
        }

        followed.getFollowers().add(follower);

        userRepository.save(follower);
        userRepository.save(followed);

        log.info("User {} followed User {}", followerUsername, followedUsername);
    }

    @Transactional
    public void unfollowUser(String followerUsername, String followedUsername) {
        User follower = userRepository.findById(followerUsername)
                .orElseThrow(() -> new RuntimeException("Follower user not found: " + followerUsername));
        User followed = userRepository.findById(followedUsername)
                .orElseThrow(() -> new RuntimeException("Followed user not found: " + followedUsername));

        if (!follower.getFollowing().remove(followed)) {
            log.warn("User {} was not following User {}", followerUsername, followedUsername);
            return;
        }

        followed.getFollowers().remove(follower);

        userRepository.save(follower);
        userRepository.save(followed);

        log.info("User {} unfollowed User {}", followerUsername, followedUsername);
    }

    public FollowersResponse getFollowers(String username) {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username));

        return new FollowersResponse(
                new ArrayList<>(user.getFollowers())
        );
    }

    public FollowingResponse getFollowing(String username) {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username));

        return new FollowingResponse(
                new ArrayList<>(user.getFollowing())
        );
    }
}