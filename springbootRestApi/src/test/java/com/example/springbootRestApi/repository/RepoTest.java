package com.example.springbootRestApi.repository;

import com.example.springbootRestApi.entity.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RepoTest {

    @Autowired
    private Repo repo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveEmployeeTest(){

        Employee employee = Employee.builder()
                .name("pardha")
                .salary(25000)
                .build();

        repo.save(employee);

        Assertions.assertThat(employee.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void getEmployeeByIdTest(){

        Employee employee = repo.findById(1l).get();

        Assertions.assertThat(employee.getId()).isEqualTo(1l);

    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void getAllEmployeesTest(){

        List<Employee> employees = repo.findAll();

        Assertions.assertThat(employees.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateEmployeeTest(){

        Employee employee = repo.findById(1l).get();

        employee.setSalary(30000);

        Employee updated = repo.save(employee);

        Assertions.assertThat(updated.getSalary()).isEqualTo(30000);

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteEmployeeTest(){

        Employee employee = repo.findById(1l).get();

        repo.delete(employee);

        List<Employee> employees = repo.findAll();

        Assertions.assertThat(employees.size()).isEqualTo(0);

    }

}