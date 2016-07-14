package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.selenium.steps.LoginSteps;
import com.selenium.steps.MyRequestsSteps;
import com.selenium.steps.NavigationSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class MyRequestsTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	
	@Steps LoginSteps loginSteps;
	@Steps NavigationSteps navigationSteps;
	@Steps MyRequestsSteps myRequestsSteps;
	
	private String itemtoClick = "VACATION";
	private String username = "attila.marton";
	private String password = "test";
	
//	@Test
//	public void myrequestTest() {
//		loginSteps.perform_login(username, password);
//		navigationSteps.click_menuItem(itemtoClick);
//		myrequestsSteps.click_myrequests();
//	}
	
	@Test
	public void myRequestHolidayTest() {
		loginSteps.perform_login(username, password);
		navigationSteps.clickMenuItem(itemtoClick);
		myRequestsSteps.clickMyRequests();
		// "Holiday", "Vacation without payment", "special vacation", "sick leave", "maternity leave"
//		myRequestsSteps.selectTypeFilterValue("Holiday", "maternity leave");
		// "1 - 5", "6 - 10", "11 - 20", "21 - 50", "51 +"
//		myRequestsSteps.selectDaysNumberFilterValue("1 - 5", "21 - 50");
		// "Pending", "Approved", "Rejected", "Withdrawn", "Cancelled"
//		myRequestsSteps.vacationStatusFilterValue("Pending", "Approved", "Rejected", "Withdrawn", "Cancelled");
		myRequestsSteps.clickFutureVacation();
		myRequestsSteps.applyFilters();
	}
}
