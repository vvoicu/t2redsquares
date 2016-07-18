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
public class MyFreeDaysTest extends BaseTest{
	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	
	@Steps LoginSteps loginSteps;
	@Steps NavigationSteps navigationSteps;
	@Steps MyFreeDaysSteps myFreeDaysSteps;
	
//	private String username = "attila.marton";
//	private String password = "test";
	private String itemtoSearch = "VACATION";
	
	@Test
	public void myFreeDaysTest(){
		loginSteps.perform_login(username, password);
		navigationSteps.clickMenuItem(itemtoSearch);
		myFreeDaysSteps.selectMyFreeDaysOption();
//		myFreeDaysSteps.verifyMyFreeDaysPageIsLoaded();
		myFreeDaysSteps.calculateTotalAvailableFreeDays();
		myFreeDaysSteps.verifyDateCalculationDays();

	}
}
