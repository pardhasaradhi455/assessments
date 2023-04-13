package com.example.springbootRestApi.service;

import com.example.springbootRestApi.entity.Employee;

import java.util.List;

public interface IService {
    Employee addEmployee(Employee employee);

    Employee updateEmployee(Employee employee, Long id);

    void removeEmployee(Long id);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

}
