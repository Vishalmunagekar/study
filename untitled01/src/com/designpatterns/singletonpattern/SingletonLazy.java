package com.designpatterns.singletonpattern;

public class SingletonLazy {
    private static SingletonLazy INSTANCE = null;

    private SingletonLazy() {

    }

    public static SingletonLazy getInstance() {
        if(INSTANCE == null)
            INSTANCE = new SingletonLazy();
        return INSTANCE;
    }
}
