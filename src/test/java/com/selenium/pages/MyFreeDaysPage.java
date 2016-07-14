package com.selenium.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MyFreeDaysPage extends PageObject {

	@FindBy(css = "a[href*='my-free-days']")
	private WebElementFacade myFreeDaysOption;

	@FindBy(css = "div.active div.date-hired")
	private WebElementFacade dateHired;

	// @FindBy(css="div.active tr:nth-child(2) td:last-child")
	// private WebElementFacade startingBonusDays;
	//
	// @FindBy(css="div.active tr:nth-child(3) td:last-child")
	// private WebElementFacade evozonBonusDays;
	//
	// @FindBy(css="div.active tr:nth-child(5) td:last-child")
	// private WebElementFacade freeDaysLeftFromLastYear;
	//
	// @FindBy(css="div.active tr:nth-child(7) td:last-child")
	// private WebElementFacade freeDaysGivenThisYear;
	//
	@FindBy(css = "div.active tr:nth-child(8) div")
	private WebElementFacade vacationDaysTakenThisYear;
	
	@FindBy(css = "div.active tr:nth-child(9) td:last-child")
	private WebElementFacade totalAvailableFreeDays;

	@FindBy(css = "div.active tr:not(.blank-row)")
	private List<WebElementFacade> daysTypeAndNumberList;
	private String daysTypeCssSelector = "td:nth-child(1)";
	private String daysNumberCssSelector = "td:nth-child(2)";

	@FindBy(css = "div.active table.my-free-days-table")
	private WebElement daysContainer;

	public void selectMyFreeDaysOption() {
		myFreeDaysOption.click();
	}

	public void verifyMyFreeDaysPageIsLoaded() {
		Assert.assertTrue("My free days page is not loaded", dateHired.isDisplayed());
	}

	public Integer getDaysNumber(String daysType) {
		boolean isDaysTypeFound = false;
		for (WebElementFacade daysTypeAndNumberItem : daysTypeAndNumberList) {
			if (daysTypeAndNumberItem.findElement(By.cssSelector(daysTypeCssSelector)).getText().toLowerCase()
					.contentEquals(daysType.toLowerCase())) {
				isDaysTypeFound = true;
				int daysNumber = Integer
						.parseInt(daysTypeAndNumberItem.findElement(By.cssSelector(daysNumberCssSelector)).getText());
				return daysNumber;
			}
		}
		Assert.assertTrue(daysType + " days type was not found", isDaysTypeFound);
		return null;
	}

	public Integer calculateTotalFreeDays() {
		int sum = 0;
		List<WebElement> days = daysContainer
				.findElements(By.cssSelector("div.active table.my-free-days-table tr td:nth-child(2)"));

		for (int i = 0; i <= days.size() - 3; i++) {
			sum = sum + Integer.parseInt(days.get(i).getText());
		}
		System.out.println("suma: " + sum);
		return sum;
	}

	public void verifyDateCalculationDays() {
		int freeDays = calculateTotalFreeDays();
		int vacationDays = Integer.parseInt(vacationDaysTakenThisYear.getText());
		int availableDays = Integer.parseInt(totalAvailableFreeDays.getText());
		System.out.println("available days: "+availableDays+" = free days "+freeDays+"- vacation days "+vacationDays);
		Assert.assertTrue("Available days are not corect calculated", availableDays == freeDays - vacationDays);
	}
}
