package com.designpatterns.abstractfactorypattern.cars.sedan;

import com.designpatterns.abstractfactorypattern.cars.Car;

public class HyundaiVerna implements Car {
    @Override
    public String buildCar() {
        return "Hyundai Verna";
    }
}
