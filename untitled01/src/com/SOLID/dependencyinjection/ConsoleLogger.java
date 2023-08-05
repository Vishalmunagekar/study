package com.SOLID.dependencyinjection;

public class ConsoleLogger implements Logger{

    @Override
    public void log(String msg) {
        System.out.println( "ConsoleLogger : " + msg);
    }
}
