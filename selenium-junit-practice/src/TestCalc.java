import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
//org.openqa.selenium.io.FileHandler
public class TestCalc {

	public WebDriver driver;
	private String[][] parameters;
	private Alert alert;
	
	public static final String CHROME_DRIVER_PATH = 
			"/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
	public static final int CHROME_DRIVER_PORT = 65423;
	
	private ChromeDriverService srvc;

	//@Before
	@Test
	public void setUp() {
		
		// driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		ChromeDriverService.Builder builder = new ChromeDriverService.Builder();
		 srvc = builder
				.usingDriverExecutable(new File(CHROME_DRIVER_PATH))
				.usingPort(CHROME_DRIVER_PORT).build();

		try {
			srvc.start();
			System.out.println(srvc.isRunning());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("I am here.");
		
		driver = new ChromeDriver(srvc);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.calculator.net/mortgage-calculator.html");
		
		System.out.println("I am here now.");
		
	}
//@Test
public void iAmTheDriver(){
	WebDriver driver = new FirefoxDriver();
	EventFiringWebDriver eventFiringDriver = new EventFiringWebDriver(driver);
	
	
	IAmTheEventListener  eventListener = new  IAmTheEventListener();
	IAmTheEventListener2 eventListener2 = new IAmTheEventListener2();
	eventFiringDriver.register(eventListener);
	eventFiringDriver.register(eventListener2);
	eventFiringDriver.get("http://www.google.com");
	WebElement element = driver.findElement(By.name("q"));
	element.sendKeys("hello");
	//eventFiringDriver.get("http://www.facebook.com");
	//eventFiringDriver.navigate().back();
}

//@Test

public void createDirectory(){
	try{
		FileHandler.createDir(new File("vijaya:\\seldir"));
		
	}catch (IOException e) {
        e.printStackTrace();
	}
	
	try{
		FileHandler.createDir(new File("vijaya:\\seldirdes"));
		
	}catch (IOException e) {
        e.printStackTrace();
	}
	try {
        FileHandler.copy(new File("vijaya:\\seldir"), new File("vijaya:\\seldirdes"));
    } catch (IOException e) {
        e.printStackTrace();
    }
        try{
        	System.out.println(FileHandler.isZipped("vijaya:\\seldirdes"));
        	String fileContent = FileHandler.readAsString(new File("vijaya:\\seldir\\file1.rtf"));
            System.out.println(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File f = TemporaryFilesystem.getDefaultTmpFS()
                .createTempDir("prefix", "suffix");
        System.out.println(f.getAbsolutePath());
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

}
	



// @Test
	public void testTableContent() {
		// 1. Check the number of rows in the "Monthly"/"Annual" Amort..
		// Schedule

		WebElement AS = driver.findElement(By
				.cssSelector("a[onclick='showAmo(0);return false;']"));
		AS.click();
		// System.out.println(driver.getTitle());
		List<WebElement> rows = driver
				.findElements(By
						.xpath("/html/body/table[2]/tbody/tr/td[1]/div[1]/div[4]/table/tbody/tr"));

		System.out.println(rows.size());

		WebElement MS = driver.findElement(By
				.cssSelector("a[onclick='showAmo(1);return false;']"));
		MS.click();

		// 2. Check the contents of table cells in the right side table.
		// 3. Check the number of columns in the tables.
	}

	/*
	 * @Test public void fireFoxCustomProfile() { FirefoxProfile profile = new
	 * FirefoxProfile(); try{ profile.addExtension(new File ); } FirefoxDriver
	 * driver = new FirefoxDriver(profile); driver.get("http://www.google.com");
	 * 
	 * }
	 */
	//@Test
	public void testClickLink() {
		WebElement btncal = driver.findElement(By
				.cssSelector("input[src = '/img/calculate.png']"));
		btncal.click();

		WebDriverWait wait = new WebDriverWait(driver, 20);

		// WebElement lnkclk = wait.until(
		// ExpectedConditions.presenceOfElementLocated(By.linkText("4.18%")));

		/*
		 * Predicate<WebDriver> condition = new Predicate<WebDriver>() {
		 * 
		 * @Override public boolean apply(WebDriver t) {
		 * System.out.println("apply...."); return
		 * t.findElement(By.linkText("4.18%")) != null; } };
		 * 
		 * wait.until(condition);
		 */

		WebElement lnkclk = wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver t) {
				System.out.println("apply....");
				return t.findElement(By.linkText("4.18%"));
			}
		});

		// WebElement lnkclk = driver.findElement(By.linkText("4.18%"));
		System.out.println(lnkclk);

		/*
		 * driver.findElement(By.linkText("4.99%")); WebDriverWait wait =new
		 * WebDriverWait(driver, 5000); wait.withTimeout(600, TimeUnit.SECONDS);
		 * wait.pollingEvery(500, TimeUnit.SECONDS);
		 * wait.ignoring(NoSuchElementException.class);
		 * 
		 * Function<WebDriver,Boolean> f= new Function<WebDriver, Boolean>() {
		 * public Boolean apply(WebDriver driver) {
		 * System.out.println("Apply called.");
		 * if(!lnkclk.getText().equals("4.99%")) {
		 * System.out.println("text not found"); return false; }
		 * System.out.println("text not found outside");
		 * 
		 * return true;
		 * 
		 * } }; wait.until((Predicate<WebDriver>) f);
		 */

		// Assert.assertNotNull(lnkclk);

		lnkclk.click();
		WebElement txtbox = driver.findElement(By.id("cinterestrate"));
		Assert.assertEquals("4.18", txtbox.getAttribute("Value"));

		String obj1 = new String("S1");
		String obj2 = "S1"; // obj1; // new String("S1");

		Assert.assertEquals(obj1, obj2);
		Assert.assertSame(obj1, obj2);
		Assert.assertNotSame(obj1, obj2);

		System.out.println(txtbox.getAttribute("Value"));

		WebElement lnkc = driver.findElement(By.linkText("5.99%"));
		lnkc.click();
		txtbox = driver.findElement(By.id("cinterestrate"));
		Assert.assertEquals("5.99", txtbox.getAttribute("Value"));

		System.out.println(txtbox.getAttribute("Value"));

	}

