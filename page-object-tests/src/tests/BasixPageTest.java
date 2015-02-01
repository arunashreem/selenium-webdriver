package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import pages.BasixPage;

public class BasixPageTest {

	BasixPage basixpage;

	@Before
	public void setUp() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.basix.nsw.gov.au/basixcms/");
		basixpage = PageFactory.initElements(driver, BasixPage.class);
	}

	@Test
	public void testAboutBasixItem() {
		basixpage.MenuClick();
	}

	// @After
	public void tearDown() {
		basixpage.close();
	}

}
