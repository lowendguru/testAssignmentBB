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

	}

}