	// @Test
	public void testSelectBox() {
		WebElement selectBox = driver.findElement(By.id("cstartmonth"));
		selectBox.click();
		WebElement value = driver.findElement(By.xpath("//option[@value='3']")); // (By.cssSelector("option[value='3']"));
		value.click();
		// System.out.println(value.getSize());
		Assert.assertEquals("Mar", value.getText());

		WebElement year = driver.findElement(By.id("cstartyear"));
		year.clear();
		year.sendKeys("-98");
		WebElement btncal = driver.findElement(By
				.cssSelector("input[src = '/img/calculate.png']"));
		btncal.click();

		String vtext = driver.findElement(By.tagName("font")).getText();
		Assert.assertTrue("Please provide a positive start date value.",
				vtext.contains(vtext));
	}

	// @Test
	public void testCheckBox() {
		WebElement chkbx = driver.findElement(By.id("caddoptional"));

		if (!chkbx.isSelected()) {
			chkbx.click();
		}
		Assert.assertTrue(chkbx.isSelected());

	}

	// @Test
	public void testLinkNavigation() {
		/*
		 * WebElement lnkn = driver.findElement(By
		 * .cssSelector("a[target='_blank']")); lnkn.click();
		 * Assert.assertEquals
		 * ("http://www.usbanklocations.com/your-rate.php?type=mortgage",
		 * lnkn.getAttribute("href")); driver.getWindowHandle();
		 */

		driver = new FirefoxDriver();
		driver.get("http://www.calculator.net/mortgage-calculator.html");

		// String window1 = driver.getWindowHandle();
		// System.out.println("first window is "+window1);

		WebElement link = driver.findElement(By
				.cssSelector("a[target='_blank']"));
		link.click();

		// driver.switchTo().window(window2);

		System.out.println(driver.getWindowHandles().size());

		Set<String> handles = driver.getWindowHandles();
		// for(String handle : driver.getWindowHandles())
		// driver.switchTo().window(handle);
		Iterator<String> it = handles.iterator();

		while (it.hasNext()) {
			String window1 = it.next();
			String window2 = it.next();

			driver.switchTo().window(window2);
			System.out.println(driver.getTitle());
			Assert.assertEquals("Check Your Rate : USBankLocations.com",
					driver.getTitle());

			driver.close();
			driver.switchTo().window(window1);
			System.out.println(driver.getTitle());
		}

		// String window2 = driver.getWindowHandle();
		// System.out.println(window2);
		// driver.close();
		// driver.switchTo().window(window1);

	}

	// @Test
	public void webDriverNavigate() {
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://www.google.com");

		/*
		 * try: element = WebDriverWait(driver, 10).until(
		 * EC.presence_of_element_located((By.ID, "myDynamicElement")) )
		 * finally: driver.quit()
		 * 
		 * WebElement element = (new WebDriverWait(driver, 20)).until(new
		 * ExpectedCondition<WebElement>() {
		 * 
		 * @Override public WebElement apply(WebDriver d) { return
		 * d.findElement(By.name("q")); } });
		 */
		// WebElement searchb = (new WebDriverWait(driver, 20)).until(new
		// Presence(locator)

		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("Selenium Webdriver");

		WebElement searchbtn = driver.findElement(By.name("btnG"));
		searchbtn.click();

		searchbox.clear();
		searchbox.sendKeys("Packt Publishing");
		searchbtn.click();

		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();

		driver.quit();
	}

	// @After
	public void teardown() {
		driver.quit();
	}
}
