package pages;

import org.openqa.selenium.WebDriver;

public class PageObject 
{
	protected WebDriver driver;
	
	public PageObject(WebDriver driver)
	{
		this.driver = driver;
	}

	public void close()
	{
		this.driver.quit();
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
}
