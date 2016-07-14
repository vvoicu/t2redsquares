package com.selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class MyRequestsPage extends PageObject{

	@FindBy(css = "a[href*='my-requests']")
	private WebElement myRequestsButton;
	
	@FindBy(css = "span[class='aui-field-element aui-field-label-right'] input[id*='VacationsCheckbox']")
	private WebElement futureVacationRadioButton;
	
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
	
	@FindBy(css = "input[class='aui-button-input']")
	private WebElement applyButton;
	
	@FindBy(css = "span[class*='first-link'")
	private WebElement firstpageButton;
	
	@FindBy(css = "span[class*='prev-link'")
	private WebElement previouspageButton;

	@FindBy(css = "span[class*='next-link'")
	private WebElement nextpageButton;
	
	@FindBy(css = "span[class*='last-link'")
	private WebElement lastpageButton;
	
	@FindBy(css=".filter-content div[class='aui-column column-three aui-column-first ']")
	private WebElement vacationTypeContainer;
	private String filterTypeCssSelector="span[class*='aui-field-content']";
	private String filterTypeCheckboxCss="input[type='checkbox']";
	
	public void selectTypeFilterValue(String... filterValues){
		for(String filterValue:filterValues){
			boolean isFilterValueFound=false;
			for(WebElement filterItem: vacationTypeContainer.findElements(By.cssSelector(filterTypeCssSelector))){
				if(filterItem.getText().toLowerCase().contentEquals(filterValue.toLowerCase())){
					isFilterValueFound=true;
					if(!filterItem.findElement(By.cssSelector(filterTypeCheckboxCss)).isSelected()){
						filterItem.findElement(By.cssSelector(filterTypeCheckboxCss)).click();
					}
				}
			}
		Assert.assertTrue(filterValues +"filter option was not found", isFilterValueFound);
		}
	}
	
	@FindBy(css=".filter-content div[class='aui-column column-three column-center ']")
	private WebElement daysNumberContainer; 
	private String filterElementsCssSelector="span[class*='aui-field-content']";
	private String filterCheckboxCssSelector="input[type='checkbox']";
	 
	 
	public void selectDaysNumberFilterValue(String... filterValues){
		for(String filterValue:filterValues){
		boolean isFilterValueFound=false;
		for(WebElement filterItem: daysNumberContainer.findElements(By.cssSelector(filterElementsCssSelector))){
			if(filterItem.getText().toLowerCase().contentEquals(filterValue.toLowerCase())){
				isFilterValueFound=true;
				if(!filterItem.findElement(By.cssSelector(filterCheckboxCssSelector)).isSelected()){
					filterItem.findElement(By.cssSelector(filterCheckboxCssSelector)).click();
				}
				break;
			}
		}
		Assert.assertTrue(filterValues +"filter option was not found", isFilterValueFound);
		}
	}
	
	@FindBy(css=".filter-content div[class='aui-column-content aui-column-content-last column-three-content column-center-content ']")
	private WebElement vacationStatusContainer; 
	private String filterVacationCssSelector="span[class*='aui-field-content']";
	private String filterVacationCheckboxCssSelector="input[type='checkbox']";
	 
	 
	public void vacationStatusFilterValue(String... filterValues){
		for(String filterValue:filterValues){
		boolean isFilterValueFound=false;
		for(WebElement filterItem: vacationStatusContainer.findElements(By.cssSelector(filterVacationCssSelector))){
			if(filterItem.getText().toLowerCase().contentEquals(filterValue.toLowerCase())){
				isFilterValueFound=true;
				if(!filterItem.findElement(By.cssSelector(filterVacationCheckboxCssSelector)).isSelected()){
					filterItem.findElement(By.cssSelector(filterVacationCheckboxCssSelector)).click();
				}
				break;
			}
		}
		Assert.assertTrue(filterValues +"filter option was not found", isFilterValueFound);
		}
	}
	 
	public void loadmyRequests() {
		myRequestsButton.click();
	}
	
	public void clickFutureVacation(){
		futureVacationRadioButton.click();
	}
	
	public void applyFilters(){
		applyButton.click();
	}
}