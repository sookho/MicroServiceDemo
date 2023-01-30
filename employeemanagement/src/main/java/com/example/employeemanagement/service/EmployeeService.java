package com.example.employeemanagement.service;

import com.example.employeemanagement.pojo.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getAllEmp();
    Employee getEmpById(Long id);
    Employee addEmp(Employee emp);
    void deleteEmpById(Long id);
}
