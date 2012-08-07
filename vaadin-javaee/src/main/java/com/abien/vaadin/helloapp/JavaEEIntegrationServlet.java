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

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author adam-bien.com
 */
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
