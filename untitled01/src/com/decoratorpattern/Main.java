package com.decoratorpattern;

import com.decoratorpattern.notification.EmailNotification;
import com.decoratorpattern.notification.NotificationSender;
import com.decoratorpattern.notification.SMSNotification;

public class Main {

    public static void main(String[] args) {
        NotificationSender notificationSender01 = new EmailNotification(new SMSNotification(null));
        notificationSender01.send();
        System.out.println("=====================================");
        NotificationSender notificationSender02 = new SMSNotification(new EmailNotification(new SMSNotification(null)));
        notificationSender02.send();

    }
}
