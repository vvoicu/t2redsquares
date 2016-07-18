package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.selenium.steps.LoginSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

//@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom(value = Constants.CSV_FILE_PATH + "Test00_LogIn.csv")

@RunWith(SerenityRunner.class)
public class LoginTest extends BaseTest {
	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	
	@Steps LoginSteps loginSteps;

//	private String username = "attila.marton";
//	private String password = "test";

//	private String username;
//	private String password;

	@Test
	public void loginTest() {
		loginSteps.perform_login(username, password);
		loginSteps.verify_login();
	}
}

