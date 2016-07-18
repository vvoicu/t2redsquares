package com.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Before;

import com.tools.models.Constants;

public class BaseTest  {

		Properties prop = new Properties();
		FileInputStream input = null;
		
		protected String userName,password;
		
		@Before
		public void dataSetUp() throws IOException{

			input = new FileInputStream(Constants.CONFIG_PATH);
			prop.load(input);

			// get the properties value
			userName = prop.getProperty("userName");
			password = prop.getProperty("password");

		}
	  

}
