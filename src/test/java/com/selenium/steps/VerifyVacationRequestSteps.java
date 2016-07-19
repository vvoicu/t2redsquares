package com.selenium.steps;

import com.tools.models.Mail;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class VerifyVacationRequestSteps extends ScenarioSteps {

	@Step
	public void verifyMail(String subject) {
		Mail verifyMailRequestPage = new Mail();
		String content = verifyMailRequestPage.veryfyMail(subject);
		printContent(content);
	}

	@Step
	public void printContent(String content) {
		System.out.println("Printed content: " + content);
	}
}
