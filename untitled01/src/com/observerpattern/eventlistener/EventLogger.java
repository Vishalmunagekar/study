package com.observerpattern.eventlistener;

import com.observerpattern.eventlistener.EventListener;

public class EventLogger implements EventListener {

    public void logEvent() {
        System.out.println("payment received...");
    }

    @Override
    public void listen() {
        logEvent();
    }
}
