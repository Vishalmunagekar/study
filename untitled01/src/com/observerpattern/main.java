package com.observerpattern;

public class main {

    public static void main(String[] args) {
        PaymentEventListener notificationManager = new NotificationManager();
        PaymentEventListener eventLogger = new EventLogger();

        PaymentManager paymentManager = new PaymentManager();

        paymentManager.RegisterPaymentEventListeners(eventLogger);
        paymentManager.RegisterPaymentEventListeners(notificationManager);
        paymentManager.pay();
    }

}