package com.hikerzactivity.hikerzactivity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ActivityResponse {
    private Long id;
    private String title;
    private String description;
}
