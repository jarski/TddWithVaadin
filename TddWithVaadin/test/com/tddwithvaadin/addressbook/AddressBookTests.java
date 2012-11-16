package com.tddwithvaadin.addressbook;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import com.vaadin.ui.*;

@RunWith(MockitoJUnitRunner.class)
public class AddressBookTests {
	@InjectMocks
	private AddressBook sut;
	
	@Mock
	WindowFactory windowFactory = mock(WindowFactory.class);
	@Mock
	LayoutFactory layoutFactory = mock(LayoutFactory.class);

	private Window expectedMainWindow = mock(Window.class);
	
	@Before
	public void setUp() throws Exception {
		sut = new AddressBook();
		MockitoAnnotations.initMocks(this);		
		MockWindowFactoryToReturn(expectedMainWindow);
	}

	@Test
	public void mainWindowShouldBeCreatedWithCaption() {
		sut.init();
		verify(windowFactory).createWindowWithCaption("Address Book Demo Application");
	}
	
	@Test
	public void mainWindowShouldBeCreatedInInitialization() {
		sut.init();
		assertSame(expectedMainWindow, sut.getMainWindow());
	}
	
	@Test
	public void applicationShouldUseRunoTheme() {
		sut.init();
		assertEquals("Runo", sut.getTheme());
	}
	
	@Test
	public void test() {
		Layout expectedMainLayout = mock(Layout.class);
		when(layoutFactory.createMainLayout()).thenReturn(expectedMainLayout);
		sut.init();
		verify(expectedMainWindow).setContent(expectedMainLayout);
	}

	private void MockWindowFactoryToReturn(Window mainWindow) {
		when(windowFactory.createWindowWithCaption(anyString())).thenReturn(mainWindow);
	}
}
