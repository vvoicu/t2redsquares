package com.selenium.pages;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MyFreeDaysPage extends PageObject{
	
	@FindBy(css="a[href*='my-free-days']")
	private WebElementFacade myFreeDaysOption;
	
	@FindBy(css="div.active div.date-hired")
	private WebElementFacade dateHired;
	
	public void selectMyFreeDaysOption(){
		myFreeDaysOption.click();
	}

	public void verifyMyFreeDaysPageIsLoaded(){
		
			Assert.assertTrue("My free days page is not loaded",dateHired.isDisplayed());
		
	}
}
