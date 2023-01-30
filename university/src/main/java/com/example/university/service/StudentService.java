package com.example.university.service;

import com.example.university.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStd();
    Student getStdById(Long id);
    Student addStd(Student std);
    void deleteStdById(Long id);
}
