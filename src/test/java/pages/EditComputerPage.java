package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditComputerPage extends AddComputerPage {

	private static WebElement element = null;

	public static WebElement saveButton(WebDriver driver) {
		element = getWebElement(driver, By.xpath("//*[@id=\"main\"]/form/div/input"));
		return element;
	}

	public static void clickSaveButton(WebDriver driver) {
		saveButton(driver).click();
	}

	public static WebElement deleteButton(WebDriver driver) {
		element = getWebElement(driver, By.xpath("//*[@id=\"main\"]/form[2]/input"));
		return element;
	}

	public static void clickDeleteButton(WebDriver driver) {
		deleteButton(driver).click();
	}
}
