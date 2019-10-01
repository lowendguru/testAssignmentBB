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
	public void validLogin() {

		// go to computers
		driver.get(getProperty("testUrl"));

		// click add
		ComputersPage.clickAddComputerButton(driver);

		String computerName = RandomValueGenerator.getRandomText(20);

		// enter computer name
		AddComputerPage.typeComputerNameTextField(driver, computerName);

		// TODO randomize
		// enter introduced
		AddComputerPage.typeIntroducedTextField(driver, "2000-01-01");

		// TODO
		// enter discontinued
		AddComputerPage.typeDiscontinuedTextField(driver, "2000-01-01");

		// select company
		// TODO

		// click create
		AddComputerPage.clickCreateButton(driver);

		// assert Done message
		Assert.assertTrue(ComputersPage.messageWarning(driver).getText()
				.contains("Computer " + computerName + "a has been created"), "Alert message not displayed");

		// filter

		// assert filter results

	}

}
