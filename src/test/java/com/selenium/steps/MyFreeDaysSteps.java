package com.selenium.steps;

import com.selenium.pages.MyFreeDaysPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MyFreeDaysSteps extends ScenarioSteps{
	private static final long serialVersionUID = 1L;
	
	MyFreeDaysPage myFreeDaysPage;
	
	@Step
	public void select_my_free_days_option(){
		myFreeDaysPage.selectMyFreeDaysOption();
	}

	@Step
	public void verify_my_free_days_page_is_loaded(){
		myFreeDaysPage.verifyMyFreeDaysPageIsLoaded();
	}
}
