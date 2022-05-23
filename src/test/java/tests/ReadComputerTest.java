package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import entities.Computer;
import pages.ComputersPage;
import pages.EditComputerPage;

public class ReadComputerTest extends BaseTest {

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
	public void readComputerTest() {

		// go to computers
		driver.get(getProperty("testUrl"));

		// search computer
		ComputersPage.typeFilterComputerTextField(driver, computer.getName());
		ComputersPage.clickFilterButton(driver);

		// click on result to open Edit screen
		ComputersPage.clickFirstResultInTable(driver);

		// assert name
		Assert.assertTrue(
				EditComputerPage.computerNameTextField(driver).getAttribute("value").equals(computer.getName()),
				"Computer name does not match");

		// assert introduction
		Assert.assertTrue(
				EditComputerPage.introducedTextField(driver).getAttribute("value").equals(computer.getIntroduced()),
				"Introduced date does not match");

		// assert discontinued
		Assert.assertTrue(
				EditComputerPage.discontinuedTextField(driver).getAttribute("value").equals(computer.getDiscontinued()),
				"Discontinued date does not match");

		// assert company
		Assert.assertTrue(EditComputerPage.getSelectedCompanyText(driver).equals(computer.getCompanyName()),
				"Company name does not match");

	}

}
