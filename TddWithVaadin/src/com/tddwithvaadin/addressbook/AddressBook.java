package com.tddwithvaadin.addressbook;

import com.vaadin.Application;
import com.vaadin.ui.*;

public class AddressBook extends Application {
	
	private WindowFactory windowFactory = new WindowFactory();
	private LayoutFactory layoutFactory = new LayoutFactory();
	
	@Override
	public void init() {
		setMainWindow(createMainWindow());
		setTheme("Runo");
	}

	private Window createMainWindow() {
		Window window = windowFactory.createWindowWithCaption("Address Book Demo Application");
		window.setContent(layoutFactory.createMainLayout());
		return window;
	}
}
