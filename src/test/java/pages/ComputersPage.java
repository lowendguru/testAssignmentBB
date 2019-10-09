package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComputersPage extends BasePage {

	private static WebElement element = null;

	public static WebElement filterComputerTextField(WebDriver driver) {
		element = getWebElement(driver, By.id("searchbox"));
		return element;
	}

	public static void typeFilterComputerTextField(WebDriver driver, String text) {
		filterComputerTextField(driver).clear();
		filterComputerTextField(driver).sendKeys(text);
	}

	public static WebElement filterComputerButton(WebDriver driver) {
		element = getWebElement(driver, By.id("searchsubmit"));
		return element;
	}

	public static void clickFilterButton(WebDriver driver) {
		filterComputerButton(driver).click();
	}

	public static WebElement addComputerButton(WebDriver driver) {
		element = getWebElement(driver, By.id("add"));
		return element;
	}

	public static WebElement messageWarning(WebDriver driver) {
		element = getWebElement(driver, By.xpath("//*[@id=\"main\"]/div[1]"));
		return element;
	}

	public static void clickAddComputerButton(WebDriver driver) {
		addComputerButton(driver).click();
	}

	public static void clickFirstResultInTable(WebDriver driver) {
		getWebElement(driver, By.xpath("//*[@id=\"main\"]/table/tbody/tr[1]/td[1]/a")).click();
	}

	public static WebElement messageBody(WebDriver driver) {
		element = getWebElement(driver, By.xpath("//*[@id=\"main\"]/div[2]/em"));
		return element;
	}

}
