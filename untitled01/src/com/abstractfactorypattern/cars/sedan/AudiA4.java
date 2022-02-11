package com.abstractfactorypattern.cars.sedan;

import com.abstractfactorypattern.cars.Car;

public class AudiA4 implements Car {
    @Override
    public String buildCar() {
        return "Audi A4";
    }
}
