import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;




public class Calculator {
	
 private WebDriver driver;
 private String[][] parameters;
 
	@Before
	public void setup(){
	    driver = new FirefoxDriver();
		driver.get("http://www.calculator.net/mortgage-calculator.html");
		parameters = new String[3][2];
		parameters [0] = new String[]{"400000","1,535.12"};
		parameters[1]= new String[]{"600000","2,302.68"};
		parameters[2] = new String[]{"700","2.69"};
	}
	
	@Test
	public void test(){
		
		//final String cssSelector = "input[src = '/img/calculate.png']";
		for(int i=0;i<parameters.length;i++)
		{
			WebElement element = driver.findElement(By.id("chouseprice"));
			element.clear();
		element.sendKeys(parameters[i][0]);
	 WebElement btncal = driver.findElement(By.cssSelector("input[src = '/img/calculate.png']"));
		btncal.click();
		WebElement output = driver.findElement(By.className("h2result"));
		Assert.assertEquals(output.getText(), "Monthly Pay:   $" + parameters[i][1]);
		}
		
		
		
		
	}
	@After
	 public void teardown(){
		driver.quit();
		
	}
	
}
