/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abien.vaadin.helloapp;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 *
 * @author adam-bien.com
 */
@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE})
public @interface VaadinApplication {}
