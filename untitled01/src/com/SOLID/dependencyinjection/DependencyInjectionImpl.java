package com.SOLID.dependencyinjection;

public class DependencyInjectionImpl {

    public static void main(String[] args) {
        LoggerService cLogService = new LoggerService(new ConsoleLogger());

        cLogService.log("Something went wrong!");

        LoggerService fLogService = new LoggerService(new FileLogger());

        fLogService.log("Something went wrong!");

    }

}
