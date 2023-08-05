package com.designpatterns.abstractfactorypattern.cars.suv;

import com.designpatterns.abstractfactorypattern.cars.Car;

public class JeepCompass implements Car {
    @Override
    public String buildCar() {
        return "Jeep Compass";
    }
}
