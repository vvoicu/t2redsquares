package com.selenium.pages;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class FreeDaysHistoryPage extends PageObject{
	
	@FindBy(css = "li a[href*='menuItem=free-days-history']")
	private WebElementFacade freeDaysHistoryOption;
	
	@FindBy(css = ".filter-content-history")
	private WebElementFacade historyPage;

	public void freeDaysHistoryOptionSelection(){
		freeDaysHistoryOption.click();
	}
	
	public void freeDaysHistoryPageLoad(){
		Assert.assertTrue("Free Days History Page is not Loaded", historyPage.isDisplayed());
	}
	
}
