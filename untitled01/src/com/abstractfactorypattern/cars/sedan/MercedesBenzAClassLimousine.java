package com.abstractfactorypattern.cars.sedan;

import com.abstractfactorypattern.cars.Car;

public class MercedesBenzAClassLimousine implements Car {
    @Override
    public String buildCar() {
        return "Mercedes-Benz A-Class Limousine";
    }
}
