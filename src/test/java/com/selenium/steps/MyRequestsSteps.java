package com.selenium.steps;

import com.selenium.pages.MyRequestsPage;

import net.thucydides.core.annotations.Step;

public class MyRequestsSteps {

	MyRequestsPage myrequestsPage;
	
	@Step
	public void click_myrequests() {
		myrequestsPage.loadmyRequests();
	}
}
