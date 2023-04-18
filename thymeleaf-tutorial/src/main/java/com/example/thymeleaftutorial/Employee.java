package com.example.thymeleaftutorial;

public class Employee {
    private String name;
    private int age;
    private int id;

    private String role;

    public Employee(){

    }
    public Employee(String name, int age, int id, String role) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
