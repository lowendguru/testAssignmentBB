package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WaitForAlert {

	public void waitForAlert(WebDriver driver) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());

		} catch (Exception noAlert) {
			noAlert.getMessage();
			Assert.fail("Timeout waiting for Alert.");
		}

	}
}