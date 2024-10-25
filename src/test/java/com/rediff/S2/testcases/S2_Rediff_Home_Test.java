package com.rediff.S2.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rediff.S2.pages.S2_Rediff_HomePage;
import com.rediff.S2.testbase.S2_TestBase;

public class S2_Rediff_Home_Test extends S2_TestBase {
	
	public S2_Rediff_Home_Test() throws IOException {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() { 
		driver = launchBrowserAndInitializeApplication(prop.getProperty("browser1"));
		S2_Rediff_HomePage homePage = new S2_Rediff_HomePage(driver);
		homePage.clickOnSigninLink();
		homePage.enterUsername(prop.getProperty("validUsername"));
		homePage.enterPassword(prop.getProperty("validPassword"));
		homePage.clickOnSigninButton();
		
		
	}
	@Test
	public void rediffHome() {
		S2_Rediff_HomePage homePage = new S2_Rediff_HomePage(driver);
		homePage.clickOnLogoutButton();
		homePage.clickOnRediffHomeButton();
		homePage.rediffLogo(); 
		softassert.assertTrue(homePage.rediffLogoIsDisplayed(), "rediffLogo is not displayed");
		System.out.println("Rediff home is functional");
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();

}
}
