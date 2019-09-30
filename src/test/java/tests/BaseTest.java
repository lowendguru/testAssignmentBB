package tests;

import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
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

	protected void login() {
		// TODO: because may be reusable

		// 1. Go to the login page
		driver.get(getProperty("testUrl"));

		// 2. Enter username
		LoginPage.typeEmailField(driver, properties.getProperty("testUserName"));

		// wait

		// enter password

		// click Login

	}

	public String getProperty(String propertyName) {
		return properties.getProperty(propertyName);
	}

}
