package TddWithVaadin.TouchkitAddressBook;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

@RunWith(MockitoJUnitRunner.class)
public class TestMyVaadinUI {
    @InjectMocks
	private MyVaadinUI sut;
    
    @Mock
	LayoutFactory layoutFactory = mock(LayoutFactory.class);

    @Before
	public void setUp() throws Exception {
		sut = new MyVaadinUI();
		MockitoAnnotations.initMocks(this);		
	}
	
    @Test
	public void mainLayoutIsTheContentOfUI() {
    	AbstractOrderedLayout mainLayout = mock(AbstractOrderedLayout.class);
    	when(layoutFactory.createMainLayout()).thenReturn(mainLayout);
		sut.init(mock(VaadinRequest.class));
		assertSame(mainLayout, sut.getContent());
	}
}
