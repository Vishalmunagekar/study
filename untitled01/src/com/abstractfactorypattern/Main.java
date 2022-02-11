package com.abstractfactorypattern;

import com.abstractfactorypattern.carfactory.AbstractCarFactory;
import com.abstractfactorypattern.cars.Car;

public class Main {
    public static void main(String[] args) {
        AbstractCarFactory suvCarFactory = CarFactory.getCarFactory("SUV");
        Car hyundai_creta = suvCarFactory.getCar("Hyundai Creta");
        Car jeep_compass = suvCarFactory.getCar("Jeep Compass");
        System.out.println(hyundai_creta.buildCar());
        System.out.println(jeep_compass.buildCar());

        AbstractCarFactory sedanCarFactory = CarFactory.getCarFactory("SEDAN");
        Car audi_a4 = sedanCarFactory.getCar("Audi A4");
        Car benz = sedanCarFactory.getCar("Mercedes-Benz A-Class Limousine");

        System.out.println(audi_a4.buildCar());
        System.out.println(benz.buildCar());
    }
}
