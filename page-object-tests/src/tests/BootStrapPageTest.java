package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import pages.BootStrapPage;
public class BootStrapPageTest {
	BootStrapPage bootstrapPage;
	@Before
	public void setUp()
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://getbootstrap.com");
		bootstrapPage = PageFactory.initElements(driver, BootStrapPage.class);	
	}
	//@Test
	public void testLocation()
	{
		bootstrapPage.expoLinkClick();
		
	}
	@Test
	public void testToggleButton() throws Exception
	{
		bootstrapPage.toggleButtonClick();	
	}
	//@After
	public void taerDown()
	{
		bootstrapPage.close();
	}
	
}