package com.factory.cars.sedan;

import com.factory.cars.Car;

public class MercedesBenzAClassLimousine implements Car {
    @Override
    public String buildCar() {
        return "Mercedes-Benz A-Class Limousine";
    }
}
