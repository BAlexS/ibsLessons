package com.example.ibs.logic;

public class User {

    private String name;
    private String surname;
    private double salary;

    public User(String name2, String surname2, double salary2) {
        this.name = name2;
        this.surname = surname2;
        this.salary = salary2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String name) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
