package com.selenium.steps;

import com.selenium.pages.MyFreeDaysPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MyFreeDaysSteps extends ScenarioSteps {
	private static final long serialVersionUID = 1L;
	
	MyFreeDaysPage myFreeDaysPage;

	@Step
	public void selectMyFreeDaysOption() {
		myFreeDaysPage.selectMyFreeDaysOption();
	}

	@Step
	public void verifyMyFreeDaysPageIsLoaded() {
		myFreeDaysPage.verifyMyFreeDaysPageIsLoaded();
	}

	@Step
	public void calculateTotalAvailableFreeDays() {
		myFreeDaysPage.calculateTotalFreeDays();
	}

	@Step
	public void verifyDateCalculationDays() {
		myFreeDaysPage.verifyDateCalculationDays();
	}
}
