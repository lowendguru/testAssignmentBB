package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

	private static final String PROPERTIES_FILE = "src/test/resources/dataFiles/datafile.properties";
	private static Properties properties;

	public static Properties getProperties() {
		// load properties file
		if (properties == null) {
			File file = new File(PROPERTIES_FILE);
			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			properties = new Properties();
			try {
				properties.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return properties;
	}
}
