package com.tddwithvaadin.addressbook;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.vaadin.ui.Window;

@RunWith(MockitoJUnitRunner.class)
public class AddressBookTests {
	@InjectMocks
	private AddressBook sut;
	
	@Mock
	WindowFactory windowFactory = mock(WindowFactory.class);
	
	@Before
	public void setUp() throws Exception {
		sut = new AddressBook();
		MockitoAnnotations.initMocks(this);		
	}

	@Test
	public void mainWindowShouldBeCreatedWithName() {
		sut.init();
		verify(windowFactory).createWindowWithCaption("Address Book Demo Application");
	}
	
	@Test
	public void mainWindowShouldBeCreatedInInitialization() {
		Window expectedMainWindow = mock(Window.class);
		when(windowFactory.createWindowWithCaption(anyString())).thenReturn(expectedMainWindow);
		sut.init();
		assertSame(expectedMainWindow, sut.getMainWindow());
	}
	
	@Test
	public void applicationShouldUseRunoTheme() {
		sut.init();
		assertEquals("Runo", sut.getTheme());
	}
}
