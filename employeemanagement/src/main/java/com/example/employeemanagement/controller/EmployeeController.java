package com.example.employeemanagement.controller;

import com.example.employeemanagement.pojo.Employee;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Employee>> getAllEmp(){
        return ResponseEntity.ok().body(employeeService.getAllEmp());
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> addEmpById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmpById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmp(@RequestBody Employee emp){
        return new ResponseEntity<>(employeeService.addEmp(emp), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public HttpStatus deleteEmp(@PathVariable Long id){
        employeeService.deleteEmpById(id);
        return HttpStatus.OK;
    }
}
