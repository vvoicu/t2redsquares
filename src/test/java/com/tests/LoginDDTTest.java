package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.selenium.steps.LoginSteps;

import junit.framework.TestCase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom (value = "src/test/resources/tests/csv/Test00_LogIn.csv",separator=',')
public class LoginDDTTest extends TestCase {

	@Managed(uniqueSession = false)
	public WebDriver webdriver;
	
	@Steps LoginSteps loginSteps;
	
	private String username, password;
	
	@Test
	@Title ("Test00 - LogIn")
	public void test00_LogIn() {
		/*loginSteps.open_login_page();
		loginSteps.load_signin_page();
		loginSteps.enter_username(username);
		loginSteps.enter_password(password);
		loginSteps.click_signin_button();*/
		loginSteps.perform_login(username, password);
		loginSteps.verify_login();
	}
}