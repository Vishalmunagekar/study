package com.builderpattern;

import java.math.BigInteger;

public class Product {
    private Integer id;
    private String name;
    private String color;
    private BigInteger price;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(Integer id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Product(Integer id, String name, String color, BigInteger price) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
    }
}
