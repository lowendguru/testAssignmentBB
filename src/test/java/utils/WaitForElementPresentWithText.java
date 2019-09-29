package utils;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WaitForElementPresentWithText {

	protected Properties properties = PropertiesFileReader.getProperties();

	public void waitForElementPresentWithText(WebDriver driver, By locator, String text) {
		try {

			WebDriverWait wait = new WebDriverWait(driver,
					Integer.parseInt(properties.getProperty("waitShortTimeout")));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));

		} catch (Exception noAlert) {
			noAlert.getMessage();
			Assert.fail("Timeout waiting for Element to be present.");
		}

	}

}