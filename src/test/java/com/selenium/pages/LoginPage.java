package com.selenium.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://172.22.4.88:9090/home")
public class LoginPage extends PageObject{

	@FindBy(css="a[href*='login']")
	private WebElementFacade signinEvoportal;
	
	public void details_show() {
		signinEvoportal.click();
	}
	
	@FindBy(css="input[id*='login']")
	private WebElementFacade userEvoportal;
	
	@FindBy(css="input[id*='password']")
	private WebElementFacade passEvoportal;	
	
	public void logare_nume(String userName) {
		userEvoportal.type(userName);
	}
	
	public void logare_pass(String passWord) {
		passEvoportal.type(passWord);
	}
	
	@FindBy(css = "input[value='Sign In']")
	private WebElementFacade signinEvoportal2;
	
	public void click_signin() {
		signinEvoportal2.click();
	}
}
