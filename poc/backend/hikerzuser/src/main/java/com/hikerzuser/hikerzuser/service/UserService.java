package com.hikerzuser.hikerzuser.service;
import com.hikerzuser.hikerzuser.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.stereotype.Service;
import com.hikerzuser.hikerzuser.model.User;
import com.hikerzuser.hikerzuser.dto.UserRequest;
import com.hikerzuser.hikerzuser.dto.UserResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public void createUser(UserRequest userRequest){
        User user = User.builder().title(userRequest.getTitle()).description(userRequest.getDescription()).build();
        userRepository.save(user);
        log.info("User {} is saved", user.getId());
    }

    public List<UserResponse> getAllUsers(){
        List<User> users = userRepository.findAll(); 
        return users.stream().map(user -> maoToUserResponse(user)).toList();
    }

    private UserResponse maoToUserResponse(User user){
        return UserResponse.builder().id(user.getId()).title(user.getTitle()).description(user.getDescription()).build();
    }
}
