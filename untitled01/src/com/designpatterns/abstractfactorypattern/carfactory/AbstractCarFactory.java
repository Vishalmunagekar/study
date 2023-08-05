package com.designpatterns.abstractfactorypattern.carfactory;

import com.designpatterns.abstractfactorypattern.cars.Car;

public abstract class AbstractCarFactory {
    public abstract Car getCar(String name);
}
