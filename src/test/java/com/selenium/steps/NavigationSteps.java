package com.selenium.steps;

import com.selenium.pages.NavigationPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NavigationSteps extends ScenarioSteps {
	private static final long serialVersionUID = 1L;
	NavigationPage navigationPage;
	
	@Step
	public void clickMenuItem(String itemtoClick) {
		navigationPage.clickHeaderOption(itemtoClick);
	}
}
