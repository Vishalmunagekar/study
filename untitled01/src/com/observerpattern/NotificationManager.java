package com.observerpattern;

public class NotificationManager implements PaymentEventListener {

    public void sendNotification(){
        System.out.println("Notification Sent...");
    }

    @Override
    public void listen() {
        sendNotification();
    }
}
