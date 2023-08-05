package com.designpatterns.observerpattern.eventlistener;

public class NotificationEvent implements EventListener {

    public void sendNotification(){
        System.out.println("Notification Sent...");
    }

    @Override
    public void listen() {
        sendNotification();
    }
}
