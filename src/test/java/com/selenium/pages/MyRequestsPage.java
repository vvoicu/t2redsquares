package com.selenium.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class MyRequestsPage extends PageObject{

	@FindBy(css = "a[href*='my-requests']")
	private WebElement myrequestsButton;
	
	@FindBy(css = "input[id*='vacationTypeALL']")
	private WebElement vacationtypeallRadioButton;
	
	@FindBy(css = "input[id*='HOLIDAYCheckbox']")
	private WebElement holidayRadioButton;
	
	@FindBy(css = "input[id*='WITHOUT_PAYMENTCheckbox']")
	private WebElement vacationwithoutpaymentRadioButton;
	
	@FindBy(css = "input[id*='SPECIAL']")
	private WebElement specialvacationRadioButton;
	
	@FindBy(css = "input[id*='SICK']")
	private WebElement sickleaveRadioButton;
	
	@FindBy(css = "input[value*='MATERNITY']")
	private WebElement maternityRadioButton;

	@FindBy(css = "input[id*='daysNumberALL']")
	private WebElement daysnumberallRadioButton;
	
	@FindBy(css = "input[id*='TENTH']")
	private WebElement onefiveRadioButton;
	
	@FindBy(css = "input[id*='TENTH']")
	private WebElement sixtenRadioButton;
	
	@FindBy(css = "input[id*='TWENTIETH']")
	private WebElement eleventwentyRadioButton;
	
	@FindBy(css = "input[id*='FIFTIETH']")
	private WebElement fiftyRadioButton;
	
	@FindBy(css = "input[id*='REST']")
	private WebElement fiftyplusRadioButton;
	
	@FindBy(css = "input[id*='vacationStatusALL']")
	private WebElement vacationstatusallRadioButton;

	@FindBy(css = "input[value*='PENDING']")
	private WebElement pendingRadioButton;
	
	@FindBy(css = "input[value*='APPROVED']")
	private WebElement approvedRadioButton;
	
	@FindBy(css = "input[value*='REJECTED']")
	private WebElement rejectedRadioButton;
	
	@FindBy(css = "input[value*='WITHDRAWN']")
	private WebElement withdrawnRadioButton;
	
	@FindBy(css = "input[value*='CANCELLED']")
	private WebElement cancelledRadioButton;
	
	@FindBy(css = "input[id*='futureVacation']")
	private WebElement futurevacationRadioButton;
	
	@FindBy(css = "a[href*='startDate'")
	private WebElement startdateButton;
	
	@FindBy(css = "a[href*='endDate'")
	private WebElement enddateButton;
	
	@FindBy(css = "a[href*='daysNr'")
	private WebElement daysnrButton;
	
	@FindBy(css = "a[href*='type'")
	private WebElement typeButton;
	
	@FindBy(css = "a[href*='lastUpdate'")
	private WebElement lastupdateButton;
	
	
	@FindBy(css = "a[href*='status'")
	private WebElement statusButton;
	
	@FindBy(css = "input[value*='Apply'")
	private WebElement applyButton;
	
	@FindBy(css = "span[class*='first-link'")
	private WebElement firstpageButton;
	
	@FindBy(css = "span[class*='prev-link'")
	private WebElement previouspageButton;

	@FindBy(css = "span[class*='next-link'")
	private WebElement nextpageButton;
	
	@FindBy(css = "span[class*='last-link'")
	private WebElement lastpageButton;
	
	public void loadmyRequests() {
		myrequestsButton.click();
	}
	
	public void loadHolidays() {
		vacationwithoutpaymentRadioButton.click();
		applyButton.click();
	}
}