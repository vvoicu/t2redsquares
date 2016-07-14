package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.selenium.steps.LoginSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class LoginTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	
	@Steps LoginSteps loginSteps;
	
	private String username = "attila.marton";
	private String password = "test";
	
	@Test
	public void loginTest() {
		loginSteps.open_login_page();
		loginSteps.load_signin_page();
		loginSteps.enter_username(username);
		loginSteps.enter_password(password);
		loginSteps.click_signin_button();
		/*loginSteps.perform_login("attila.marton", "test" );*/
		loginSteps.verify_login();
	}
}
