package com.example.thymeleafUsingSpringboot.repository;

import com.example.thymeleafUsingSpringboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<Employee, Long> {
}
