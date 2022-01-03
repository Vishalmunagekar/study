package com.factory.carfactory;

import com.factory.AbstractCarFactory;
import com.factory.carfactory.SUVCarFactory;

public class CarFactory {
    public static AbstractCarFactory getCarFactory(String carType){
        if(carType.equals("SUV")){
            return new SUVCarFactory();
        }
        if(carType.equals("SEDAN")){
            return new SedanCarFactory();
        }
        return null;
    }
}
