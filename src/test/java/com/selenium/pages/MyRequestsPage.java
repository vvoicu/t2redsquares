package com.selenium.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class MyRequestsPage {

	@FindBy(css = "a[href*='my-requests']")
	private WebElementFacade myrequestsButton;
	
	public void loadmyRequests() {
		myrequestsButton.click();
	}
}