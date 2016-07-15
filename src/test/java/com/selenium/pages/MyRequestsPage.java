package com.selenium.pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tools.models.SearchItemModel;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class MyRequestsPage extends PageObject {

	@FindBy(css = "a[href*='my-requests']")
	private WebElement myRequestsButton;

	@FindBy(css = "span[class='aui-field-element aui-field-label-right'] input[id*='VacationsCheckbox']")
	private WebElement futureVacationRadioButton;

	@FindBy(css = "input[class='aui-button-input']")
	private WebElement applyButton;

	public void loadmyRequests() {
		myRequestsButton.click();
	}

	@FindBy(css = ".filter-content div[class='aui-column column-three aui-column-first ']")
	private WebElement vacationTypeContainer;
	private String filterTypeCssSelector = "span[class*='aui-field-content']";
	private String filterTypeCheckboxCss = "input[type='checkbox']";

	public void selectTypeFilterValue(String... filterValues) {
		for (String filterValue : filterValues) {
			boolean isFilterValueFound = false;
			for (WebElement filterItem : vacationTypeContainer.findElements(By.cssSelector(filterTypeCssSelector))) {
				if (filterItem.getText().toLowerCase().contentEquals(filterValue.toLowerCase())) {
					isFilterValueFound = true;
					if (!filterItem.findElement(By.cssSelector(filterTypeCheckboxCss)).isSelected()) {
						filterItem.findElement(By.cssSelector(filterTypeCheckboxCss)).click();
					}
				}
			}
			Assert.assertTrue(filterValues + "filter option was not found", isFilterValueFound);
		}
	}

	@FindBy(css = ".filter-content div[class='aui-column column-three column-center ']")
	private WebElement daysNumberContainer;
	private String filterElementsCssSelector = "span[class*='aui-field-content']";
	private String filterCheckboxCssSelector = "input[type='checkbox']";

	public void selectDaysNumberFilterValue(String... filterValues) {
		for (String filterValue : filterValues) {
			boolean isFilterValueFound = false;
			for (WebElement filterItem : daysNumberContainer.findElements(By.cssSelector(filterElementsCssSelector))) {
				if (filterItem.getText().toLowerCase().contentEquals(filterValue.toLowerCase())) {
					isFilterValueFound = true;
					if (!filterItem.findElement(By.cssSelector(filterCheckboxCssSelector)).isSelected()) {
						filterItem.findElement(By.cssSelector(filterCheckboxCssSelector)).click();
					}
					break;
				}
			}
			Assert.assertTrue(filterValues + "filter option was not found", isFilterValueFound);
		}
	}

	@FindBy(css = ".filter-content div[class='aui-column-content aui-column-content-last column-three-content column-center-content ']")
	private WebElement vacationStatusContainer;
	private String filterVacationCssSelector = "span[class*='aui-field-content']";
	private String filterVacationCheckboxCssSelector = "input[type='checkbox']";

	public void vacationStatusFilterValue(String... filterValues) {
		for (String filterValue : filterValues) {
			boolean isFilterValueFound = false;
			for (WebElement filterItem : vacationStatusContainer
					.findElements(By.cssSelector(filterVacationCssSelector))) {
				if (filterItem.getText().toLowerCase().contentEquals(filterValue.toLowerCase())) {
					isFilterValueFound = true;
					if (!filterItem.findElement(By.cssSelector(filterVacationCheckboxCssSelector)).isSelected()) {
						filterItem.findElement(By.cssSelector(filterVacationCheckboxCssSelector)).click();
					}
					break;
				}
			}
			Assert.assertTrue(filterValues + "filter option was not found", isFilterValueFound);
		}
	}

	public void clickFutureVacation() {
		futureVacationRadioButton.click();
	}

	public void applyFilters() {
		applyButton.click();
	}

	@FindBy(css = "table[class='taglib-search-iterator'] tr[class='portlet-section-header results-header']")
	private WebElement tableContainer;

	@FindBy(css = "table[class='taglib-search-iterator'] tr[class='portlet-section-header results-header'] th")
	private List<WebElement> tableHeaderItems;

	public void vacationTableFilterValue(String filterValue, String sortingMode) {
		element(tableContainer).waitUntilVisible();
		for (WebElement element : tableHeaderItems) {
			if (element.getText().contentEquals(filterValue)) {
				String elementState = element.getAttribute("class");
				if (elementState.contains("asc") || elementState.contains("desc")) {
					if (elementState.contains("asc") && sortingMode == "desc") {
						clickOnHeaderElement(filterValue);
						break;
					} else {
						if ((elementState.contains("desc") && sortingMode == "asc")) {
							clickOnHeaderElement(filterValue);
							break;
						}
					}
				} else {
					if (sortingMode == "desc") {
						clickOnHeaderElement(filterValue);
						break;
					} else {
						clickOnHeaderElement(filterValue);
						clickOnHeaderElement(filterValue);
					}
				}
			}
			break;
		}
	}
	
	@FindBy(css = "div[class='page-links'] a[class*='first']")
	public WebElement firstPageButton;

	@FindBy(css = "div[class='page-links'] a[class*='prev']")
	public WebElement previousPageButton;

	@FindBy(css = "div[class='page-links'] a[class*='next']")
	public WebElement nextPageButton;

	@FindBy(css = "div[class='page-links'] a[class*='last']")
	public WebElement lastPageButton;
		
	@FindBy(css = ".portlet-section-header")
	public WebElement headerContainer;
	
	@FindBy(css = ".taglib-search-iterator")
	public WebElement requestListContainer;
	
	
	public void clickOnHeaderElement(String label){
		List<WebElement> headerColumnsList = headerContainer.findElements(By.cssSelector("a"));
		theFor:
		for (WebElement webElement : headerColumnsList) {
			if(webElement.getText().contains(label)){
				webElement.click();
				break theFor;
			}
		}
	}
	
	public List<SearchItemModel> grabRequestList(){
		List<SearchItemModel> resultsList = new ArrayList<SearchItemModel>();
		
		List<WebElement> requestItemsList = requestListContainer.findElements(By.cssSelector("tr.results-row:not(.lfr-template)"));
		
		for (WebElement elementNow : requestItemsList) {
			SearchItemModel itemNow = new SearchItemModel();
			
			String startDate = elementNow.findElement(By.cssSelector("td[id*='start.date']")).getText();
			String endDate = elementNow.findElement(By.cssSelector("td[id*='end.date']")).getText();
			String daysNumber = elementNow.findElement(By.cssSelector("td[id*='day.number']")).getText();
			String type = elementNow.findElement(By.cssSelector("td[id*='header.type']")).getText();
			String lastUpdatedBy = elementNow.findElement(By.cssSelector("td[id*='last.update']")).getText();
			String status = elementNow.findElement(By.cssSelector("td[id*='header.status']")).getText();

			itemNow.setStartDate(startDate);
			itemNow.setEndDate(endDate);
			itemNow.setNumberOfDays(daysNumber);
			itemNow.setType(type);
			itemNow.setLastUpdatedBy(lastUpdatedBy);
			itemNow.setStatus(status);
			resultsList.add(itemNow);
		}
		return resultsList;
	}	
	
	public void clickOnFirstPageButton(){
		firstPageButton.click();
	}
	
	public void clickOnPreviousPageButton(){
		previousPageButton.click();
	}
	public void clickOnNextPageButton(){
		nextPageButton.click();
	}
	public void clickOnLastPageButton(){
		lastPageButton.click();
	}
}