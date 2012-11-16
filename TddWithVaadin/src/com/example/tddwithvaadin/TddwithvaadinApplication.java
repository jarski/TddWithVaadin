package com.example.tddwithvaadin;

import com.vaadin.Application;
import com.vaadin.ui.*;

public class TddwithvaadinApplication extends Application {
	@Override
	public void init() {
		Window mainWindow = new Window("Tddwithvaadin Application");
		Label label = new Label("Hello Vaadin user");
		mainWindow.addComponent(label);
		setMainWindow(mainWindow);
	}

}
