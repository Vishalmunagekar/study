package com.designpatterns.observerpattern.eventlistener;

public class EventLogger implements EventListener {

    public void logEvent() {
        System.out.println("payment received...");
    }

    @Override
    public void listen() {
        logEvent();
    }
}
