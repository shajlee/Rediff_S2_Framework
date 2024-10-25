package com.rediff.S2.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rediff.S2.pages.S2_SignInLinkPage;
import com.rediff.S2.testbase.S2_TestBase;

public class S2_Signin_Link_Test extends S2_TestBase {
	
	public S2_Signin_Link_Test() throws IOException {
		super();
		
	}

	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeTest
	public void setUp() {
		driver = launchBrowserAndInitializeApplication(prop.getProperty("browser1"));
		
	}
	@Test(priority = 1)
	public void signInLinkIsDisplayed() {
		S2_SignInLinkPage signinLink = new S2_SignInLinkPage(driver);
		signinLink.signInLink(); 
		softassert.assertTrue(signinLink.signInLinkIsDisplayed(), "signInLink is not displayed");
		System.out.println("Sign In Link is Displayed");
		softassert.assertAll();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
		
		
		
		
		
	}

}
