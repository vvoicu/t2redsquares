package com.selenium.steps;

import com.tests.SiteHeaderPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SiteHeaderSteps extends ScenarioSteps {
	private static final long serialVersionUID = 1L;
	SiteHeaderPage siteHeaderPage;
	
	@Step
	public void verify_login2() {
		siteHeaderPage.verify_login();
	}
	
	@Step
	public void click_menuItem(String itemtoClick) {
		siteHeaderPage.click_header_option(itemtoClick);
	}
}
