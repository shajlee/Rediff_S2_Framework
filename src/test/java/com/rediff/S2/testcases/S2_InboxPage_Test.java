package com.rediff.S2.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rediff.S2.pages.S2_InboxPage;
import com.rediff.S2.testbase.S2_TestBase;

public class S2_InboxPage_Test extends S2_TestBase {
	
	public S2_InboxPage_Test() throws IOException {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = launchBrowserAndInitializeApplication(prop.getProperty("browser1"));
		S2_InboxPage inboxPage = new S2_InboxPage(driver);
		inboxPage.clickOnSignInLink();
		inboxPage.enterUsername(prop.getProperty("validUsername"));
		inboxPage.enterPassword(prop.getProperty("validPassword"));
		inboxPage.clickOnSigninButton();
		
	}
	@Test
	public void presenceOfInboxButton() {
		S2_InboxPage inboxPage = new S2_InboxPage(driver);
		inboxPage.inboxButton(); 
		softassert.assertTrue(inboxPage.inboxButtonDisplay(), "inboxButton is not displayed");
		softassert.assertAll();
	}
	@Test
	public void presenceOfUserName() {
		S2_InboxPage inboxPage = new S2_InboxPage(driver);
		inboxPage.username(); 
		softassert.assertTrue(inboxPage.usernameIsDisplayed(), "userName is not displayed");
		System.out.println("Rediff Inbox page is functional");
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
		
		
		


		
	}
	
	

}
