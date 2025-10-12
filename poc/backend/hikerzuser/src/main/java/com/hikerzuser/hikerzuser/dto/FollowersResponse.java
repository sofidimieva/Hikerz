package com.hikerzuser.hikerzuser.dto;

import com.hikerzuser.hikerzuser.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class FollowersResponse {
    private List<User> followers;
}