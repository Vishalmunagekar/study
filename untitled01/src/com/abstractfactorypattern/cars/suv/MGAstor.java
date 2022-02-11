package com.abstractfactorypattern.cars.suv;

import com.abstractfactorypattern.cars.Car;

public class MGAstor implements Car {
    @Override
    public String buildCar() {
        return "MG Astor";
    }
}
