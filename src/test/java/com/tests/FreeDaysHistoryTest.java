package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.selenium.steps.FreeDaysHistorySteps;
import com.selenium.steps.LoginSteps;
import com.selenium.steps.NavigationSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class FreeDaysHistoryTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	
	@Steps LoginSteps loginSteps;
	@Steps NavigationSteps navigationSteps;
	@Steps FreeDaysHistorySteps freeDaysHistorySteps;
	
	private String username = "attila.marton";
	private String password = "test";
	private String itemtoSearch = "VACATION";
	
	@Test
	public void freeDaysHistoryTest(){
		loginSteps.perform_login(username, password);
		navigationSteps.clickMenuItem(itemtoSearch);
		freeDaysHistorySteps.selectFreeDaysHistoryOption();
		freeDaysHistorySteps.loadFreeDaysHistoryPage();	
	}
}