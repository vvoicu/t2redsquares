package com.selenium.steps;

import com.selenium.pages.MyRequestsPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MyRequestsSteps extends ScenarioSteps{
	private static final long serialVersionUID = 1L;
	
	MyRequestsPage myrequestsPage;
	
	@Step
	public void click_myrequests() {
		myrequestsPage.loadmyRequests();
	}
}
