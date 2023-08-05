package com.SOLID.dependencyinjection;

public class FileLogger implements Logger{

    @Override
    public void log(String msg) {
        System.out.println("FileLogger : " + msg);
    }
}
