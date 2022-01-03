package com.factory.carfactory;

import com.factory.AbstractCarFactory;
import com.factory.cars.Car;
import com.factory.cars.sedan.AudiA4;
import com.factory.cars.sedan.BMW3Series;
import com.factory.cars.sedan.HyundaiVerna;
import com.factory.cars.sedan.MercedesBenzAClassLimousine;

public class SedanCarFactory extends AbstractCarFactory {
    @Override
    protected Car getCar(String name) {
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
