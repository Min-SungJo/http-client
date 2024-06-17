package com.ride.http_client;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ApacheHttpClient {

    @Value("${application.config.student-url}")
    private String studentUrl;
    private final CloseableHttpClient client;
    private final ObjectMapper objectMapper;

    public List<Student> findAllStudentsBySchool(Integer schoolId) {
        HttpGet request = new HttpGet(studentUrl + "/" + schoolId);

        request.addHeader("Accept", "application/json");

        try (CloseableHttpResponse response = client.execute(request)) {
            String responseBody = EntityUtils.toString(response.getEntity());
            return objectMapper.readValue(
                    responseBody,
                    objectMapper
                            .getTypeFactory()
                            .constructCollectionType(
                                    List.class,
                                    Student.class
                            )
            );
        } catch (IOException | ParseException e) {
            throw new RuntimeException("Failed to fetch students", e);
        }
    }
}
