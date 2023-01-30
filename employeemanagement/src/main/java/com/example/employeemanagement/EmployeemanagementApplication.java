package com.example.employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmployeemanagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeemanagementApplication.class, args);
    }
}
