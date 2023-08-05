package com.designpatterns.builderpattern;

import java.math.BigInteger;

public class Employee {
    private Integer id;
    private String name;
    private String department;
    private BigInteger salary;

    public static class Builder {
        public Employee employee = new Employee();

        public Builder id(Integer id){
            employee.id = id;
            return this;
        }
        public  Builder name(String name){
            employee.name = name;
            return this;
        }
        public Builder department(String department ){
            employee.department = department;
            return this;
        }
        public Builder salary(BigInteger salary) {
            employee.salary = salary;
            return this;
        }

        public Employee build(){
            return employee;
        }
    }

    public static Builder builder(){
        return new Builder();
    }

}
