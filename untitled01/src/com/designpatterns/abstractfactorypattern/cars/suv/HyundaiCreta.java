package com.designpatterns.abstractfactorypattern.cars.suv;

import com.designpatterns.abstractfactorypattern.cars.Car;

public class HyundaiCreta implements Car {
    @Override
    public String buildCar() {
        return "Hyundai Creta";
    }
}
