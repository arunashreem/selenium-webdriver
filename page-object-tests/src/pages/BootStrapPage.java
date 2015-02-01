package pages;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BootStrapPage {

	private WebDriver driver;
	
	@FindBy(linkText="Expo")
	private WebElement expoLink;
	
	//@FindBy(xpath="//button[@class='navbar-toggle collapsed' and type='button']")
	@FindBy(xpath="/html/body/header/div/div/button")
	private WebElement toggleButton;
	
	public void expoLinkClick()
	{
		System.out.println(expoLink.getLocation());
		System.out.println(driver.manage().window().getSize());
		driver.manage().window().setSize(new Dimension(500, 500));
		System.out.println(expoLink.getLocation().getX());
		System.out.println(expoLink.isDisplayed());
		Assert.assertEquals(expoLink.getLocation().getX(),432);
		
		//expoLink.click()
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	public void toggleButtonClick() throws IOException
	{
		driver.manage().window().setSize(new Dimension(500, 500));
		toggleButton.click();
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("/Users/vijaya/seldir/screenshot.png"));
	}
	public BootStrapPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void close()
	{
		driver.quit();
	}
	
}
