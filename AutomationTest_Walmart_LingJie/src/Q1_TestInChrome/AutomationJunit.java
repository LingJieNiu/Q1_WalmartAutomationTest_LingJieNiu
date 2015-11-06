package Q1_TestInChrome;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AutomationJunit {
	
	AutomationTest auto=new AutomationTest();
	

	@Before
	public void setUp() throws Exception {
		//auto.setUp();
	}

	@Test
	public void testSetUp() {
		
	}

	@Test
	public void testTestLoginToExistAccount() throws Exception {
		auto.setUp();
		auto.testLoginToExistAccount();
		auto.PerformSearch();
	}

	@Test
	public void testHomePage() {
		//auto.HomePage();
	}

}
