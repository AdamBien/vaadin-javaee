package com.abien.vaadin.helloapp;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(urlPatterns = "/*",loadOnStartup=1)
public class JavaEEIntegrationServlet extends AbstractApplicationServlet {

    @Inject @VaadinApplication
    Instance<Application> applications;

    

    @Override
    protected Class<? extends Application> getApplicationClass() throws ClassNotFoundException {
        verifyInstallation();
        return applications.get().getClass();
    }

    @Override
    protected Application getNewApplication(HttpServletRequest request) throws ServletException {
        verifyInstallation();
        return applications.get();
    }

    void verifyInstallation() throws IllegalStateException {
        if(applications.isUnsatisfied()) {
            throw new IllegalStateException("No managed bean with annotated with @VaadinApplication found!");
        }
        if(applications.isAmbiguous()) {
            throw new IllegalStateException("Multiple CDI managed beans annotated with @VaadinApplication found!");
        }
    }
}
