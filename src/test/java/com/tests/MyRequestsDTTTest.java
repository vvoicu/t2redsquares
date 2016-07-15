package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.selenium.steps.LoginSteps;
import com.selenium.steps.MyRequestsSteps;
import com.selenium.steps.NavigationSteps;

import junit.framework.TestCase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom (value = "src/test/resources/tests/csv/Test01_MyRequests.csv",separator=',')
public class MyRequestsDTTTest extends TestCase {

	@Managed(uniqueSession = false)
	public WebDriver webdriver;
	
	@Steps LoginSteps loginSteps;
	@Steps NavigationSteps navigationSteps;
	@Steps MyRequestsSteps myRequestsSteps;
	
	private String username, password, typeFilter, daysFilter, statusFilter;
	
	@Test
	@Title ("Test01 - MyRequests")
	public void myRequestHolidayTest() {
		loginSteps.perform_login(username, password);
		navigationSteps.clickMenuItem("VACATION");
		myRequestsSteps.clickMyRequests();
// 		"Holiday", "Vacation without payment", "special vacation", "sick leave", "maternity leave"
		myRequestsSteps.selectTypeFilterValue(typeFilter);
// 		"1 - 5", "6 - 10", "11 - 20", "21 - 50", "51 +"
		myRequestsSteps.selectDaysNumberFilterValue(daysFilter);
// 		"Pending", "Approved", "Rejected", "Withdrawn", "Cancelled"
		myRequestsSteps.vacationStatusFilterValue(statusFilter);
		myRequestsSteps.applyFilters();
	}
}
