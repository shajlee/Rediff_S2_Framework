package com.rediff.S2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class S2_Rediff_HomePage {
	public WebDriver driver;
	
	@FindBy(className = "signin")
	private WebElement signinLink;
	
	@FindBy(xpath = "//input[@id='login1']")
	private WebElement usernameTextBox;
	
	@FindBy(xpath = "//input[contains(@id, 'password')]")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//input[@class='signinbtn']")
	private WebElement signoutButton;
	
	@FindBy(xpath = "//a[@class = 'rd_logout']")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//b[text()='Rediff Home']")
	private WebElement rediffHomeButton;
	
	@FindBy(css = "span.hmsprite.logo")
	private WebElement rediffLogo;
	
	public S2_Rediff_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnSigninLink() {
		signinLink.click();
	}
	public void enterUsername(String usernameText) {
		usernameTextBox.sendKeys(usernameText);
	}
	public void enterPassword(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	public void clickOnSigninButton() {
		signoutButton.click();
	}
	public void clickOnLogoutButton() {
		logoutButton.click();
	}
	public void clickOnRediffHomeButton() {
		rediffHomeButton.click();
	}
	public WebElement rediffLogo() {
		return rediffLogo;
	}
	public boolean rediffLogoIsDisplayed() {
		boolean displayStatus = rediffLogo.isDisplayed();
		return displayStatus;
		
		
		
		
	}
	
	
	

}
