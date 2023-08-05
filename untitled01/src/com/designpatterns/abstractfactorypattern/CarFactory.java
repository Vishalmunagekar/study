package com.designpatterns.abstractfactorypattern;

import com.designpatterns.abstractfactorypattern.carfactory.AbstractCarFactory;
import com.designpatterns.abstractfactorypattern.carfactory.SUVCarFactory;
import com.designpatterns.abstractfactorypattern.carfactory.SedanCarFactory;

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
