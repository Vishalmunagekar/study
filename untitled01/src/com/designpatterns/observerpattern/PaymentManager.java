package com.designpatterns.observerpattern;

import com.designpatterns.observerpattern.eventlistener.EventListener;

import java.util.ArrayList;
import java.util.List;

public class PaymentManager {

    private List<EventListener> eventListeners = new ArrayList<>();

    public void pay() {
        System.out.println("Payment has been done...");
        this.eventListeners.forEach(EventListener::listen); // p -> p.listen()
    }


    public void RegisterPaymentEventListeners(EventListener p){
        this.eventListeners.add(p);
    }

    public void unregisterPaymentEventListeners(EventListener p){
        this.eventListeners.remove(p);
    }

}
