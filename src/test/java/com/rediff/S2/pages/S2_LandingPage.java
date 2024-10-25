package com.rediff.S2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class S2_LandingPage {
	
	public WebDriver driver;
	
	@FindBy(className = "signin")
	private WebElement signinButton;
	
	@FindBy(css = "span.hmsprite.logo")
	private WebElement rediffLogo;
	
	public S2_LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement signInButton() {
		return signinButton;
	}
	public WebElement rediffLogo() {
		return rediffLogo;
	}
	public boolean signinButtonIsDisplayed() {
		boolean displayStatus = signinButton.isDisplayed();
		return displayStatus;
	}
	public boolean rediffLogoIsDisplayed() {
		boolean displayStatus = rediffLogo.isDisplayed();
		return displayStatus;
		
	}
	
	

}
