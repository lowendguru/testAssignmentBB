package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddComputerPage extends BasePage {

	private static WebElement element = null;

	public static WebElement computerNameTextField(WebDriver driver) {
		element = getWebElement(driver, By.id("name"));
		return element;
	}

	public static WebElement introducedTextField(WebDriver driver) {
		element = getWebElement(driver, By.id("introduced"));
		return element;
	}

	public static WebElement discontinuedTextField(WebDriver driver) {
		element = getWebElement(driver, By.id("discontinued"));
		return element;
	}

	public static WebElement companyDropdown(WebDriver driver) {
		element = getWebElement(driver, By.id("company"));
		return element;
	}

	public static void selectCompanyDropdownItem(WebDriver driver, String selectText) {
		Select dropdown = new Select(companyDropdown(driver));
		dropdown.selectByVisibleText(selectText);
	}

	public static void selectCompanyDropdownItem(WebDriver driver, int selectIndex) {
		Select dropdown = new Select(companyDropdown(driver));
		dropdown.selectByIndex(selectIndex);
	}

	public static String getSelectedCompanyText(WebDriver driver) {
		Select dropdown = new Select(companyDropdown(driver));
		return dropdown.getFirstSelectedOption().getText();
	}

	public static WebElement createButton(WebDriver driver) {
		element = getWebElement(driver, By.xpath("//*[@id=\"main\"]/form/div/input"));
		return element;
	}

	public static WebElement cancelButton(WebDriver driver) {
		element = getWebElement(driver, By.xpath("//*[@id=\"main\"]/form/div/a"));
		return element;
	}

	public static void typeComputerNameTextField(WebDriver driver, String text) {
		computerNameTextField(driver).clear();
		computerNameTextField(driver).sendKeys(text);
	}

	public static void typeIntroducedTextField(WebDriver driver, String text) {
		introducedTextField(driver).clear();
		introducedTextField(driver).sendKeys(text);
	}

	public static void typeDiscontinuedTextField(WebDriver driver, String text) {
		discontinuedTextField(driver).clear();
		discontinuedTextField(driver).sendKeys(text);
	}

	public static void clickCreateButton(WebDriver driver) {
		createButton(driver).click();
	}

	public static void clickCancelButton(WebDriver driver) {
		cancelButton(driver).click();
	}
}
