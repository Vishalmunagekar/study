package com.factory.cars.suv;

import com.factory.cars.Car;

public class ToyotaFortuner implements Car {
    @Override
    public String buildCar() {
        return "Toyota Fortuner";
    }
}
