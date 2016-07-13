package com.tests;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class SiteHeaderPage extends PageObject{

	@FindBy(css = "li[id*='userAvatar']")
	private WebElement userAvatar;

	public void verify_login(){
		try{
		Assert.assertTrue(userAvatar.isDisplayed());
		}
		catch(Exception e){
			Assert.fail("Login failed!");
		}
	}

	@FindBy(css="a[href*='vacation']")
	private WebElement vacationButton;
	
	public void click_vacation_button() {
		vacationButton.click();
	}
}
