package com.factory.carfactory;

import com.factory.AbstractCarFactory;
import com.factory.cars.Car;
import com.factory.cars.suv.HyundaiCreta;
import com.factory.cars.suv.JeepCompass;
import com.factory.cars.suv.MGAstor;
import com.factory.cars.suv.ToyotaFortuner;

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
