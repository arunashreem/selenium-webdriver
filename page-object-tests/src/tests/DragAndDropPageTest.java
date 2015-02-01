package tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import pages.DragAndDropPage;

public class DragAndDropPageTest {
	DragAndDropPage dragDropPage;
	public static final String CHROME_DRIVER_PATH = 
			"/Users/vijaya/tools/chromedriver";
	
	private ChromeDriverService srvc;
	
	@Before
	public void setUp() {
	//WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		ChromeDriverService.Builder builder = new ChromeDriverService.Builder();
		 srvc = builder
				.usingDriverExecutable(new File(CHROME_DRIVER_PATH))
				//.usingPort(CHROME_DRIVER_PORT)
				.build();

		try {
			srvc.start();
			System.out.println(srvc.isRunning());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("I am here.");
		
		WebDriver driver = new ChromeDriver(srvc);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://demos.telerik.com/kendo-ui/dragdrop/index");
		dragDropPage = PageFactory.initElements(driver, DragAndDropPage.class);
	}

	@Test
	public void testDragAndDrop() {
		Assert.assertEquals(dragDropPage.getDropTarget().getText(), "Drag the small circle here.");
		dragDropPage.dragAndDrop();
		Assert.assertEquals(dragDropPage.getDropTarget().getText(), "You did great!");
	}

	// @After
	public void tearDown() {
		dragDropPage.close();
	}
}
