package com.factory;

import com.factory.cars.Car;

public abstract class AbstractCarFactory {
    protected abstract Car getCar(String name);
}
