package com.selenium.steps;

import com.selenium.pages.LoginPage;
import com.selenium.pages.NavigationPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NavigationSteps extends ScenarioSteps {
	private static final long serialVersionUID = 1L;
	NavigationPage navigationPage;
	LoginPage loginPage;
	
	@Step
	public void verify_login() {
		loginPage.verify_login();
	}
	
	@Step
	public void click_menuItem(String itemtoClick) {
		navigationPage.click_header_option(itemtoClick);
	}
}
