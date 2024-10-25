package com.rediff.S2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class S2_InboxPage {
	public WebDriver driver;
	
	@FindBy(className = "signin")
	private WebElement signinLink;
	
	@FindBy(xpath = "//input[@id='login1']")
	private WebElement usernameTextBox;
	
	@FindBy(xpath = "//input[contains(@id, 'password')]")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//input[@class='signinbtn']")
	private WebElement signinButton;
	
	@FindBy(xpath = "//a[@class='rd_active']")
	private WebElement inboxButton;
	
	@FindBy(xpath = "//cite[@class='rd_usr_log']/child::a")
	private WebElement userName;
	
	public S2_InboxPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnSignInLink() {
		signinLink.click();
	}
	public void enterUsername(String usernameText) {
		usernameTextBox.sendKeys(usernameText);
	}
	public void enterPassword(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	public void clickOnSigninButton() {
		signinButton.click();
	}
	public WebElement inboxButton() {
		return inboxButton;
	}
	public boolean inboxButtonDisplay() {
		boolean displayStatus = inboxButton.isDisplayed();
		return displayStatus;
	}
	public WebElement username() {
		return userName;
	}
	public boolean usernameIsDisplayed() {
		boolean displayStatus = userName.isDisplayed();
		return displayStatus;
		
	}
	

}
