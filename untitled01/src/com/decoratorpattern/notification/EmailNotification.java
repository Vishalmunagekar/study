package com.decoratorpattern.notification;

public class EmailNotification implements NotificationSender {

    private NotificationSender sender;

    public EmailNotification(NotificationSender sender) {
        this.sender = sender;
    }

    @Override
    public void send() {
        if(sender != null) sender.send();
        System.out.println("Sending EmailNotification.... ");
    }
}
