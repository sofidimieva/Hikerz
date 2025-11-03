package com.hikerzactivity.hikerzactivity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ActivityRequest {
    private String userId;
    private String title;
    private String description;
}
