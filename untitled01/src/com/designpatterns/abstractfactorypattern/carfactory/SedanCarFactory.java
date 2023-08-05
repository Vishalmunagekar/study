package com.designpatterns.abstractfactorypattern.carfactory;

import com.designpatterns.abstractfactorypattern.cars.Car;
import com.designpatterns.abstractfactorypattern.cars.sedan.AudiA4;
import com.designpatterns.abstractfactorypattern.cars.sedan.BMW3Series;
import com.designpatterns.abstractfactorypattern.cars.sedan.HyundaiVerna;
import com.designpatterns.abstractfactorypattern.cars.sedan.MercedesBenzAClassLimousine;

public class SedanCarFactory extends AbstractCarFactory {
    @Override
    public Car getCar(String name) {
        if(name.equals("Audi A4")){
            return new AudiA4();
        }
        if(name.equals("BMW 3 Series")){
            return new BMW3Series();
        }
        if(name.equals("Hyundai Verna")){
            return new HyundaiVerna();
        }
        if(name.equals("Mercedes-Benz A-Class Limousine")){
            return new MercedesBenzAClassLimousine();
        }
        return null;
    }
}
