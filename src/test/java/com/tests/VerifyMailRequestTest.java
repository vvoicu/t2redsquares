package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.selenium.steps.LoginSteps;
import com.selenium.steps.NavigationSteps;
import com.selenium.steps.NewVacationRequestSteps;
import com.selenium.steps.VerifyVacationRequestSteps;
import com.tools.models.Constants;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.CSV_FILE_PATH + "Test00_NewVacationRequest.csv")
public class VerifyMailRequestTest {
	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	
	@Steps
	LoginSteps loginSteps;
	@Steps
	NavigationSteps navigationSteps;
	@Steps
	NewVacationRequestSteps newVacationRequestSteps;
	@Steps
	VerifyVacationRequestSteps verifyVacationRequestSteps;
	
	
	
private String itemtoSearch = "VACATION";
	
	private String username;
	private String password;
	
	private String startMonth;
	private String startYear;
	private String StartDay;
	private String EndDay;
	private String endMonth;
	private String endYear;
	
	private String VacationType;
	private String SpecialVacationType;
	private String subject = "Future testers,we are going out!";
	
	@Test
	public void verifyMailTest(){
		loginSteps.performLogin(username, password);
		navigationSteps.clickMenuItem(itemtoSearch);
		newVacationRequestSteps.clickOnNewVacationRequest();
		newVacationRequestSteps.clickOnStartDate();
		newVacationRequestSteps.selectDate(startYear, startMonth, StartDay);
		newVacationRequestSteps.clickOnEndDate();
		newVacationRequestSteps.selectDate(endYear, endMonth, EndDay);
		newVacationRequestSteps.selectVacationType(VacationType);
		newVacationRequestSteps.selectSpecial(SpecialVacationType);
		newVacationRequestSteps.clickOnSaveButton();
		
		verifyVacationRequestSteps.verifyMail(subject);
		
	}

}
