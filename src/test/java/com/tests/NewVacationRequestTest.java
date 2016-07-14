package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.selenium.steps.LoginSteps;
import com.selenium.steps.NavigationSteps;
import com.selenium.steps.NewVacationRequestSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)

public class NewVacationRequestTest  {
	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	
	@Steps
	LoginSteps loginSteps;
	@Steps
	NewVacationRequestSteps newVacationRequestSteps;
	@Steps
	NavigationSteps navigationSteps;
	
	private String itemtoSearch = "VACATION";
	private String username = "attila.marton";
	private String password = "test";
	
	@Test
	public void clickOnNewVacationRequestTest(){
		loginSteps.perform_login(username, password);
		navigationSteps.click_menuItem(itemtoSearch);
		newVacationRequestSteps.clickOnNewVacationRequest();
		
	}
	

}
