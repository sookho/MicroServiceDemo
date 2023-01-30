package com.example.university.controller;

import com.example.university.pojo.Student;
import com.example.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Student>> getAllStd(){
        return ResponseEntity.ok().body(studentService.getAllStd());
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStdById(@PathVariable Long id){
        return ResponseEntity.ok().body(studentService.getStdById(id));
    }

    @PostMapping()
    public ResponseEntity<Student> addStd(@RequestBody Student std){
        return new ResponseEntity<>(studentService.addStd(std), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public HttpStatus getAllStd(@PathVariable Long id){
        studentService.deleteStdById(id);
        return HttpStatus.OK;
    }
}
