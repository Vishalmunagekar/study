package com.SOLID.dependencyinjection;

public class LoggerService {
    private Logger logger;

    public LoggerService(Logger logger){
        this.logger = logger;
    }

    public void log(String msg){
        logger.log(msg);
    }
}
