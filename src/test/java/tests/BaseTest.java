package tests;

import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import entities.Computer;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AddComputerPage;
import pages.ComputersPage;
import pages.EditComputerPage;
import utils.PropertiesFileReader;
import utils.WaitForAlert;
import utils.WaitForPageToLoad;

public class BaseTest {

	protected static WebDriver driver;
	protected Properties properties = PropertiesFileReader.getProperties();

	protected WaitForPageToLoad waiting = new WaitForPageToLoad();
	protected WebDriverWait wait;
	protected WaitForAlert waitingAlert = new WaitForAlert();

	@BeforeClass
	protected void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");

		if (getProperty("headless").equals("true"))
			options.addArguments("--headless");

		options.addArguments("no-sandbox");
		driver = new ChromeDriver(options);

		driver.manage().window().setSize(new Dimension(Integer.parseInt(getProperty("browserWidth")),
				Integer.parseInt(getProperty("browserHeight"))));
	}

	@AfterClass
	protected void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	public String getProperty(String propertyName) {
		return properties.getProperty(propertyName);
	}

	public Computer createComputer() {

		Computer computerPojo = new Computer();
		computerPojo.initialize();

		// go to computers
		driver.get(getProperty("testUrl"));

		// click add
		ComputersPage.clickAddComputerButton(driver);

		// enter computer name
		AddComputerPage.typeComputerNameTextField(driver, computerPojo.getName());

		// enter introduced
		AddComputerPage.typeIntroducedTextField(driver, computerPojo.getIntroduced());

		// enter discontinued
		AddComputerPage.typeDiscontinuedTextField(driver, computerPojo.getDiscontinued());

		// select company
		AddComputerPage.selectCompanyDropdownItem(driver, computerPojo.getCompanyValue());
		// get company name from dropdown
		computerPojo.setCompanyName(AddComputerPage.getSelectedCompanyText(driver));

		// click create
		AddComputerPage.clickCreateButton(driver);

		return computerPojo;
	}

	public void deleteComputer(String computerName) {

		// go to computers
		driver.get(getProperty("testUrl"));

		// search computer
		ComputersPage.typeFilterComputerTextField(driver, computerName);
		ComputersPage.clickFilterButton(driver);

		// click on result to open Edit screen
		ComputersPage.clickFirstResultInTable(driver);

		// click delete button
		EditComputerPage.clickDeleteButton(driver);

	}

}
