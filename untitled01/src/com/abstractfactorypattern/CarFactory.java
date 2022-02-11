package com.abstractfactorypattern;

import com.abstractfactorypattern.carfactory.AbstractCarFactory;
import com.abstractfactorypattern.carfactory.SUVCarFactory;
import com.abstractfactorypattern.carfactory.SedanCarFactory;

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
