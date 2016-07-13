package com.tests;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class SiteHeaderPage extends PageObject {

	@FindBy(css = "li[id*='userAvatar']")
	private WebElement userAvatar;

	@FindBy(css = "ul.main-menu")
	private WebElement menuHeaderContainer;
	
	@FindBy(css = "ul.main-menu li")
	private List<WebElement> menuHeaderItems;
	
	public void verify_login() {
		try {
			Assert.assertTrue(userAvatar.isDisplayed());
		} catch (Exception e) {
			Assert.fail("Login failed!");
		}
	}

	public void click_header_option(String menuItem) {
		element(menuHeaderContainer).waitUntilVisible();
		for (WebElement element : menuHeaderItems) {
			if (element.getText().contentEquals(menuItem)){
				element.click();
				break;
			}
			}
		}
}
