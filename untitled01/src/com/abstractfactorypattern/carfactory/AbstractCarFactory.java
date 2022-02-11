package com.abstractfactorypattern.carfactory;

import com.abstractfactorypattern.cars.Car;

public abstract class AbstractCarFactory {
    public abstract Car getCar(String name);
}
