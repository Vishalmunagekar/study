package com.designpatterns.builderpattern;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        Product p1 = new Product();
        Product p2 = new Product(1);
        Product p3 = new Product(1, "name");
        Product p4 = new Product(1, "name", "color");
        Product p5 = new Product(1, "name", "color", BigInteger.valueOf(100));

        Employee e1 = new Employee();
        Employee e2 = new Employee.Builder().build();
        Employee e3 = new Employee.Builder()
                            .id(1)
                            .build();

        Employee e4 = new Employee.Builder().build();

        Employee e5 = Employee.builder() //lombok impl
                            .id(2)
                            .name("vishal")
                            .department("PCM")
                            .salary(BigInteger.valueOf(25000))
                            .build();

    }

}
