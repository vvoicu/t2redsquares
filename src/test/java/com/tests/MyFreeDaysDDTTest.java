package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.selenium.steps.LoginSteps;
import com.selenium.steps.MyFreeDaysSteps;
import com.selenium.steps.NavigationSteps;
import com.tools.models.Constants;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.CSV_FILE_PATH + "Test00Paula_MyFreeDays.csv", separator = Constants.CSV_SEPARATOR)
//@UseTestDataFrom(value = "C:\\Users\\paulaklein\\Downloads\\Test00Paula_MyFreeDays.csv")
public class MyFreeDaysDDTTest {

	@Managed(uniqueSession = false)
	public WebDriver webdriver;

	@Steps
	LoginSteps loginSteps;
	@Steps
	NavigationSteps navigationSteps;
	@Steps
	MyFreeDaysSteps myFreeDaysSteps;

	private String username, password, itemtoSearch;

	@Test
	public void myFreeDaysTest() {
		loginSteps.performLogin(username, password);
		navigationSteps.clickMenuItem(itemtoSearch);
		myFreeDaysSteps.selectMyFreeDaysOption();
		// myFreeDaysSteps.verifyMyFreeDaysPageIsLoaded();
		myFreeDaysSteps.calculateTotalAvailableFreeDays();
		myFreeDaysSteps.verifyDateCalculationDays();

	}
}
