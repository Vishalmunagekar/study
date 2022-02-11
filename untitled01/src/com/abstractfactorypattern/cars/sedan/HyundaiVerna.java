package com.abstractfactorypattern.cars.sedan;

import com.abstractfactorypattern.cars.Car;

public class HyundaiVerna implements Car {
    @Override
    public String buildCar() {
        return "Hyundai Verna";
    }
}
