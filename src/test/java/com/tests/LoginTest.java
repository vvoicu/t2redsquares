package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.selenium.steps.LoginSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class LoginTest{

	@Managed(uniqueSession = true)
	WebDriver webdriver;

	@Steps LoginSteps loginSteps;

//	private String username = "attila.marton";
//	private String password = "test";

	@Test
	public void loginTest() {
		loginSteps.perform_login(username, password);
		loginSteps.verify_login();
	}
}