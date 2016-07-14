package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.selenium.steps.LoginSteps;
import com.selenium.steps.MyFreeDaysSteps;
import com.selenium.steps.NavigationSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class MyFreeDaysTest {
	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	
	@Steps LoginSteps loginSteps;
	@Steps NavigationSteps navigationSteps;
	@Steps MyFreeDaysSteps myFreeDaysSteps;
	
	@Test
	public void myFreeDaysTest(){
		loginSteps.perform_login("paula.klein", "test");
		navigationSteps.click_menuItem("VACATION");
		myFreeDaysSteps.select_my_free_days_option();
		myFreeDaysSteps.verify_my_free_days_page_is_loaded();
	}
}
