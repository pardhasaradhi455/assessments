package com.example.thymeleafUsingSpringboot.controller;

import com.example.thymeleafUsingSpringboot.entity.Employee;
import com.example.thymeleafUsingSpringboot.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class EmployeeController {

    @Autowired
    IService service;

    @GetMapping("/index")
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", service.getAllEmployees());
        return "index";
    }

    @GetMapping("/add")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add-employee";
    }

    @PostMapping("/index")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        service.addEmployee(employee);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String getUpdateForm(Model model, @PathVariable Long id){
        Employee employee = service.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "update-employee";
    }

    @PostMapping("/index/{id}")
    public String updateEmployee(Model model, @PathVariable Long id, @ModelAttribute("employee") Employee employee){
        Employee existingEmployee = service.getEmployeeById(id);
        existingEmployee.setEmployeeId(id);
        existingEmployee.setEmployeeName(employee.getEmployeeName());
        existingEmployee.setEmployeeSalary(employee.getEmployeeSalary());
        service.addEmployee(existingEmployee);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(Model model,@PathVariable Long id){
        service.removeEmployee(id);
        return "redirect:/index";
    }

}
