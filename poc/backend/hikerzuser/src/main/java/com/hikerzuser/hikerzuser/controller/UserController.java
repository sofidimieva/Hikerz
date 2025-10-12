package com.hikerzuser.hikerzuser.controller;

import com.hikerzuser.hikerzuser.dto.PaginatedResponse;
import org.springframework.web.bind.annotation.*;

import com.hikerzuser.hikerzuser.dto.UserRequest;
import com.hikerzuser.hikerzuser.dto.UserResponse;
import com.hikerzuser.hikerzuser.service.UserService;

import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
    }

    @GetMapping("/single/{username}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUser(@PathVariable String username) {
        return userService.getUser(username);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String handleNotFound(NoSuchElementException ex) {
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleBadRequest(IllegalArgumentException ex) {
        return ex.getMessage();
    }

    @GetMapping("/all/{username}")
    @ResponseStatus(HttpStatus.OK)
    public PaginatedResponse<UserResponse> getAllUsers(
            @PathVariable String username,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String q) {

        String query = (q != null && !q.trim().isEmpty()) ? q.trim() : null;

        return userService.getAllUsers(username, page, size, query);
    }

}