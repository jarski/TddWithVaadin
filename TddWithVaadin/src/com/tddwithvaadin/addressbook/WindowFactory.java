package com.tddwithvaadin.addressbook;

import com.vaadin.ui.Window;

public class WindowFactory {

	public Window createWindowWithCaption(String caption) {
		return new Window(caption);
	}

}
