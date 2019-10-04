package entities;

import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
import utils.PropertiesFileReader;
import utils.RandomValueGenerator;

public class Computer {

	private String name;
	private String introduced;
	private String discontinued;
	private int companyValue;
	private String companyName;

	public void initialize() {
		name = RandomValueGenerator.getRandomText(20);
		introduced = RandomValueGenerator.getRandomDate(1);
		discontinued = RandomValueGenerator.getRandomDate(2);
		companyValue = RandomValueGenerator.getRandomInt(1,
				Integer.parseInt(PropertiesFileReader.getProperties().getProperty("maxCompanyIndex")));

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduced() {
		return introduced;
	}

	public void setIntroduced(String introduced) {
		this.introduced = introduced;
	}

	public String getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(String discontinued) {
		this.discontinued = discontinued;
	}

	public int getCompanyValue() {
		return companyValue;
	}

	public void setCompanyValue(int companyValue) {
		this.companyValue = companyValue;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
