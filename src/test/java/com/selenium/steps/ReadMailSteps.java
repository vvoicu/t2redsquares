package com.selenium.steps;

import com.tools.models.ReadMail;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ReadMailSteps extends ScenarioSteps{
	private static final long serialVersionUID = 1L;
	
	ReadMail readMail;
	
	@Step
	public void getUnreadMails(String host, String username, String password){
		readMail = new ReadMail();
		readMail.checkMail(host, username, password);
	}
	
}
   
   

