package com.hikerzactivity.hikerzactivity.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.ArrayList;

@Component
public class UserMicroserviceClient {

    private final RestTemplate restTemplate;
    private final String userServiceUrl;

    public UserMicroserviceClient(RestTemplate restTemplate, 
                                  @Value("${user.service.url:http://localhost:8081}") String userServiceUrl) {
        this.restTemplate = restTemplate;
        this.userServiceUrl = userServiceUrl;
    }

    public List<String> getFollowing(String username) {
        try {
            String url = userServiceUrl + "/api/users/" + username + "/following";
            ResponseEntity<List<String>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {}
            );
            return response.getBody();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}