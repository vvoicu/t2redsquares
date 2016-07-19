package com.selenium.steps;

import com.selenium.pages.FreeDaysHistoryPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class FreeDaysHistorySteps extends ScenarioSteps {
	private static final long serialVersionUID = 1L;
	
	FreeDaysHistoryPage freeDaysHistoryPage;
	
	@Step
	public void selectFreeDaysHistoryOption(){
		freeDaysHistoryPage.freeDaysHistoryOptionSelection();
	}
	
	@Step
	public void loadFreeDaysHistoryPage(){
		freeDaysHistoryPage.freeDaysHistoryPageLoad();
		
	}
	
	@Step
	public void selectTypeFilterValue(String...filterValues){
		freeDaysHistoryPage.selectTypeFilterValue(filterValues);
	} 
	
	@Step
	public void selectDaysNumberFilterValue(String...filterValues){
		freeDaysHistoryPage.selectTypeFilterValue(filterValues);
	}
	
	@Step
	public void selectStatusFilterValue(String...filterValues){
		freeDaysHistoryPage.selectStatusFilterValue(filterValues);
	} 
	
	@Step
	public void applyFilters(){
		freeDaysHistoryPage.applyFilters();
	}
	
	@Step
	public void selectPaginatorType(String  type){
		freeDaysHistoryPage.selectPaginatorType(type);

	}
	
	@Step
	public void verifyByNumber(String number,int a, int b){
		freeDaysHistoryPage.verifyByNumber(number,a,b);
	}
}
