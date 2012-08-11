package com.vaadin.reports;

import com.vaadin.terminal.WrappedRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.Root;

public class ReportsRoot extends Root {

	@Override
	protected void init(WrappedRequest request) {
		addComponent(new Label("Reports root in Reports application"));
	}
}
