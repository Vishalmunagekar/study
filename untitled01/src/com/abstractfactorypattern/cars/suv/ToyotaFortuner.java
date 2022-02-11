package com.abstractfactorypattern.cars.suv;

import com.abstractfactorypattern.cars.Car;

public class ToyotaFortuner implements Car {
    @Override
    public String buildCar() {
        return "Toyota Fortuner";
    }
}
