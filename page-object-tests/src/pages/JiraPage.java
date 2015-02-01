package pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JiraPage extends PageObject{

	

	@FindBy(id = "login-form-username")
	private WebElement loginUserNameTextBox;

	@FindBy(id = "login-form-password")
	private WebElement loginPasswordTextBox;

	@FindBy(id = "login")
	private WebElement loginButton;
	


	public JiraPage(WebDriver driver) {
		super(driver);
		driver.switchTo().frame("gadget-0");
	}

	public DashBoardPage login(String username, String password) {
		loginUserNameTextBox.clear();
		loginUserNameTextBox.click();
		loginUserNameTextBox.sendKeys(username);
		loginPasswordTextBox.clear();
		loginPasswordTextBox.click();
		loginPasswordTextBox.sendKeys(password);
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		DashBoardPage page = PageFactory.initElements(driver, DashBoardPage.class);
		return page;
	}
	



	
}
