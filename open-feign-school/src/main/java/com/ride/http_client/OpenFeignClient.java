package com.ride.http_client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "student-service", url = "${application.config.student-url}")
public interface OpenFeignClient {

    @GetMapping("/{school-id}")
    List<Student> findAllStudentsBySchool(
            @PathVariable("school-id") Integer schoolId,
            @RequestHeader("Accept") String acceptHeader
    );
}