package com.selenium.steps;

import com.selenium.pages.LoginPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	LoginPage loginPage;

	@Step
	public void first_click() {
		loginPage.details_show();
	}

	@Step
	public void insert_name(String nume) {
		loginPage.logare_nume(nume);
	}

	@Step
	public void insert_pass(String parola) {
		loginPage.logare_pass(parola);
	}

	@Step
	public void lets_go() {
		loginPage.click_signin();
	}

	@Step
	public void is_the_home_page() {
		loginPage.open();
	}

}
