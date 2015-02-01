package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import pages.ParkingCalculatorPage;

public class ParkingCalculatorPageTest {
	ParkingCalculatorPage calculatorPage;

	@Before
	public void setUp() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://adam.goucher.ca/parkcalc/");
		calculatorPage = PageFactory.initElements(driver, ParkingCalculatorPage.class);
	}

	//@Test
	public void testInvalidInput() {
		final String[] INVALID_ENTRY_TIMES = { "123:23", "34:09", "0:-1",
				"-20", "abs", ":" };

		for (String x : INVALID_ENTRY_TIMES) {
			calculatorPage.chooseLot(0);
			calculatorPage.setEntryTime(x);
			calculatorPage.submit();
			Assert.assertEquals(calculatorPage.getMessage(),
					"ERROR! Enter A Correctly Formatted Date");
		}
	}
	@Test
	
	public void testPickADate()
	{
		calculatorPage.pickADate();
	}
	//@Test
	 public void testDropDownList()
	 {
		calculatorPage.dropDownList();
		calculatorPage.defaultSelectedValue();
	 }
	//@Test
	
	public void testinput()
	{
		calculatorPage.chooseLot(0);
		calculatorPage.setEntryTime("@#:%^");
		calculatorPage.setEntryTimePM();
		calculatorPage.setEntryDate("*$/#$/#$");
		calculatorPage.setExitDate("#$/%^/%$");
		calculatorPage.setExitTime("@#:&*");
		calculatorPage.setExitTimeAM();
		calculatorPage.submit();
		System.out.println(calculatorPage.getMessage());
	}

	//@Test
	public void testValidInput() {
		 final String[][] parameters;
		 final String[] array;
		 int k=0;
		 
		 parameters = new String[3][6];
		 parameters[0]= new String[]{"09:30","12/24/2014","04:23","12/24/2015","$ 9,478.00"};
		 parameters[1]= new String[]{"08:30","12/25/2015","03:23","12/24/2017","$ 18,968.00"};
		 parameters[2]= new String[]{"07:30","12/25/2016","02:23","12/24/2020","$ 37,948.00"};
		 
		 array = new String[]{"$ 9,478.00","$ 18,968.00","$ 37,948.00","$ 2,836.00","$ 5,653.00","$ 11,287.00","$ 3,134.00","$ 6,264.00","$ 12,524.00","$ 3,758.00","$ 7,514.00","$ 15,026.00","$ 10,950.00","$ 21,900.00","$ 43,800.00"};
		
		 for(int j=0;j<5;j++)
		 {
		
		     for(int i=0; i<parameters.length;i++){
			 calculatorPage.chooseLot(j);
		calculatorPage.setEntryTime(parameters[i][0]);
		calculatorPage.setEntryTimePM();
		calculatorPage.setEntryDate(parameters[i][1]);
		calculatorPage.setExitDate(parameters[i][3]);
		calculatorPage.setExitTime(parameters[i][2]);
		calculatorPage.setExitTimeAM();
		calculatorPage.submit();
	
		Assert.assertEquals(calculatorPage.getMessage(), array[k]);
		k++;
		 }
		 }
		//Assert.assertEquals(calculatorPage.getMessage(), "$ 9,473.00");
		
	}
	

	@After
	public void tearDown() {
		calculatorPage.close();
	}
}
