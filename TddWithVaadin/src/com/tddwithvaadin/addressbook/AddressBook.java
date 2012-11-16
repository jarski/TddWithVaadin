package com.tddwithvaadin.addressbook;

import com.vaadin.Application;
import com.vaadin.ui.*;

public class AddressBook extends Application {
	
	private WindowFactory windowFactory;
	
	@Override
	public void init() {
		Window mainWindow = windowFactory.createMainWindow("Address Book Demo Application");
		setMainWindow(mainWindow);
	}
}
