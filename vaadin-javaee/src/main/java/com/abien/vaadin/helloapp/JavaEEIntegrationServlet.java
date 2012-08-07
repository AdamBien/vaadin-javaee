package com.abien.vaadin.helloapp;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(urlPatterns = "/*")
public class JavaEEIntegrationServlet extends AbstractApplicationServlet {

    @Inject @VaadinApplication
    Application application;

    

    @Override
    protected Class<? extends Application> getApplicationClass() throws ClassNotFoundException {
        return application.getClass();
    }

    @Override
    protected Application getNewApplication(HttpServletRequest request) throws ServletException {
        return application;
    }
}
