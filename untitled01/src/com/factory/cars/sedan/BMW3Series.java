package com.factory.cars.sedan;

import com.factory.cars.Car;

public class BMW3Series implements Car {
    @Override
    public String buildCar() {
        return "BMW 3 Series";
    }
}
