package pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ParkingCalculatorPage {

	private WebDriver driver;

	@FindBy(id = "Lot")
	private WebElement chooseALot;

	@FindBy(id = "EntryTime")
	private WebElement entryTimeTextBox;

	@FindBy(id = "ExitTime")
	private WebElement exitTimeTextBox;

	@FindBy(name = "Submit")
	private WebElement submitButton;

	@FindBy(xpath = "/html/body/form/table/tbody/tr[4]/td[2]/span/font/b")
	private WebElement messageHolder;

	@FindBy(xpath = "//input[@value='AM' and @name='EntryTimeAMPM']")
	private WebElement entryTimeRadioButtonAM;

	@FindBy(xpath = "//input[@value='PM' and @name='EntryTimeAMPM']")
	private WebElement entryTimeRadioButtonPM;

	@FindBy(xpath = "//input[@value='AM' and @name='ExitTimeAMPM']")
	private WebElement exitTimeRadioButtonAM;

	@FindBy(xpath = "//input[@value='PM' and @name='ExitTimeAMPM']")
	private WebElement exitTimeRadioButtonPM;

	@FindBy(id = "EntryDate")
	private WebElement entryDateTextBox;

	@FindBy(id = "ExitDate")
	private WebElement exitDateTextBox;

	@FindBy(xpath = "//img[@alt='Pick a date']")
	private WebElement pickADateImage;

	@FindBy(xpath = "//option[@ selected='' and @value='STP']")
	private WebElement defalutDropDownValue;

	public void dropDownList() {

		String[] list = { "Short-Term Parking", "Economy Parking",
				"Long-Term Surface Parking", "Long-Term Garage Parking",
				"Valet Parking" };
		Select select = new Select(chooseALot);
		List<WebElement> options = select.getOptions();
		for (WebElement e : options) {
			for (int i = 0; i < list.length; i++) {
				if (e.getText().equals(list[i])) {
					Assert.assertEquals(list[i], e.getText());
				}
			}
		}

	}

	public void defaultSelectedValue() {
		Assert.assertEquals(defalutDropDownValue.getText(),
				"Short-Term Parking");

	}

	public void pickADate() {
		pickADateImage.click();
		System.out.println(driver.getWindowHandles().size());

		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String window1 = it.next();
			String window2 = it.next();

			driver.switchTo().window(window2);

			WebElement month = driver.findElement(By
					.xpath("//select[@ name='MonthSelector']"));

			Select choose = new Select(month);
			choose.selectByVisibleText("May");
			// WebElement selectDate = driver.findElement(By.linkText("May"));
			// selectDate.click();
			// driver.findElement(By.cssSelector("a[href*='11/27/2014']")).click();
			// WebElement date =
			// driver.findElement(By.xpath("//a[contains(@href,'getElementById('EntryDate').value='12/27/2014';;')]"));
			// date.click();
			// WebElement date =
			// driver.findElement(By.partialLinkText("value='11/27/2014'"));
			// date.click();
			driver.switchTo().window(window1);

		}

	}

	public void setEntryDate(String entryDate) {
		entryDateTextBox.clear();
		entryDateTextBox.sendKeys(entryDate);
	}

	public void setExitDate(String exitDate) {
		exitDateTextBox.clear();
		exitDateTextBox.sendKeys(exitDate);
	}

	public ParkingCalculatorPage(WebDriver driver) {
		this.driver = driver;

	}

	public String getMessage() {
		return messageHolder.getText();
	}

	public boolean chooseLot(int index) {
		try {
			Select parking = new Select(chooseALot);
			parking.selectByIndex(index);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void setEntryTime(String entryTime) {
		entryTimeTextBox.clear();
		entryTimeTextBox.sendKeys(entryTime);
	}

	public void setExitTime(String exitTime) {
		exitTimeTextBox.clear();
		exitTimeTextBox.sendKeys(exitTime);
	}

	public void setEntryTimeAM() {
		entryTimeRadioButtonAM.click();
	}

	public void setEntryTimePM() {
		entryTimeRadioButtonPM.click();
	}

	public void setExitTimeAM() {
		exitTimeRadioButtonAM.click();
	}

	public void setExitTimePM() {
		exitTimeRadioButtonAM.click();
	}

	public void submit() {
		submitButton.click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}

	public void close() {
		this.driver.quit();
	}
}
