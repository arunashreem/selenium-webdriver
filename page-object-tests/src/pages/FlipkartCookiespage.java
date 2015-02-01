package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipkartCookiespage {

	private WebDriver driver;

	@FindBy(id = "fk-top-search-box")
	private WebElement searchTextBox;

	@FindBy(partialLinkText = "Signup")
	private WebElement signUpClick;

	@FindBy(id = "signup-email")
	private WebElement signUpEmail;

	// @FindBy(className="search-bar-submit fk-font-13 fk-font-bold")
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchButton;

	public void signUp() {
		signUpClick.click();
		File file = new File(
				"/Users/vijaya/Documents/workspace/page-object-tests/src/pages/dataFile.properties");
		FileInputStream fileinput = null;
		try {
			fileinput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Properties prop = new Properties();
		try {
			prop.load(fileinput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		signUpEmail.clear();
		signUpEmail.click();
		signUpEmail.sendKeys(prop.getProperty("username"));

		Enumeration<Object> keyValues = prop.keys();

	}

	public void enterValueSearchTextBox() {
		searchTextBox.click();
		searchTextBox.clear();
		searchTextBox.sendKeys("Kenstar");

	}

	public void searchbtnclick() {
		searchButton.click();
	}

	public FlipkartCookiespage(WebDriver driver) {
		this.driver = driver;
	}

	public void addCookies() {
		Cookie name = new Cookie("mycookie", "123456789123");
		driver.manage().addCookie(name);
	}

	public void deleteCookies() {
		// driver.manage().deleteCookie(arg0); //Delete a cookie from the
		// browser's "cookie jar".
		driver.manage().deleteCookieNamed("mycookie");
	}

	public void displayCookies() {
		Set<Cookie> cookiesList = driver.manage().getCookies();
		for (Cookie getcookies : cookiesList) {
			System.out.println(getcookies);
		}

	}

	public void close() {
		driver.quit();
	}

}
