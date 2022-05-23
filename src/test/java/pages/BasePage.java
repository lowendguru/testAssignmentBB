package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitForElementClickable;
import utils.WaitForElementPresent;
import utils.WaitForElementPresentWithText;

public class BasePage {

	
	public static WebElement getWebElement(WebDriver driver, By locator) {
		WebElement element = null;

		WaitForElementPresent wait = new WaitForElementPresent();
		wait.waitForElementPresent(driver, locator);

		element = driver.findElement(locator);

		return element;
	}

	public static WebElement getWebElementClickable(WebDriver driver, By locator) {
		WebElement element = null;

		WaitForElementClickable wait = new WaitForElementClickable();
		wait.waitForElementClickable(driver, locator);

		element = driver.findElement(locator);

		return element;
	}

	public static WebElement getWebElementWithText(WebDriver driver, By locator, String text) {
		WebElement element = null;

		WaitForElementPresentWithText wait = new WaitForElementPresentWithText();
		wait.waitForElementPresentWithText(driver, locator, text);

		element = driver.findElement(locator);

		return element;
	}

}
