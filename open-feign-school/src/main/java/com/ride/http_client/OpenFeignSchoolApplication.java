package com.ride.http_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpenFeignSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenFeignSchoolApplication.class, args);
	}

}