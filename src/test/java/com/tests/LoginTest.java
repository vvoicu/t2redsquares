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
public class LoginTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	
	@Steps LoginSteps loginSteps;
	@Steps NavigationSteps siteheaderSteps;
	
	private String name = "attila.marton";
	private String password = "test";
	
	@Test
	public void logging_in() {
		loginSteps.is_the_home_page();
		loginSteps.first_click();
		loginSteps.insert_name(name);
		loginSteps.insert_pass(password);
		loginSteps.lets_go();
	}
}
