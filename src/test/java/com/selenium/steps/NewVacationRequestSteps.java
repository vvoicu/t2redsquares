package com.selenium.steps;

import com.selenium.pages.NewVacationRequestPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

public class NewVacationRequestSteps extends ScenarioSteps {
	private static final long serialVersionUID = 1L;
	NewVacationRequestPage newVacationRequestPage;
	
	@Step
	public void clickOnNewVacationRequest(){
		newVacationRequestPage.clickNewVacationRequest();
	}	
	
	@Step
	public void clickOnStartDate(){
		newVacationRequestPage.clickOnStartDate();
	}
	@Step
	public void clickYear(){
		newVacationRequestPage.clickYear();
	}
	@Step
	public void seletYear(String myYear){
		newVacationRequestPage.seletYear(myYear);
	}
	@Step
	public void selectMonth(String monthName){
		newVacationRequestPage.selectMonth(monthName);
	}
	
	@Step
	public void selectDay(String dayName){
		newVacationRequestPage.selectDay(dayName);
	}
	@Step
	public void clickOnEndDate(){
		newVacationRequestPage.clickOnEndDate();
	}
	
	@StepGroup
	public void selectDate(String myYear, String myMonth, String myDay){
		clickYear();
		seletYear(myYear);
		selectMonth(myMonth);
		selectDay(myDay);	
	}
	@Step
	public void selectVacationType(String vacationType){
		newVacationRequestPage.selectVacationType(vacationType);
	}
	@Step
	public void selectSpecial(String option){
		newVacationRequestPage.selectSpecial(option);
	}
	
   public void clickOnSaveButton(){
	   newVacationRequestPage.clickOnSaveButton();
   }
}
