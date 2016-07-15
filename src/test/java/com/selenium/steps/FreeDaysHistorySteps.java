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
}
