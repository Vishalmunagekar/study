package com.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class PaymentManager {

    private List<PaymentEventListener> paymentEventListeners = new ArrayList<>();

    public void pay() {
        System.out.println("Payment has been done...");
        this.paymentEventListeners.forEach(PaymentEventListener::listen); // p -> p.listen()
    }


    public void RegisterPaymentEventListeners(PaymentEventListener p){
        this.paymentEventListeners.add(p);
    }

    public void unregisterPaymentEventListeners(PaymentEventListener p){
        this.paymentEventListeners.remove(p);
    }

}
