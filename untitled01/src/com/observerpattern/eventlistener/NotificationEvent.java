package com.observerpattern.eventlistener;

import com.observerpattern.eventlistener.EventListener;

public class NotificationEvent implements EventListener {

    public void sendNotification(){
        System.out.println("Notification Sent...");
    }

    @Override
    public void listen() {
        sendNotification();
    }
}
