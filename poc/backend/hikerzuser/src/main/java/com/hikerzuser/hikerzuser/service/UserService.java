package com.hikerzuser.hikerzuser.service;

import com.hikerzuser.hikerzuser.dto.PaginatedResponse;
import com.hikerzuser.hikerzuser.repository.UserRepository;
import com.hikerzuser.hikerzuser.model.User;
import com.hikerzuser.hikerzuser.dto.UserRequest;
import com.hikerzuser.hikerzuser.dto.UserResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void createUser(UserRequest userRequest) {

        if (userRepository.existsById(userRequest.getUsername())) {
            throw new IllegalArgumentException("User with username " + userRequest.getUsername() + " already exists.");
        }

        User user = User.builder()
                .username(userRequest.getUsername())
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .description(userRequest.getDescription())
                .avatar_url(userRequest.getAvatar_url())
                .build();
        userRepository.save(user);
        log.info("User {} is saved", user.getUsername());
    }

    public void populateUsers() {
        // Create 40 dummy users
        List<User> users = IntStream.range(0, 1000)
                .mapToObj(i -> {
                    return User.builder()
                            .username("user" + i)
                            .name("User " + i)
                            .email("user" + i + "@example.com")
                            .description("This is a description for User " + i)
                            .avatar_url("https://randomuser.me/api/portraits/lego/" + (i % 10) + ".jpg")
                            .build();
                })
                .collect(Collectors.toList());

        // Save all users to the database in one go
        userRepository.saveAll(users);
        log.info("Populated the database with 40 users");
    }

    public PaginatedResponse<UserResponse> getAllUsers(String username, int page, int size, String q) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "username"));

        Page<User> usersPage = userRepository.searchAllExcludingCurrent(username, q, pageable);

        List<UserResponse> users = usersPage
                .map(this::mapToUserResponse)
                .getContent();

        return PaginatedResponse.<UserResponse>builder()
                .data(users)
                .currentPage(usersPage.getNumber())
                .totalPages(usersPage.getTotalPages())
                .totalItems(usersPage.getTotalElements())
                .build();
    }

    public List<UserResponse> getAllUsersNotPaginated(String username,String q) {
        List<User> users = userRepository.searchAllExcludingCurrentNonPaginated(username, q);
        return users.stream()
                .filter(user -> !user.getUsername().equals(username))
                .map(this::mapToUserResponse).toList();
    }

    public UserResponse getUser(String username) {

        User user = userRepository.findById(username)
                .orElseThrow(() -> new NoSuchElementException("User not found with username: " + username));

        return mapToUserResponse(user);
    }

    private UserResponse mapToUserResponse(User user) {

        return UserResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .description(user.getDescription())
                .avatar_url(user.getAvatar_url())
                .following(user.getFollowing())
                .followers(user.getFollowers())
                .build();
    }
}