package com.hikerzactivity.hikerzactivity.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class UserMicroserviceClient {

    private final RestTemplate restTemplate;
    private final String userServiceUrl;

    public UserMicroserviceClient(RestTemplate restTemplate, 
                                  @Value("${user.service.url:http://localhost:8090}") String userServiceUrl) {
        this.restTemplate = restTemplate;
        this.userServiceUrl = userServiceUrl;
    }

    public List<String> getFollowing(String username) {
        try {
            String url = userServiceUrl + "/api/follow/" + username + "/following";
            ResponseEntity<FollowersResponse> response = restTemplate.getForEntity(
                url,
                FollowersResponse.class
            );
            
            if (response.getBody() != null && response.getBody().getFollowers() != null) {
                return response.getBody().getFollowers().stream()
                    .map(UserDto::getUsername)
                    .collect(Collectors.toList());
            }
            return new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    static class FollowersResponse {
        private List<UserDto> followers;
        
        public List<UserDto> getFollowers() { return followers; }
        public void setFollowers(List<UserDto> followers) { this.followers = followers; }
    }
    
    static class UserDto {
        private String username;
        private String name;
        private String email;
        private String description;
        private String avatar_url;
        
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
    }
}