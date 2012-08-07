package com.abien.vaadin.helloapp.greetings.boundary;

import com.abien.vaadin.helloapp.greetings.control.TimeProvider;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class Greetings {
    
    @Inject
    TimeProvider provider;

    public String sayHello(String name) {
        return "Hello " + name + " at: " + provider.getCurrentTime();
    }
}
