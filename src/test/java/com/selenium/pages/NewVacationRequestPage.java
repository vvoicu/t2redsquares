package com.selenium.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class NewVacationRequestPage extends PageObject{
	
	@FindBy (css = "a[href*='new-request']")
	private WebElement newVacationRequest;
	
	@FindBy (css= ".Zebra_DatePicker_Icon_Wrapper input[name=startDate]")
	private WebElement selectStartDate;
	
	@FindBy (css = "div.Zebra_DatePicker[style*='block']")
	private WebElement monthContainer;
	
	@FindBy (css= ".Zebra_DatePicker_Icon_Wrapper input[name=endDate]")
	private WebElement selectEndDate;
	
	
	public void clickNewVacationRequest(){
		newVacationRequest.click();
	}
	
	public void clickOnStartDate(){
		selectStartDate.click();	
	}
	
	public void clickYear(){
		WebElement datePicker = getDriver().findElement(By.cssSelector("div.Zebra_DatePicker[style*='block']"));
		WebElement year = datePicker.findElement(By.cssSelector("td.dp_caption"));
		year.click();
	}
	
	public void seletYear(String myYear){
		WebElement datePicker = getDriver().findElement(By.cssSelector("div.Zebra_DatePicker[style*='block']"));
		WebElement clickNext = datePicker.findElement(By.cssSelector("td.dp_next"));
		WebElement year = datePicker.findElement(By.cssSelector("td.dp_caption"));
		while(!year.getText().equals(myYear))
			clickNext.click();	
	}
	
	public void selectMonth(String monthName){
		List<WebElement> monthList = getDriver().findElements(By.cssSelector(".Zebra_DatePicker .dp_monthpicker tr td:not([class*=disabled])"));
		for (WebElement webElement : monthList) {
			if(webElement.getText().equals(monthName)){
				webElement.click();
				break;
			}
		}
	}
	
	public void selectDay(String dayName){
		List<WebElement> dayList = getDriver().findElements(By.cssSelector(".dp_daypicker[style*=display] td:not([class*=not]):not([class*=disable])"));
		for (WebElement webElement : dayList) {
			if(webElement.getText().equals(dayName)){
				webElement.click();
				break;
			}
		}
	}
	
	public void clickOnEndDate(){
	selectEndDate.click();	
	}
	

}
