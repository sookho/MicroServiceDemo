package com.example.search.service;

import com.example.search.pojo.Employee;
import com.example.search.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class SearchService {
    private final RestTemplate restTemplate;

    @Autowired
    public SearchService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Async
    public CompletableFuture<Student> findStd(Long id){
//        String urlStd = "http://localhost:9002/student/";
        String urlStd = "http://university/student/";
        String url = urlStd + id;
        Student result = restTemplate.getForObject(url, Student.class);
        return CompletableFuture.completedFuture(result);
    }

    @Async
    public CompletableFuture<Employee> findEmp(Long id){
//        String urlEmp = "http://localhost:9001/employee/";
        String urlEmp = "http://employment/employee/";
        String url = urlEmp + id;
        Employee result = restTemplate.getForObject(url, Employee.class);
        return CompletableFuture.completedFuture(result);
    }
}
