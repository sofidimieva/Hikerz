package com.hikerz.hikerz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ActivityRequest {
    private String title;
    private String description;
}
