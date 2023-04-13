package com.example.springbootRestApi.controller;

import com.example.springbootRestApi.entity.Employee;
import com.example.springbootRestApi.exceptions.ResourceNotFoundException;
import com.example.springbootRestApi.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class Controller {

    @Autowired
    IService service;

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(service.addEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(service.updateEmployee(employee,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable("id") Long id){
        validateId(id);
        service.removeEmployee(id);
        return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        validateId(id);
        return new ResponseEntity<Employee>(service.getEmployeeById(id),HttpStatus.OK);
    }

    private void validateId(Long id){
        if(service.getEmployeeById(id)==null){
            throw new ResourceNotFoundException("Resource is not found with id: " + id);
        }
    }

}
