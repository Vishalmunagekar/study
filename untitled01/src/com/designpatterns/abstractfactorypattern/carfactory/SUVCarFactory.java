package com.designpatterns.abstractfactorypattern.carfactory;

import com.designpatterns.abstractfactorypattern.cars.Car;
import com.designpatterns.abstractfactorypattern.cars.suv.HyundaiCreta;
import com.designpatterns.abstractfactorypattern.cars.suv.JeepCompass;
import com.designpatterns.abstractfactorypattern.cars.suv.MGAstor;
import com.designpatterns.abstractfactorypattern.cars.suv.ToyotaFortuner;

public class SUVCarFactory extends AbstractCarFactory {

    @Override
    public Car getCar(String name) {
        if(name.equals("Hyundai Creta")){
            return new HyundaiCreta();
        }
        if(name.equals("Jeep Compass")){
            return new JeepCompass();
        }
        if(name.equals("MG Astor")){
            return new MGAstor();
        }
        if(name.equals("Toyota Fortuner")){
            return new ToyotaFortuner();
        }
        return null;
    }
}
