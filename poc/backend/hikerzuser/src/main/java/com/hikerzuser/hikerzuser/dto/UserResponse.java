package com.hikerzuser.hikerzuser.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hikerzuser.hikerzuser.model.User;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class UserResponse {
    private String username;
    private String name;
    private String email;
    private String description;
    private String avatar_url;

    private Set<User> following;
    private Set<User> followers;
}
