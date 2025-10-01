package com.hikerzuser.hikerzuser.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserRequest {
    private String title;
    private String description;
}
