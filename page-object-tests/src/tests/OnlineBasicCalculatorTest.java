package tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pages.OnlineBasicCalculatorPage;

public class OnlineBasicCalculatorTest {
	OnlineBasicCalculatorPage basicCalPage;

	@Before
	public void setUp() throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://internet-toolbox.com/free_online_basic_calculator");
		// driver.get("https://code.google.com/p/selenium/wiki/PageObjects")
		basicCalPage = PageFactory.initElements(driver,
				OnlineBasicCalculatorPage.class);
		//
		basicCalPage.screenshot();
	}

	// @Test
	public void testNavigate() {
		basicCalPage.navigate();
	}

	// @Test
	public void testAdd() {
		basicCalPage.buttonOneClick();
		basicCalPage.buttonAddClick();
		basicCalPage.buttonFiveClick();
		basicCalPage.buttonEqualsToClick();

		Assert.assertEquals(basicCalPage.result(), String.valueOf(1 + 5));

		basicCalPage.buttonDeleteClick();
		basicCalPage.buttonMultiplyClick();
		basicCalPage.buttonAddClick();
		basicCalPage.buttonDivideClick();
		System.out.println(basicCalPage.result());
		Assert.assertTrue(basicCalPage.result().isEmpty());

		basicCalPage.buttonDeleteClick();

	}
@Test
public void testButtonOne()
{
	basicCalPage.buttonOneClick();
}
	//@Test
	public void testScroolbar()

	{
		basicCalPage.scrollbar();
	}

	 @After
	public void tearDown() {
		basicCalPage.close();
	}

}
