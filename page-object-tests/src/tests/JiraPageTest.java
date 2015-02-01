package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import pages.DashBoardPage;
import pages.JiraPage;

public class JiraPageTest {

	JiraPage jirapage;
   
	@Before
	public void setUp()

	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://127.0.0.1:8080");
		
		jirapage = PageFactory.initElements(driver, JiraPage.class);
	}


	@Test
	public void test() {

		DashBoardPage dashPage = jirapage.login("arunam", "aruna25");
		Assert.assertEquals("System Dashboard - JIRA", dashPage.getTitle());
	    Assert.assertEquals(dashPage.getKeyLinkParent().getAttribute("rel"),"issuekey:ASC");
	    
		dashPage.clickKeyLink();
		
		
		String text2 = dashPage.getKeyLinkParent().getAttribute("rel");
		Assert.assertEquals(text2, "issuekey:DESC");
		
		
	}
	

	// @After
	public void tearDown() {
		jirapage.close();
	}
}
