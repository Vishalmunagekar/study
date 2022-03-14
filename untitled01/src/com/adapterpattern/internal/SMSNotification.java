package com.adapterpattern.internal;

import com.adapterpattern.dependancy.DependencyNotificationSender;

public class SMSNotification implements InternalNotificationSender {

    private final DependencyNotificationSender dependencyNotificationSender;

    public SMSNotification(DependencyNotificationSender dependencyNotificationSender) {
        this.dependencyNotificationSender = dependencyNotificationSender;
    }

    @Override
    public void send() {
        dependencyNotificationSender.send(); // adapted notification Sender from external lib.
    }
}
