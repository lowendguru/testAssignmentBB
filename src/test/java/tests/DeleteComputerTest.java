package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import entities.Computer;
import pages.ComputersPage;

public class DeleteComputerTest extends BaseTest {

	private Computer computer;

	@BeforeClass
	public void setUp() {
		super.setUp();
		computer = createComputer();
	}

	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Test
	public void deleteComputerTest() {

		deleteComputer(computer.getName());

		// assert Delete message
		String messageWarning = ComputersPage.messageWarning(driver).getText();
		Assert.assertTrue(messageWarning.contains("Done! Computer has been deleted"), "Message not displayed");

		// search computer
		ComputersPage.typeFilterComputerTextField(driver, computer.getName());
		ComputersPage.clickFilterButton(driver);

		// assert computer is not present after searching
		String messageBody = ComputersPage.messageBody(driver).getText();
		Assert.assertTrue(messageBody.equals("Nothing to display"), "Message not displayed");

	}

}
