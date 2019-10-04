package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import entities.Computer;
import pages.AddComputerPage;
import pages.ComputersPage;
import utils.RandomValueGenerator;

public class CreateComputerTest extends BaseTest {

	private Computer computer;

	@BeforeClass
	public void setUp() {
		super.setUp();
	}

	@AfterClass
	public void tearDown() {
		deleteComputer(computer.getName());
		super.tearDown();
	}

	@Test
	public void createComputerTest() {

		computer = createComputer();

		// assert Done message
		String messageWarning = ComputersPage.messageWarning(driver).getText();
		Assert.assertTrue(messageWarning.contains("Computer " + computer.getName() + " has been created"),
				"Message not displayed");

	}

}
