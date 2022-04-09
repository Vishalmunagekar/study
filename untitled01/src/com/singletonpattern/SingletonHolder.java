package com.singletonpattern;

public class SingletonHolder {

    private SingletonHolder() {
    }

    private static final class Singleton{
        private static final SingletonHolder INSTANCE = new SingletonHolder();
    }

    public static SingletonHolder getInstance() {
        return Singleton.INSTANCE;
    }
}
