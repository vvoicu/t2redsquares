package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.selenium.steps.LoginSteps1;
import com.selenium.steps.SiteHeaderSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class LoginTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	
	@Steps LoginSteps1 loginSteps;
	@Steps SiteHeaderSteps landingSteps;
	
	@Test
	public void logging_in() {
		loginSteps.is_the_home_page();
		loginSteps.first_click();
		loginSteps.insert_name("attila.marton");
		loginSteps.insert_pass("test");
		loginSteps.lets_go();
		landingSteps.verify_login2();
		landingSteps.click_vacation();
	}
}
