package com.hikerzuser.hikerzuser.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserRequest {
    private String username;
    private String name;
    private String email;
    private String description;
    private String avatar_url;
}
