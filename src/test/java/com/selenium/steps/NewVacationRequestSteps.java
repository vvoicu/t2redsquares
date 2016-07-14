package com.selenium.steps;

import com.selenium.pages.NewVacationRequestPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NewVacationRequestSteps extends ScenarioSteps {
	
	NewVacationRequestPage newVacationRequestPage;
	
	@Step
	public void clickOnNewVacationRequest(){
		newVacationRequestPage.clickNewVacationRequest();
	}	
}
