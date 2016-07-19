package com.selenium.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class NewVacationRequestPage extends PageObject {

	@FindBy(css = "a[href*='new-request']")
	private WebElement newVacationRequest;

	@FindBy(css = ".Zebra_DatePicker_Icon_Wrapper input[name=startDate]")
	private WebElement selectStartDate;

	@FindBy(css = "div.Zebra_DatePicker[style*='block']")
	private WebElement monthContainer;

	@FindBy(css = ".Zebra_DatePicker_Icon_Wrapper input[name=endDate]")
	private WebElement selectEndDate;
	
	@FindBy(css = "select#_evovacation_WAR_EvoVacationportlet_specialReason")
	private WebElementFacade specialVacationSelector;
	
	@FindBy(css ="span #_evovacation_WAR_EvoVacationportlet_saveButton")
	private WebElement saveButton;

	public void clickNewVacationRequest() {
		newVacationRequest.click();
	}

	public void clickOnStartDate() {
		selectStartDate.click();
	}

	public void clickYear() {
		WebElement datePicker = getDriver().findElement(By.cssSelector("div.Zebra_DatePicker[style*='block']"));
		WebElement year = datePicker.findElement(By.cssSelector("td.dp_caption"));
		year.click();
	}

	public void seletYear(String myYear) {
		boolean isFound = false;
		WebElement datePicker = getDriver().findElement(By.cssSelector("div.Zebra_DatePicker[style*='block']"));
		WebElement clickNext = datePicker.findElement(By.cssSelector("td.dp_next"));
		WebElement year = datePicker.findElement(By.cssSelector("td.dp_caption"));

		if (Integer.parseInt(myYear) < Integer.parseInt(year.getText())) {
			Assert.assertTrue("year not found", isFound);
		}
		while (!year.getText().equals(myYear))
			clickNext.click();
	}

	public void selectMonth(String monthName) {
		boolean isFound = false;
		List<WebElement> monthList = getDriver()
				.findElements(By.cssSelector(".Zebra_DatePicker .dp_monthpicker tr td:not([class*=disabled])"));
		for (WebElement webElement : monthList) {
			if (webElement.getText().equals(monthName)) {
				webElement.click();
				isFound = true;
				break;
			}
		}
		if (!isFound) {
			Assert.assertTrue("Month not found", isFound);
		}
	}

	public void selectDay(String dayName) {
		boolean isFound = false;
		List<WebElement> dayList = getDriver().findElements(
				By.cssSelector(".dp_daypicker[style*=display] td:not([class*=not]):not([class*=disable])"));
		for (WebElement webElement : dayList) {
			if (webElement.getText().equals(dayName)) {
				webElement.click();
				isFound = true;
				break;
			}
		}
		if (!isFound) {
			Assert.assertTrue("Day not found", isFound);
		}
	}

	public void clickOnEndDate() {
		selectEndDate.click();
	}

	public void selectVacationType(String vacationType) {
		List<WebElement> vacationTypeList = getDriver().findElements(By.cssSelector("div .vacationType label"));
		for (WebElement webElement : vacationTypeList)
			if (webElement.getText().contentEquals(vacationType)) {
				webElement.click();
				break;
			}
	}
	
	public void selectSpecial(String special){
		boolean present = specialVacationSelector.isEnabled();
			if(present)
			specialVacationSelector.selectByVisibleText(special);
			
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
		waitABit(5000);
	}
}
