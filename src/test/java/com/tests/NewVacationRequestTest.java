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
	private String myMonth = "Jul";
	private String myYear = "2016";
	private String myStartDay = "18";
	private String myEndDay = "18";
	
	@Test
	public void clickOnNewVacationRequestTest(){
		loginSteps.perform_login(username, password);
		navigationSteps.clickMenuItem(itemtoSearch);
		newVacationRequestSteps.clickOnNewVacationRequest();
		newVacationRequestSteps.clickOnStartDate();
//		newVacationRequestSteps.clickYear();
//		newVacationRequestSteps.seletYear(myYear);
//		newVacationRequestSteps.selectMonth(myMonth);
//		newVacationRequestSteps.selectDay(myDay);
		newVacationRequestSteps.selectDate(myYear, myMonth, myStartDay);
		newVacationRequestSteps.clickOnEndDate();
		newVacationRequestSteps.selectDate(myYear, myMonth, myEndDay);
		
	}
	
}
