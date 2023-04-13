package com.example.springbootRestApi.service;

import com.example.springbootRestApi.entity.Employee;
import com.example.springbootRestApi.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements IService{

    @Autowired
    private Repo repo;

    @Override
    public Employee addEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee emp = getEmployeeById(id);
        emp.setName(employee.getName());
        emp.setSalary(employee.getSalary());
        repo.save(emp);
        return emp;
    }

    @Override
    public void removeEmployee(Long id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> emp =repo.findById(id);
        if(emp.isPresent()){
            return emp.get();
        }
        return null;
    }
}
