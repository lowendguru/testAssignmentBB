package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AddComputerPage;
import pages.ComputersPage;
import utils.RandomValueGenerator;

public class CreateComputerTests extends BaseTest {

	@BeforeClass
	public void setUp() {
		super.setUp();
	}

	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Test(groups = { "user", "happyPath" })
	public void validCreateComputer() {

		// go to computers
		driver.get(getProperty("testUrl"));

		// click add
		ComputersPage.clickAddComputerButton(driver);

		String computerName = RandomValueGenerator.getRandomText(20);

		// enter computer name
		AddComputerPage.typeComputerNameTextField(driver, computerName);

		// enter introduced
		AddComputerPage.typeIntroducedTextField(driver, RandomValueGenerator.getRandomDate(1));

		// enter discontinued
		AddComputerPage.typeDiscontinuedTextField(driver, RandomValueGenerator.getRandomDate(2));

		// select company
		AddComputerPage.selectCompanyDropdownItem(driver, RandomValueGenerator.getRandomInt(1, 41));

		// click create
		AddComputerPage.clickCreateButton(driver);

		// assert Done message
		String messageWarning = ComputersPage.messageWarning(driver).getText();
		Assert.assertTrue(messageWarning.contains("Computer " + computerName + " has been created"),
				"Alert message not displayed");

	}

}
