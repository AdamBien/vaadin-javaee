/*
Copyright 2012 Adam Bien, adam-bien.com

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.abien.vaadin.helloapp;

import com.abien.vaadin.helloapp.greetings.boundary.Greetings;
import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 *
 * @author adam-bien.com
 */
@SessionScoped 
@VaadinApplication
public class HelloApp extends Application {

    @Inject
    Greetings greetingService;

    @Inject
    Event<ClickEvent> buttonEvents;
    
    @Override
    public void init() {
        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        Label header = new Label("Vaadin on Java EE");
        header.setStyleName("h1");
        layout.addComponent(header);
        
        final TextField nameField = new TextField("Input something:");
        final Label greetingLbl = new Label();
        layout.addComponent(nameField);
        layout.addComponent(new Button("Say Hello", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                greetingLbl.setCaption(greetingService.sayHello(nameField.getValue().toString()));
                buttonEvents.fire(event);
            }
        }));
        layout.addComponent(greetingLbl);

        Window mainWindow = new Window("Vaadin 6.8 - Java EE Integration", layout);
        setMainWindow(mainWindow);
    }

}
