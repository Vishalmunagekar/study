package com.designpatterns.abstractfactorypattern.cars.suv;

import com.designpatterns.abstractfactorypattern.cars.Car;

public class MGAstor implements Car {
    @Override
    public String buildCar() {
        return "MG Astor";
    }
}
