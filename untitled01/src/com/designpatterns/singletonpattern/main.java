package com.designpatterns.singletonpattern;

public class main {

    public static void main(String[] args) {
        SingletonLazy lazy = SingletonLazy.getInstance();
        SingletonEager eager = SingletonEager.getInstance();
        SingletonSyncNotEfficient syncNotEfficient = SingletonSyncNotEfficient.getInstance();
        SingletonSyncBlock syncBlock = SingletonSyncBlock.getInstance();
        SingletonHolder singleton = SingletonHolder.getInstance(); //best way of impl
    }
}
