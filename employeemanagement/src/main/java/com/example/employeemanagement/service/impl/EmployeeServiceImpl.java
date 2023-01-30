package com.example.employeemanagement.service.impl;

import com.example.employeemanagement.pojo.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository producerRepository) {
        this.employeeRepository = producerRepository;
    }

    @Override
    public List<Employee> getAllEmp() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmpById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee addEmp(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public void deleteEmpById(Long id) {
        Employee emp =  employeeRepository.getOne(id);
        employeeRepository.delete(emp);
    }
}
