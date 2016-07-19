package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.selenium.steps.MailListingSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class MailListingTest {
	
	private String host="mail.evozon.com";
	private String username="attila.marton@evozon.com";
	private String password="Shippuuden9.";
	private String storeType="imaps";
//	true = shows read mails; false = shows unread mails
	boolean read=false;
//  tickOption = tick => ticks mails as read
	private String tickOption="tick";
	
	@Steps MailListingSteps mailListingSteps;
	
	@Test
	public void mailListingTest(){
		mailListingSteps.mailListingPage(host, storeType, username, password, read, tickOption);
	}
}