package com.selenium.steps;

import com.selenium.pages.MyRequestsPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MyRequestsSteps extends ScenarioSteps{
	private static final long serialVersionUID = 1L;
	
	MyRequestsPage myRequestsPage;
	
	@Step
	public void clickMyRequests() {
		myRequestsPage.loadmyRequests();
	}
	
	@Step
	public void selectTypeFilterValue(String... filterValues){
		myRequestsPage.selectTypeFilterValue(filterValues);
	}
	
	@Step
	public void selectDaysNumberFilterValue(String... filterValues){
		myRequestsPage.selectDaysNumberFilterValue(filterValues);
	}
	
	@Step
	public void vacationStatusFilterValue(String... filterValues){
		myRequestsPage.vacationStatusFilterValue(filterValues);
	}
	
	@Step
	public void clickFutureVacation(){
		myRequestsPage.clickFutureVacation();
	}
	
	@Step
	public void applyFilters(){
		myRequestsPage.applyFilters();
	}
}
