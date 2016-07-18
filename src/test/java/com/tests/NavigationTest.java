package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.selenium.steps.LoginSteps;
import com.selenium.steps.NavigationSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class NavigationTest {
	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;
		
	@Steps LoginSteps loginSteps;
	@Steps NavigationSteps navigationSteps;
	
	private String itemtoSearch = "BENEFITS";
	private String username = "attila.marton";
	private String password = "test";
	
	@Test
	public void navigation(){
		loginSteps.performLogin(username, password);
		/*loginSteps.open_login_page();
		loginSteps.load_signin_page();
		loginSteps.enter_username(username);
		loginSteps.enter_password(password);
		loginSteps.click_signin_button();*/
		navigationSteps.clickMenuItem(itemtoSearch);
	}
}
