package com.polymorphism.runtime;

public class Overriding {

    public static void main(String[] args) {
        Shape s1 = new Shape();
        s1.area(); // area of shape

        Shape s2 = new Circle();
        s2.area(); // area of circle

        Shape s3 = new Rectangle();
        s3.area(); // area of rectangle

        Circle c1 = (Circle) new Shape(); // ClassCastException
        c1.area();
    }
}