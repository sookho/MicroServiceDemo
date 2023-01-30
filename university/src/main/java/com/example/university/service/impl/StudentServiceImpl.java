package com.example.university.service.impl;

import com.example.university.pojo.Student;
import com.example.university.repository.StudentRepository;
import com.example.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStd() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStdById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Student addStd(Student std) {
        return studentRepository.save(std);
    }

    @Override
    @Transactional
    public void deleteStdById(Long id) {
        Student std = getStdById(id);
        studentRepository.delete(std);
    }
}
