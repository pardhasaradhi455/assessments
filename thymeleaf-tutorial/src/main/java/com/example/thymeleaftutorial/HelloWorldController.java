package com.example.thymeleaftutorial;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World");
        return "helloworld";
    }

    @GetMapping("/style")
    public String showStyle(Model model) {
        return "add-css-js-demo";
    }

    @GetMapping("/bootstrap")
    public String showBootsrap(Model model) {
        return "add-bootstrap";
    }

    @GetMapping("/iteration")
    public String showIteration(Model model) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("rahul",30,2002,"ADMIN"));
        employees.add(new Employee("ramesh",28,2003,"USER"));
        employees.add(new Employee("raj",25,2004,"USER"));
        model.addAttribute("employees",employees);
        return "iteration";
    }

    @GetMapping("/if")
    public String ifCase(Model model) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("rahul",30,2002,"ADMIN"));
        employees.add(new Employee("ramesh",28,2003,"USER"));
        employees.add(new Employee("raj",25,2004,"USER"));
        model.addAttribute("employees",employees);
        return "if";
    }

    @GetMapping("/switch")
    public String switchCase(Model model) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("rahul",30,2002,"ADMIN"));
        employees.add(new Employee("ramesh",28,2003,"USER"));
        employees.add(new Employee("raj",25,2004,"USER"));
        model.addAttribute("employees",employees);
        return "switch-case";
    }
}
