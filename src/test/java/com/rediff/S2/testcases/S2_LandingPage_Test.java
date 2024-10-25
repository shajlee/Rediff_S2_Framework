package com.rediff.S2.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rediff.S2.pages.S2_LandingPage;
import com.rediff.S2.testbase.S2_TestBase;

public class S2_LandingPage_Test extends S2_TestBase {
	
	public S2_LandingPage_Test() throws IOException {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = launchBrowserAndInitializeApplication(prop.getProperty("browser1"));
		
	}
	@Test(priority=1)
	public void validatePageTitleAndCurrentUrl() {
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		String actualPageTitle = prop.getProperty("actualPageTitle");
		String expectedPageTitle = driver.getTitle();
		
		String actualPageUrl = prop.getProperty("actualPageUrl");
		String expectedPageUrl = driver.getCurrentUrl();
		
		if(actualPageTitle.equals(expectedPageTitle) && actualPageUrl.equals(expectedPageUrl)) {
			System.out.println("The Landing Page is Valid");
		}else {
			System.out.println("The Landing Page is not Valid");
		}
	}
	@Test(priority=2)
	public void signinButtonIsVisible() {
		S2_LandingPage landingPage = new S2_LandingPage(driver);
		landingPage.signInButton(); 
		softassert.assertTrue( landingPage.signinButtonIsDisplayed(), "signinButton is not displayed");
		softassert.assertAll();
	}
	@Test(priority=3)
	public void redifflogoIsDisplayed() {
		S2_LandingPage landingPage = new S2_LandingPage(driver);
		landingPage.rediffLogo(); 
		softassert.assertTrue( landingPage.rediffLogoIsDisplayed(), "rediffLogo is not displayed");
		System.out.println("Rediff Landing Page Tests are Functional");
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	
		
		
			
		}
		
	}


