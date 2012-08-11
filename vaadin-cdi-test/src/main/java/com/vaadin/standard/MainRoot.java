package com.organization.application.standard;

import com.vaadin.cdi.annotation.DeployableVaadinRoot;
import com.vaadin.terminal.WrappedRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.Root;

@DeployableVaadinRoot
public class MainRoot extends Root {

	@Override
	protected void init(WrappedRequest request) {
		addComponent(new Label("Main customers"));
	}

}
