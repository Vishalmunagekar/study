package com.observerpattern;

public class EventLogger implements PaymentEventListener {

    public void logEvent() {
        System.out.println("payment received...");
    }

    @Override
    public void listen() {
        logEvent();
    }
}
