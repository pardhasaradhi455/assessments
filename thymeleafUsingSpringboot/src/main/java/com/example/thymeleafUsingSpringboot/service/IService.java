package com.example.thymeleafUsingSpringboot.service;

import com.example.thymeleafUsingSpringboot.entity.Employee;

import java.util.List;

public interface IService {
    Employee addEmployee(Employee employee);

    void removeEmployee(Long id);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

}
