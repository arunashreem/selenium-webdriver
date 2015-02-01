package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage {

	private WebDriver driver;

	@FindBy(id = "draggable")
	private WebElement draggable;

	public WebElement getDraggable() {
		return draggable;
	}

	@FindBy(id = "droptarget")
	private WebElement dropTarget;

	public WebElement getDropTarget() {
		return dropTarget;
	}

	public void dragAndDrop() {

		Actions action = new Actions(driver);

		// action.click(oneButton).moveByOffset(230, 0).perform();
		action.clickAndHold(draggable).moveToElement(dropTarget)
				.release(dropTarget).build().perform();

		// action.dragAndDrop(draggable, dropTarget).perform();
	}

	public DragAndDropPage(WebDriver driver) {
		this.driver = driver;
		
	}

	public void close() {
		driver.quit();
	}
}
