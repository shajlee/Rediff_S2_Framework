package com.rediff.S2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class S2_LoginPage {
	public WebDriver driver;
	
	@FindBy(className = "signin")
	private WebElement signinLink;
	
	@FindBy(xpath = "//input[@id='login1']")
	private WebElement usernameTextBox;
	
	@FindBy(xpath = "//input[contains(@id, 'password')]")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//input[@class='signinbtn']")
	private WebElement signinButton;
	
	@FindBy(xpath = "//cite[@class='rd_usr_log']/child::a")
	private WebElement userName;
	
	@FindBy(xpath = "//div[@class='div_login_error']/child::b")
	private WebElement invalidCredentialsMessage;
	
	public S2_LoginPage(WebDriver driver) {
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
	public WebElement userName() {
		return userName;
	}
	public boolean usernameIsDisplayed() {
		boolean displayStatus = userName.isDisplayed();
		return displayStatus;
	}
	public WebElement invalidCredentials() {
		return invalidCredentialsMessage;
	}
	public boolean invalidCredentialsMessageIsDisplayed() {
		boolean displayStatus = invalidCredentialsMessage.isDisplayed();
		return displayStatus;
		
		
	}
	
	

}
