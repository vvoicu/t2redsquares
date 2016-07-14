package com.selenium.steps;

import com.selenium.pages.NewVacationRequestPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NewVacationRequestSteps extends ScenarioSteps {
	private static final long serialVersionUID = 1L;
	NewVacationRequestPage newVacationRequestPage;
	
	@Step
	public void clickOnNewVacationRequest(){
		newVacationRequestPage.clickNewVacationRequest();
	}	
}
