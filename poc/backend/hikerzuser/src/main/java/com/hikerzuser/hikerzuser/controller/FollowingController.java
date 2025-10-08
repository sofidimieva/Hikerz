package com.hikerzuser.hikerzuser.controller;

import com.hikerzuser.hikerzuser.dto.FollowersResponse;
import com.hikerzuser.hikerzuser.dto.FollowingResponse;
import com.hikerzuser.hikerzuser.service.FollowingService;
import com.hikerzuser.hikerzuser.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/follow")
@RequiredArgsConstructor
public class FollowingController {

    private final FollowingService followingService;

    @PostMapping("/{username}/follow/{followUsername}")
    @ResponseStatus(HttpStatus.OK)
    public void followUser(@PathVariable String username, @PathVariable String followUsername) {
        followingService.followUser(username, followUsername);
    }

    @DeleteMapping("/{username}/unfollow/{followUsername}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unfollowUser(@PathVariable String username, @PathVariable String followUsername) {
        followingService.unfollowUser(username, followUsername);
    }

    @GetMapping("/{username}/followers/{followUsername}")
    @ResponseStatus(HttpStatus.OK)
    public FollowersResponse getFollowers(@PathVariable String username) {
        return followingService.getFollowers(username);
    }

    @GetMapping("/{username}/following/{followUsername}")
    @ResponseStatus(HttpStatus.OK)
    public FollowingResponse getFollowing(@PathVariable String username) {
        return followingService.getFollowing(username);
    }
}