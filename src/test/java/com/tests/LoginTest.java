package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.selenium.steps.LoginSteps;
import com.tools.models.Constans;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constans.CSV_FILE_PATH +"Test00_LogIn.csv")
public class LoginTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	
	@Steps LoginSteps loginSteps;
	
	private String username = "attila.marton";
	private String password = "test";
	
	@Test
	
	public void loginTest() {
		/*loginSteps.open_login_page();
		loginSteps.load_signin_page();
		loginSteps.enter_username(username);
		loginSteps.enter_password(password);
		loginSteps.click_signin_button();*/
		loginSteps.perform_login(username, password);
		loginSteps.verify_login();
	}
}
