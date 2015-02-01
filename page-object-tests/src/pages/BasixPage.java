package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class BasixPage {

	private WebDriver driver;

	@FindBy(linkText = "About BASIX")
	private WebElement aboutBasixMenuItem;

	@FindBy(linkText = "BASIX assessment")
	private WebElement BasixAssessmentSubMenuItem;

	public void MenuClick() {
		Actions action = new Actions(driver);
		action.moveToElement(aboutBasixMenuItem).build().perform();
		aboutBasixMenuItem.click();

		action.moveToElement(BasixAssessmentSubMenuItem).build().perform();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		driver.navigate().refresh();
		BasixAssessmentSubMenuItem.click();
	}

	public BasixPage(WebDriver driver) {
		this.driver = driver;
	}

	public void close() {
		driver.quit();
	}
}
