package com.designpatterns.abstractfactorypattern.cars.sedan;

import com.designpatterns.abstractfactorypattern.cars.Car;

public class BMW3Series implements Car {
    @Override
    public String buildCar() {
        return "BMW 3 Series";
    }
}
