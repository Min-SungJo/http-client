package com.ride.http_client;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Student {
    private String firstname;
    private String lastname;
    private String email;
}