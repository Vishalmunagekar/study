package com.abstractfactorypattern.cars.suv;

import com.abstractfactorypattern.cars.Car;

public class HyundaiCreta implements Car {
    @Override
    public String buildCar() {
        return "Hyundai Creta";
    }
}
