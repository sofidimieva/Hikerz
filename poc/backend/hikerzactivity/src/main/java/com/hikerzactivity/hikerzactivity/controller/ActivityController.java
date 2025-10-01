package com.hikerzactivity.hikerzactivity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hikerzactivity.hikerzactivity.dto.ActivityRequest;
import com.hikerzactivity.hikerzactivity.dto.ActivityResponse;
import com.hikerzactivity.hikerzactivity.service.ActivityService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;



@RestController
@RequestMapping("/api/activity")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createActivity(@RequestBody ActivityRequest activityRequest) {
        
        activityService.createActivity(activityRequest);;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ActivityResponse> getAllActivities() {
        return activityService.getAllActivities();
    }
    
    
}
