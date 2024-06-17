package com.ride.http_client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class School {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
}