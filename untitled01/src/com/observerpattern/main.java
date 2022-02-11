package com.observerpattern;

import com.observerpattern.eventlistener.ErrorEvent;
import com.observerpattern.eventlistener.EventListener;
import com.observerpattern.eventlistener.EventLogger;
import com.observerpattern.eventlistener.NotificationEvent;

public class main {

    public static void main(String[] args) {
        EventListener notificationEventListener = new NotificationEvent();
        EventListener eventLogger = new EventLogger();

        PaymentManager paymentManager1 = new PaymentManager();

        paymentManager1.RegisterPaymentEventListeners(eventLogger);
        paymentManager1.RegisterPaymentEventListeners(notificationEventListener);
        paymentManager1.pay();

        System.out.println("==============================================");

        PaymentManager paymentManager2 = new PaymentManager();
        EventListener errorEvent = new ErrorEvent();

        paymentManager2.RegisterPaymentEventListeners(eventLogger);
        paymentManager2.RegisterPaymentEventListeners(errorEvent);
        paymentManager2.RegisterPaymentEventListeners(notificationEventListener);
        paymentManager2.pay();

    }

}