package com.selenium.steps;

import com.selenium.pages.MailListingPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MailListingSteps extends ScenarioSteps{
	private static final long serialVersionUID = 1L;
	
	MailListingPage mailListingPage;
	
	@Step
	public void mailListingPage(String host, String storeType, String username, String password, boolean read, String tickOption){
		mailListingPage = new MailListingPage();
		mailListingPage.check(host, storeType, username, password, read, tickOption);
	}
}