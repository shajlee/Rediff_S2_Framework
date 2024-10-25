package com.rediff.S2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class S2_SignInLinkPage {
	public WebDriver driver;
	
	@FindBy(css = "a.signin")
	private WebElement signInLink;
	
	public S2_SignInLinkPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement signInLink() {
	return signInLink;
	}
	public boolean signInLinkIsDisplayed() {
		boolean displayStatus = signInLink.isDisplayed();
		return displayStatus;
		
	}
	
		
	}
	
	


