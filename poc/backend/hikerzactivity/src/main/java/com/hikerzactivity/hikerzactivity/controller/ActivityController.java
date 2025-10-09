package com.hikerzactivity.hikerzactivity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hikerzactivity.hikerzactivity.dto.ActivityRequest;
import com.hikerzactivity.hikerzactivity.dto.ActivityResponse;
import com.hikerzactivity.hikerzactivity.service.ActivityService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/upload-gpx")
    public ResponseEntity<?> uploadGpx(@RequestParam("file") MultipartFile file) throws Exception {
        activityService.importGpx(file);
        return ResponseEntity.ok("GPX uploaded");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ActivityResponse> getAllActivities() {
        return activityService.getAllActivities();
    }

    @GetMapping("/{id}/geojson")
    public ResponseEntity<String> getHikeGeoJson(@PathVariable Long id) {
        String geoJson = activityService.getHikeAsGeoJson(id);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(geoJson);
    }

    @GetMapping("/{id}/mapbox-static")
    public ResponseEntity<byte[]> getHikeStatic(@PathVariable Long id,
                                                @RequestParam(defaultValue = "800") int w,
                                                @RequestParam(defaultValue = "600") int h) {
        byte[] png = activityService.getMapboxStaticPng(id, w, h);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(png);
    }
    
    
}
