package com.company;
import com.company.Employee;
import com.company.Gender;
import com.company.Role;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employees {
    private static List<Employee> employees;

    public Employees() {
        this.employees = new ArrayList<Employee>();
        employees.add(new Employee(101, "VishalM", "zxcvbnm", new Date(17-1-1995), Gender.MALE, Role.WORKER, 25000));
        employees.add(new Employee(102, "AshishR", "zxcvbnm", new Date(07-1-1997), Gender.MALE, Role.SUPERVISOR, 32000));
        employees.add(new Employee(103, "AniketK", "zxcvbnm", new Date(31-12-1997), Gender.MALE, Role.MANAGER, 52000));
        employees.add(new Employee(104, "AnisaS", "zxcvbnm", new Date(29-9-1996), Gender.MALE, Role.WORKER, 25000));
        employees.add(new Employee(105, "ShraddhaA", "zxcvbnm", new Date(05-12-1996), Gender.MALE, Role.WORKER, 30000));
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}