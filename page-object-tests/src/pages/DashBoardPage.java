package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends PageObject {

	
	@FindBy(xpath="//span[@title='Sort By Key']")
	private WebElement keyLink;
	
	@FindBy(id="gadget-10000-chrome")
	private WebElement introduction;
	
	@FindBy(id="gadget-10002")
	private WebElement Frame1002;
	
	public DashBoardPage(WebDriver driver)
	{
		super(driver);
		System.out.println(driver.getTitle());
		driver.switchTo().frame(Frame1002);
	   // this.driver.switchTo().frame("gadget-10000");
	}
	
	
	public void clickKeyLink()
	{
		
		
		keyLink.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	public WebElement getKeyLinkParent()
	{
		return keyLink.findElement(By.xpath(".."));
	}
	
}
