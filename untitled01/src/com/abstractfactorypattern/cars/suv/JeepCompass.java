package com.abstractfactorypattern.cars.suv;

import com.abstractfactorypattern.cars.Car;

public class JeepCompass implements Car {
    @Override
    public String buildCar() {
        return "Jeep Compass";
    }
}
