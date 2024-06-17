package com.ride.http_client;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Component
@RequiredArgsConstructor
public class HttpUrlConnectionClient {
    @Value("${application.config.student-url}")
    private String studentUrl;
    private final ObjectMapper objectMapper;

    public List<Student> findAllStudentBySchool(Integer schoolId) {
        try {
            URL url = new URL(studentUrl + "/" + schoolId);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            conn.setRequestProperty("Accept", "application/json");

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder response = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                response.append(output);
            }

            conn.disconnect();

            return objectMapper
                    .readValue(
                            response.toString(),
                            objectMapper.getTypeFactory()
                                    .constructCollectionType(
                                            List.class,
                                            Student.class
                                    )
                    );
        } catch (Exception e) {
            throw new RuntimeException("Exception in findAllStudentBySchool", e);
        }
    }
}
