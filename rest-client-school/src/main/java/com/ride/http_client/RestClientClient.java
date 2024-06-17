package com.ride.http_client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RestClientClient {

    @Value("${application.config.student-url}")
    private String studentUrl;
    private final RestClient.Builder restClientBuilder;

    public List<Student> findAllStudentsBySchool(Integer schoolId) {

        RestClient restClient = restClientBuilder.build();

        try {
            return restClient.get()
                    .uri(studentUrl + "/" + schoolId)
                    .header("Accept", "application/json")
                    .retrieve()
                    .body(new ParameterizedTypeReference<List<Student>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch students", e);
        }
    }
}
