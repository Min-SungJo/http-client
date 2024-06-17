package com.ride.http_client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
@RequiredArgsConstructor
public class WebClientClient {

    @Value("${application.config.student-url}")
    private String studentUrl;
    private final WebClient.Builder webClientBuilder;

    public List<Student> findAllStudentsBySchool(Integer schoolId) {

        WebClient webClient = webClientBuilder.build();
        try {
            return webClient.get()
                    .uri(studentUrl + "/" + schoolId)
                    .header("Accept", "application/json")
                    .retrieve()
                    .bodyToFlux(Student.class)
                    .collectList()
                    .block();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch students", e);
        }
    }
}
