package com.example.springbootRestApi.repository;

import com.example.springbootRestApi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<Employee, Long> {
}
