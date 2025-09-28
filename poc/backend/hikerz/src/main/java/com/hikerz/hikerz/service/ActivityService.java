package com.hikerz.hikerz.service;
import com.hikerz.hikerz.repository.ActivityRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.stereotype.Service;
import com.hikerz.hikerz.model.Activity;
import com.hikerz.hikerz.dto.ActivityRequest;
import com.hikerz.hikerz.dto.ActivityResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityService {

    private final ActivityRepository activityRepository;

    public void createActivity(ActivityRequest activityrequest){
        Activity activity = Activity.builder().title(activityrequest.getTitle()).description(activityrequest.getDescription()).build();
        activityRepository.save(activity);
        log.info("Activity {} is saved", activity.getId());
    }

    public List<ActivityResponse> getAllActivities(){
        List<Activity> activities = activityRepository.findAll(); 
        return activities.stream().map(activity -> mapToActivityResponse(activity)).toList();
    }

    private ActivityResponse mapToActivityResponse(Activity activity){
        return ActivityResponse.builder().id(activity.getId()).title(activity.getTitle()).description(activity.getDescription()).build();
    }
}
