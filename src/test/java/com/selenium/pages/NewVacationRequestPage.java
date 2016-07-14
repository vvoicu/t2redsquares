package com.selenium.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class NewVacationRequestPage extends PageObject{
	
	@FindBy (css = "a[href*='new-request']")
	private WebElement newVacationRequest;
	
	public void clickNewVacationRequest(){
		newVacationRequest.click();
	}
	
	

}
