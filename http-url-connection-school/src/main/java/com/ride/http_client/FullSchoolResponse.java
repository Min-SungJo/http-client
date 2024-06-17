package com.ride.http_client;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class FullSchoolResponse {
    private String name;
    private String email;
    List<Student> students;
}
