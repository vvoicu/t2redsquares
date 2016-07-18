package com.tests;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.junit.After;

public class ConfigTest {

	Properties prop = new Properties();
	OutputStream output = null;
	
	@After
	public void writeInFile() throws IOException {

		output = new FileOutputStream("config.properties");

		// set the properties value
		prop.setProperty("userName", "attila.marton");
		prop.setProperty("passWord", "test");

		// save properties to project root folder
		prop.store(output, null);
	}
}