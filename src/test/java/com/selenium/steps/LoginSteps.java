package com.selenium.steps;

import com.selenium.pages.LoginPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	LoginPage loginPage;

	/*@Step
    public void open_login_page() {
        loginPage.open();
    }
	
	@Step
	public void load_signin_page() {
		loginPage.loadSigninPage();
	}

	@Step
	public void enter_username(String username) {
		loginPage.enterUsername(username);
	}

	@Step
	public void enter_password(String password) {
		loginPage.enterPassword(password);
	}

	@Step
	public void click_signin_button() {
		loginPage.clickSigninButton();
	} */
	
	@Step
	public void perform_login(String username, String password){
		loginPage.open();
		loginPage.loadSigninPage();
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickSigninButton();
	}
	
	@Step
	public void verify_login() {
		loginPage.verifyLogin();
	}

}
