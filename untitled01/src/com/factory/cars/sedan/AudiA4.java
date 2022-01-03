package com.factory.cars.sedan;

import com.factory.cars.Car;

public class AudiA4 implements Car {
    @Override
    public String buildCar() {
        return "Audi A4";
    }
}
