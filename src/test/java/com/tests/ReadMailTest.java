package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.selenium.steps.LoginSteps;
import com.selenium.steps.NavigationSteps;
import com.selenium.steps.NewVacationRequestSteps;
import com.selenium.steps.ReadMailSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class ReadMailTest{

		@Managed(uniqueSession = true)
		public WebDriver webdriver;
		
		@Steps
		LoginSteps loginSteps;
		@Steps
		NewVacationRequestSteps newVacationRequestSteps;
		@Steps
		NavigationSteps navigationSteps;
		@Steps
		ReadMailSteps readMailSteps;
		
		
		@Test
		public void clickOnNewVacationRequestTest(){
			loginSteps.performLogin("paula.klein", "test");
			navigationSteps.clickMenuItem("VACATION");
			newVacationRequestSteps.clickOnNewVacationRequest();
			newVacationRequestSteps.clickOnStartDate();
			newVacationRequestSteps.selectDate("2016", "Jul", "28");
			newVacationRequestSteps.clickOnEndDate();
			newVacationRequestSteps.selectDate("2016", "Jul", "29");
			newVacationRequestSteps.selectVacationType("Holiday");
			newVacationRequestSteps.clickOnSaveButton();
			
		}	
}


