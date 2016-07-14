package com.selenium.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class MyRequestsPage extends PageObject{

	@FindBy(css = "a[href*='my-requests']")
	private WebElement myrequestsButton;
	
	public void loadmyRequests() {
		myrequestsButton.click();
	}
}