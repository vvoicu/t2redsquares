package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.selenium.steps.LoginSteps;
import com.tools.models.Constants;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.CSV_FILE_PATH + "Test00_LogIn.csv")
public class LoginTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	
	
	@Steps LoginSteps loginSteps;
	
	private String username;
	private String password;
	
	@Test
	public void loginTest() {
		loginSteps.perform_login(username, password);
		loginSteps.verify_login();
	}
}
