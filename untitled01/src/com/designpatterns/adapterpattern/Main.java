package com.designpatterns.adapterpattern;

import com.designpatterns.adapterpattern.dependancy.DependencySMSNotification;
import com.designpatterns.adapterpattern.internal.InternalNotificationSender;
import com.designpatterns.adapterpattern.internal.SMSNotification;

public class Main {
    public static void main(String[] args) {
        InternalNotificationSender notificationSender = new SMSNotification(new DependencySMSNotification());

        notificationSender.send();
    }
}
