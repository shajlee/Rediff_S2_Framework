package com.rediff.S2.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rediff.S2.pages.S2_LinksPage;
import com.rediff.S2.testbase.S2_TestBase;

public class S2_Links_Test extends S2_TestBase {
	public S2_Links_Test() throws IOException {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = launchBrowserAndInitializeApplication(prop.getProperty("browser1"));
		
	}
	@Test
	public void linkTests() {
		S2_LinksPage links = new S2_LinksPage(driver);
		links.clickOnRediffMailLink();
		links.rediffBusinessMailLogo(); 
		softassert.assertTrue(links.rediffMailLogoIsDisplayed(), "rediffmailLogo is not displayed");
		softassert.assertAll();
		
		driver.navigate().back();
		
		links.clickOnRediffMoneyLink();
		links.rediffMoneyLogo(); 
		softassert.assertTrue(links.rediffMoneyLogoIsDisplayed(), "rediffmoneyLogo is not displayed");
		softassert.assertAll();
		
		driver.navigate().back();
		
		links.clickOnRediffBusinessMailLink();
		links.rediffBusinessMailLogo(); 
		softassert.assertTrue(links.rediffBusinessMailLogoIsDisplayed(), "rediffBusinessMailLogo is not displayed");
		softassert.assertAll();
		
		driver.navigate().back();
		
		links.clickOnRediffVideoLink();
		links.rediffVideoLogo();
		softassert.assertTrue(links.rediffVideoLogoIsDisplayed(), "videoLogo is not displayed");
		softassert.assertAll();
		
		driver.navigate().back();
		
		links.clickOnRediffGuruLink();
		links.rediffGuruLogo();
		softassert.assertTrue(links.rediffGuruLogoIsDisplayed(), "rediffGuruLogo is not displayed");
		softassert.assertAll();
		
		driver.navigate().back();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		

}
}

