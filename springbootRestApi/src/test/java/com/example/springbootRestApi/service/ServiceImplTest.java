package com.example.springbootRestApi.service;

import com.example.springbootRestApi.entity.Employee;
import com.example.springbootRestApi.repository.Repo;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServiceImplTest {

    @Autowired
    IService service;

    @MockBean
    Repo repository;

    @Test
    void addEmployee() {

        Employee employee = Employee.builder()
                .name("pardha")
                .salary(25000)
                .build();

        Mockito.when(repository.save(employee)).thenReturn(employee);

        assertEquals(employee,service.addEmployee(employee));
    }

    @Test
    void getEmployeeById() {
        Employee employee = Employee.builder()
                .name("pardha")
                .salary(25000)
                .build();

        Mockito.when(repository.findById(1l)).thenReturn(Optional.of(employee));

        assertEquals(employee,service.getEmployeeById(1l));
    }

    @Test
    void getAllEmployees() {
        Employee employee = Employee.builder()
                .name("pardha")
                .salary(25000)
                .build();

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        Mockito.when(repository.findAll()).thenReturn(employees);

        assertEquals(employees,service.getAllEmployees());
    }

    @Test
    void updateEmployee() {
        Employee employee = Employee.builder()
                .name("pardha")
                .salary(25000)
                .build();

        Mockito.when(repository.findById(1l)).thenReturn(Optional.of(employee));

        employee.setSalary(30000);

        Mockito.when(repository.save(employee)).thenReturn(employee);

        assertEquals(service.updateEmployee(employee,1l),employee);

    }

    @Test
    void removeEmployee() {
        Employee employee = Employee.builder()
                .name("pardha")
                .salary(25000)
                .build();

        Mockito.when((repository.existsById(1l))).thenReturn(false);
        assertFalse(repository.existsById(1l));
    }

}