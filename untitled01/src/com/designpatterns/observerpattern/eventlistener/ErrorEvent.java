package com.designpatterns.observerpattern.eventlistener;

public class ErrorEvent implements EventListener{

    private void errorEvent(){
        System.out.println("Error has been occurred...");
    }

    @Override
    public void listen() {
        errorEvent();
    }
}
