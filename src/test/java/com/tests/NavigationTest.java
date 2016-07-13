package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.selenium.steps.NavigationSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class NavigationTest {
	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;
		
	@Steps NavigationSteps navigationSteps;
	@Steps LoginTest loginTest;
	
	private String itemtoSearch = "BENEFITS";
	
	@Test
	public void navigation(){
		loginTest.logging_in();
		navigationSteps.click_menuItem(itemtoSearch);
	}
}
