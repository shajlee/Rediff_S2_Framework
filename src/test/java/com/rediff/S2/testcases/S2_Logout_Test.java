package com.rediff.S2.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rediff.S2.pages.S2_LogoutPage;
import com.rediff.S2.testbase.S2_TestBase;

public class S2_Logout_Test extends S2_TestBase {
	
	public S2_Logout_Test() throws IOException {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = launchBrowserAndInitializeApplication(prop.getProperty("browser1"));
		S2_LogoutPage logOut = new S2_LogoutPage(driver);
		logOut.clickOnSignInLink();
		logOut.enterUsername(prop.getProperty("validUsername"));
		logOut.enterPassword(prop.getProperty("validPassword"));
		logOut.clickSigninButton();
		
	}
	@Test
	public void logOut() {
		S2_LogoutPage logOut = new S2_LogoutPage(driver);
		logOut.clicklogoutButton();
		logOut.logoutMessage(); 
		softassert.assertTrue(logOut.logoutMessageIsDisplayed(), "logOutMessage is not displayed");
		System.out.println("Logout is functional");
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		

}
}

