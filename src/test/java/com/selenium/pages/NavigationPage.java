package com.selenium.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class NavigationPage extends PageObject {

	@FindBy(css = "ul.main-menu")
	private WebElement menuHeaderContainer;
	
	@FindBy(css = "ul.main-menu li")
	private List<WebElement> menuHeaderItems;

	public void clickHeaderOption(String menuItem) {
		element(menuHeaderContainer).waitUntilVisible();
		for (WebElement element : menuHeaderItems) {
			if (element.getText().contentEquals(menuItem)){
				element.click();
				break;
			}
			}
		}
}
