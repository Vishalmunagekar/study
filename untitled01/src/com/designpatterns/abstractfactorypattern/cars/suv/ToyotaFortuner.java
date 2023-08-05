package com.designpatterns.abstractfactorypattern.cars.suv;

import com.designpatterns.abstractfactorypattern.cars.Car;

public class ToyotaFortuner implements Car {
    @Override
    public String buildCar() {
        return "Toyota Fortuner";
    }
}
