package com.tests;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;

import com.tools.models.Constants;

public class BaseTest {

	Properties prop = new Properties();
	InputStream input = null;
	OutputStream output = null;
	
	protected String username, password;
	
	@Before
	public void dataSetUp() throws IOException {

		input = new FileInputStream(Constants.CONFIG_FILE_PATH);
		prop.load(input);
		
		username = prop.getProperty("username");
		password = prop.getProperty("password");
	}
	
	@After
	public void writeData() throws IOException {

			output = new FileOutputStream(Constants.CONFIG_WRITE_FILE_PATH);
			prop.store(output, "Login details for user");
			
			username = prop.getProperty("username");
			password = prop.getProperty("password");
	}
}
	

