package pages;

import java.io.File;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.TakesScreenshot;

//import com.sun.jna.platform.FileUtils;

public class OnlineBasicCalculatorPage {

	private WebDriver driver;
	
	
		
	@FindBy(id="cal_basic_results")
	private WebElement resultDisplayTextBox;
	
	@FindBy(xpath="//input[@value='1']")
	private WebElement buttonOne;
	
	@FindBy(xpath="//input[@value='2']")
	private WebElement buttonTwo;
	
	@FindBy(xpath="//input[@value='3']")
	private WebElement buttonThree;
	
	@FindBy(xpath="//input[@value='4']")
	private WebElement buttonFour;
	
	@FindBy(xpath="//input[@value='5']")
	private WebElement buttonFive;
	
	@FindBy(xpath="//input[@value='-']")
	private WebElement buttonMinus;
	
	@FindBy(xpath="//input[@value='+']")
	private WebElement buttonAdd;
	
	@FindBy(xpath="//input[@value='x']")
	private WebElement buttonMultiply;
	
	@FindBy(xpath="//input[@value='/']")
	private WebElement buttonDivide;
	
	@FindBy(xpath="//input[@value='=']")
	private WebElement buttonEqualsTo;
	
	@FindBy(xpath="//input[@value='del']")
	private WebElement buttonDelete;
	
	@FindBy(xpath="//input[@value='.']")
	private WebElement buttonDot;
	
	@FindBy(id="calc_basic_input")
	private WebElement result;
	
	public void navigate()
	{
		driver.navigate().to("https://www.google.com");
		driver.navigate().back();
		driver.navigate().forward();
	}
	public void scrollbar()
	{
		driver.manage().window().maximize();
	    //((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",result);
		//((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");//Scroll down
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.MINUTES);
		//((JavascriptExecutor) driver).executeScript("scroll(250,0);");//Scroll up
	}
	public OnlineBasicCalculatorPage(WebDriver driver)
	{
		this.driver = driver;
		if(!"Free Online Basic Calculator (four basic arithmetic operations) @ Internet-Toolbox.com".equals(driver.getTitle())){
			throw new IllegalStateException("This is not a login page");
		}
	}

	public void screenshot() throws IOException
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(scrFile, new File("vijaya:\\seldir\\screenshot.png"));
	}
	public String resultDisplay()
	{
		return resultDisplayTextBox.getText();
	}
	public String result()
	{
		return result.getText();
	}
	
	public void buttonOneClick()
	{
		buttonOne.click();
		System.out.println(driver.manage().window().getSize());
		System.out.println(buttonOne.getLocation());
		driver.manage().window().setSize(new Dimension(500,500));
		System.out.println(buttonOne.getLocation());
	}
	public void buttonTwoClick()
	{
		buttonTwo.click();
	}
	public void buttonThreeClick()
	{
		buttonThree.click();
	}
	public void buttonFourClick()
	{
		buttonFour.click();
	}
	public void buttonFiveClick()
	{
		buttonFive.click();
	}
	public void buttonMultiplyClick()
	{
		buttonMultiply.click();
	}
	public void buttonDivideClick()
	{
		buttonDivide.click();
	}
	public void buttonAddClick()
	{
		buttonAdd.click();
	}
	public void buttonEqualsToClick()
	{
		buttonEqualsTo.click();
	}
	public void buttonDotClick()
	{
		buttonDot.click();
	}
	public void buttonDeleteClick()
	{
		buttonDelete.click();
	}

	public void close() {
		driver.quit();
		
	}
	
}
