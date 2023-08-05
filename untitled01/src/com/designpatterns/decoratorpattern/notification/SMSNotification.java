package com.designpatterns.decoratorpattern.notification;

public class SMSNotification implements NotificationSender {

    private NotificationSender sender;

    public SMSNotification(NotificationSender sender) {
        this.sender = sender;
    }

    @Override
    public void send() {
        if(sender != null) sender.send();
        System.out.println("Sending SMSNotification.... ");
    }
}
