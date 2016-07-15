package com.selenium.steps;

import java.util.List;

import com.selenium.pages.MyRequestsPage;
import com.tools.models.SearchItemModel;

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
	
	@Step
	public void vacationTableFilterValue(String filterValue, String sortingMode){
		myRequestsPage.vacationTableFilterValue(filterValue, sortingMode);
	}
	
	
	@Step
	public void clickOnHeader(String label){
		myRequestsPage.clickOnHeaderElement(label);
	}
	
	@Step
	public List<SearchItemModel> grabRequestList(){
		return myRequestsPage.grabRequestList();
	}
	
	@Step 
	public void clickOnFirstPage(){
		myRequestsPage.clickOnFirstPageButton();
	}
	
	@Step 
	public void clickOnPreviousPage(){
		myRequestsPage.clickOnPreviousPageButton();
	}
	
	@Step 
	public void clickOnNextPage(){
		myRequestsPage.clickOnNextPageButton();
	}
	
	@Step 
	public void clickOnLastPage(){
		myRequestsPage.clickOnLastPageButton();
	}
}
