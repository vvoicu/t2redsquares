package com.selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://172.22.4.88:9090/home")
public class LoginPage extends PageObject{

	@FindBy(css="#sign-in")
	private WebElementFacade signinPageLoad;
	
	@FindBy(css="input[id*='login']")
	private WebElementFacade usernameInput;
	
	@FindBy(css="input[id*='password']")
	private WebElementFacade passwordInput;	
	
	@FindBy(css = "input[value='Sign In']")
	private WebElementFacade signinButton;

	@FindBy(css = "li[id*='userAvatar']")
	private WebElement userAvatar;
	
	public void loadSigninPage() {
		signinPageLoad.click();
	}
	
	public void enterUsername(String username) {
		usernameInput.type(username);
	}
	
	public void enterPassword(String password) {
		passwordInput.type(password);
	}
	
	public void clickSigninButton() {
		signinButton.click();
	}
	
	public void verifyLogin() {
		try {
			Assert.assertTrue(userAvatar.isDisplayed());
		} catch (Exception e) {
			Assert.fail("Login failed!");
		}
	}
}
