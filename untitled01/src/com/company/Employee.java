package com.company;

import java.util.Date;

public class Employee extends User {

    private Role role;
    private double salary;

    public Employee(Integer id, String username, String password, Date birthDate, Gender gender, Role role, double salary) {
        super(id, username, password, birthDate, gender);
        this.role = role;
        this.salary = salary;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}


