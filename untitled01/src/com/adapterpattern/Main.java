package com.adapterpattern;

import com.adapterpattern.dependancy.DependencySMSNotification;
import com.adapterpattern.internal.InternalNotificationSender;
import com.adapterpattern.internal.SMSNotification;

public class Main {
    public static void main(String[] args) {
        InternalNotificationSender notificationSender = new SMSNotification(new DependencySMSNotification());

        notificationSender.send();
    }
}
