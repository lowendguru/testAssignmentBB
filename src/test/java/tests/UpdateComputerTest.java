package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import entities.Computer;
import pages.AddComputerPage;
import pages.ComputersPage;
import pages.EditComputerPage;
import utils.RandomValueGenerator;

public class UpdateComputerTest extends BaseTest {

	private Computer computer;

	@BeforeClass
	public void setUp() {
		super.setUp();
		computer = createComputer();
	}

	@AfterClass
	public void tearDown() {
		deleteComputer(computer.getName());
		super.tearDown();
	}

	@Test
	public void updateComputerTest() {

		// go to computers
		driver.get(getProperty("testUrl"));

		// search computer
		ComputersPage.typeFilterComputerTextField(driver, computer.getName());
		ComputersPage.clickFilterButton(driver);

		// click on result to open Edit screen
		ComputersPage.clickFirstResultInTable(driver);

		// enter computer name
		EditComputerPage.typeComputerNameTextField(driver, computer.getName());

		// enter introduced
		EditComputerPage.typeIntroducedTextField(driver, RandomValueGenerator.getRandomDate(1));

		// enter discontinued
		EditComputerPage.typeDiscontinuedTextField(driver, RandomValueGenerator.getRandomDate(2));

		// select company
		EditComputerPage.selectCompanyDropdownItem(driver, RandomValueGenerator.getRandomInt(1, 41));

		// click save
		EditComputerPage.clickSaveButton(driver);

		// assert Done message
		String messageWarning = ComputersPage.messageWarning(driver).getText();
		Assert.assertTrue(messageWarning.contains("Computer " + computer.getName() + " has been updated"),
				"Message not displayed");

	}

}
