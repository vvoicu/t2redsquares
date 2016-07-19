package com.selenium.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class FreeDaysHistoryPage extends PageObject {

	@FindBy(css = "li a[href*='menuItem=free-days-history']")
	private WebElementFacade freeDaysHistoryOption;

	@FindBy(css = ".filter-content-history")
	private WebElementFacade historyPage;

	@FindBy(css = ".filter-content-history div[class*='aui-column-content aui-column-content-first']")
	private WebElement vacationTypeContainer;
	private String filterTypeSelector = "span[class*='aui-field-content']";
	private String filterTypeCheckbox = "input[type='checkbox']";

	@FindBy(css = "div[class*='aui-column-content   column-three-content column-center-content ']")
	private WebElement daysNumberContainer;
	private String filterDaysSelector = "span[class*='aui-field-content']";
	private String filterDayCheckbox = "input[type='checkbox']";

	@FindBy(css = "div[class*='column-three column-center  aui-column-last']")
	private WebElement vacationStatusContainer;
	private String filterStatusSelector = "span[class*='aui-field-content']";
	private String filterStatusCheckbox = "input[type='checkbox']";

	@FindBy(css = "input[type='button'])")
	private WebElementFacade applyButton;

	@FindBy(css = "table.taglib-search-iterator")
	private WebElement tableContainer;

	@FindBy(css = "select[id*='PageIteratorBottom']")
	private WebElementFacade paginatorDropDown;

	public void freeDaysHistoryOptionSelection() {
		freeDaysHistoryOption.click();
	}

	public void freeDaysHistoryPageLoad() {
		Assert.assertTrue("Free Days History Page is not Loaded", historyPage.isDisplayed());
	}

	public void selectTypeFilterValue(String... filterValues) {
		boolean isFilterValueFound = false;
		for (String filterValue : filterValues) {
			for (WebElement filterItem : vacationTypeContainer.findElements(By.cssSelector(filterTypeSelector))) {
				if (filterItem.getText().toLowerCase().contentEquals(filterValue.toLowerCase())) {
					isFilterValueFound = true;
					if (!filterItem.findElement(By.cssSelector(filterTypeCheckbox)).isSelected())
						filterItem.findElement(By.cssSelector(filterTypeCheckbox)).click();
				}
			}
		}
		Assert.assertTrue("Filter Type option was not found", isFilterValueFound);
	}

	public void selectDaysNumberFilterValue(String... filterValues) {
		boolean isFilterValueFound = false;
		for (String filterValue : filterValues) {
			for (WebElement filterItem : daysNumberContainer.findElements(By.cssSelector(filterDaysSelector))) {
				if (filterItem.getText().toLowerCase().contentEquals(filterValue.toLowerCase())) {
					isFilterValueFound = true;
					if (!filterItem.findElement(By.cssSelector(filterDayCheckbox)).isSelected()) {
						filterItem.findElement(By.cssSelector(filterDayCheckbox)).click();
					}
				}
			}
		}
		Assert.assertTrue("Filter Days option was not found", isFilterValueFound);
	}

	public void selectStatusFilterValue(String... filterValues) {
		boolean isFilterValueFound = false;
		for (String filterValue : filterValues) {
			for (WebElement filterItem : vacationStatusContainer.findElements(By.cssSelector(filterStatusSelector))) {
				if (filterItem.getText().toLowerCase().contentEquals(filterValue.toLowerCase())) {
					isFilterValueFound = true;
					if (!filterItem.findElement(By.cssSelector(filterStatusCheckbox)).isSelected()) {
						filterItem.findElement(By.cssSelector(filterStatusCheckbox)).click();
					}
				}
			}
		}
		Assert.assertTrue("Filter Status option was not found", isFilterValueFound);
	}

	public void applyFilters() {
		applyButton.click();
	}

	public void verifyByNumber(String number, int a, int b){
		boolean found=true;
		List<WebElement> elements = tableContainer.findElements(By.cssSelector("td[class*='align-left col-3']"));
		for(WebElement webElement:elements){
			if (!(Integer.parseInt(webElement.getText())>=a) || !(Integer.parseInt(webElement.getText())<=b)){
				found=false;
				System.out.println("aaa: "+webElement.getText());
			}
			}
		Assert.assertTrue("Vacation days are not displayed correctly", found);
		}

	public void selectPaginatorType(String type) {
		paginatorDropDown.waitUntilVisible();
		paginatorDropDown.selectByVisibleText(type);

	}
}
