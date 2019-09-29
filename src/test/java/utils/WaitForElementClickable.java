package utils;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WaitForElementClickable {

	protected Properties properties = PropertiesFileReader.getProperties();

	public void waitForElementClickable(WebDriver driver, By locator) {

		try {

			WebDriverWait wait = new WebDriverWait(driver,
					Integer.parseInt(properties.getProperty("waitShortTimeout")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			wait.until(ExpectedConditions.elementToBeClickable(locator));

			// wait until animation stops
			wait.until(steadinessOfElementLocated(locator));

		} catch (Exception noAlert) {
			noAlert.getMessage();
			Assert.fail("Timeout waiting for Element to be present and Clickable.");
		}

	}

	public static ExpectedCondition<WebElement> steadinessOfElementLocated(final By locator) {
		return new ExpectedCondition<WebElement>() {

			private WebElement _element = null;
			private Point _location = null;

			@Override
			public WebElement apply(WebDriver driver) {
				if (_element == null) {
					try {
						_element = driver.findElement(locator);
					} catch (NoSuchElementException e) {
						return null;
					}
				}

				try {
					if (_element.isDisplayed()) {
						Point location = _element.getLocation();
						if (location.equals(_location) && isOnTop(_element)) {
							return _element;
						}
						_location = location;
					}
				} catch (StaleElementReferenceException e) {
					_element = null;
				}

				return null;
			}

			@Override
			public String toString() {
				return "steadiness of element located by " + locator;
			}
		};
	}

	public static boolean isOnTop(WebElement element) {
		WebDriver driver = ((RemoteWebElement) element).getWrappedDriver();

		return (boolean) ((JavascriptExecutor) driver).executeScript("var elm = arguments[0];"
				+ "var doc = elm.ownerDocument || document;" + "var rect = elm.getBoundingClientRect();"
				+ "return elm === doc.elementFromPoint(rect.left + (rect.width / 2), rect.top + (rect.height / 2));",
				element);
	}

}