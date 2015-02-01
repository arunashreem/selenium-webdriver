package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import pages.FlipkartCookiespage;

public class FlipkartCookiesPageTest {

	FlipkartCookiespage flipkartpage;

	@Before
	public void setUp() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.flipkart.com/");
		flipkartpage = PageFactory.initElements(driver,
				FlipkartCookiespage.class);
	}

	@Test
	public void testSignUp() {
		flipkartpage.signUp();
	}

	// @Test
	public void searchTest() {
		flipkartpage.enterValueSearchTextBox();
		flipkartpage.searchbtnclick();
		flipkartpage.addCookies();
		flipkartpage.displayCookies();
		flipkartpage.deleteCookies();
		flipkartpage.displayCookies();
	}

	// @After
	public void tearDown() {
		flipkartpage.close();
	}
}
