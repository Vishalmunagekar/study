package com.designpatterns.adapterpattern.dependancy;

public class DependencySMSNotification implements DependencyNotificationSender {
    @Override
    public void send() {
        System.out.println("Sending DependencySMSNotification...");
    }
}
