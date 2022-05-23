package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import entities.Computer;
import pages.ComputersPage;
import pages.EditComputerPage;

public class UpdateComputerTest extends BaseTest {

	private Computer computer;
	private Computer computer2;

	@BeforeClass
	public void setUp() {
		super.setUp();
		computer = createComputer();
	}

	@AfterClass
	public void tearDown() {
		deleteComputer(computer2.getName());
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

		// generate new values to use
		computer2 = new Computer();
		computer2.initialize();

		// enter computer name
		EditComputerPage.typeComputerNameTextField(driver, computer2.getName());

		// enter introduced
		EditComputerPage.typeIntroducedTextField(driver, computer2.getIntroduced());

		// enter discontinued
		EditComputerPage.typeDiscontinuedTextField(driver, computer2.getDiscontinued());

		// select company
		EditComputerPage.selectCompanyDropdownItem(driver, computer2.getCompanyValue());

		// click save
		EditComputerPage.clickSaveButton(driver);

		// assert Done message
		String messageWarning = ComputersPage.messageWarning(driver).getText();
		Assert.assertTrue(messageWarning.contains("Computer " + computer2.getName() + " has been updated"),
				"Message not displayed");

	}

}
