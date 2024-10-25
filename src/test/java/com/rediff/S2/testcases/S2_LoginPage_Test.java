package com.rediff.S2.testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rediff.S2.pages.S2_LoginPage;
import com.rediff.S2.testbase.S2_TestBase;
import com.rediff.S2.testdata.S2_SupplyTestData;
import com.rediff.S2.utilities.S2_Utilities;

public class S2_LoginPage_Test extends S2_TestBase {
	
	public S2_LoginPage_Test() throws IOException {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = launchBrowserAndInitializeApplication(prop.getProperty("browser1"));
		S2_LoginPage loginPage = new S2_LoginPage(driver);
		loginPage.clickOnSignInLink();
		
	}
	@Test(priority=1, dataProvider = "RediddS2DataProviderDataSupply", dataProviderClass = S2_SupplyTestData.class)
	public void loginWithValidCredentialsUsingDataProvider(String username, String password) {
		S2_LoginPage loginPage = new S2_LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnSigninButton();
		loginPage.userName(); 
		softassert.assertTrue(loginPage.usernameIsDisplayed(), "userName is not displayed");
		System.out.println("Login with valid credentials in functional");
		softassert.assertAll();
	}
	@Test(priority=2, dataProvider = "RediffExcelDataWithDataProvider", dataProviderClass = S2_SupplyTestData.class)
	public void loginWithValidCredentialsUsingDataProviderExcelSheet(String username, String password) {
		S2_LoginPage loginPage = new S2_LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnSigninButton();
		loginPage.userName(); 
		softassert.assertTrue(loginPage.usernameIsDisplayed(), "userName is not displayed");
		System.out.println("Login with valid credentials in functional");
		softassert.assertAll();
	}
	@Test(priority=3)
	public void loginWithInvalidCredentials() {
		S2_LoginPage loginPage = new S2_LoginPage(driver);
		loginPage.enterUsername(S2_Utilities.GenerateEmailWithTimeStamp());
		loginPage.enterPassword(S2_Utilities.GeneratePasswordWithTimeStamp());
		loginPage.clickOnSigninButton();
		loginPage.invalidCredentials(); 
		softassert.assertTrue(loginPage.invalidCredentialsMessageIsDisplayed(), "invalidCredentialsMessage is not displayed");
		System.out.println("Login with invalid credentials in functional");
		softassert.assertAll();
	}
	@Test(priority=4)
	public void loginWithValidUsernameInvalidPassword() {
		S2_LoginPage loginPage = new S2_LoginPage(driver);
		loginPage.enterUsername(prop.getProperty("validUsername"));
		loginPage.enterPassword(S2_Utilities.GeneratePasswordWithTimeStamp());
		loginPage.clickOnSigninButton();
		loginPage.invalidCredentials(); 
		softassert.assertTrue(loginPage.invalidCredentialsMessageIsDisplayed(), "invalidCredentialsMessage is not displayed");
		System.out.println("Login with valid Username and invalid passowrd is functional");
		softassert.assertAll();
	}
	@Test(priority=5)
	public void loginWithInvalidUsernameValidPassword() {
		S2_LoginPage loginPage = new S2_LoginPage(driver);
		loginPage.enterUsername(S2_Utilities.GenerateEmailWithTimeStamp());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnSigninButton();
		loginPage.invalidCredentials(); 
		softassert.assertTrue(loginPage.invalidCredentialsMessageIsDisplayed(), "invalidCredentialsMessage is not displayed");
		System.out.println("Login with invalid Username and valid passowrd is functional");
		softassert.assertAll();
	}
	@Test(priority=6)
	public void loginWithNoCredentials() {
		S2_LoginPage loginPage = new S2_LoginPage(driver);
		loginPage.enterUsername("");
		loginPage.enterPassword("");
		loginPage.clickOnSigninButton();
		
		Alert alert = driver.switchTo().alert();
		String actualNoCredentialsAlertText = prop.getProperty("actualNoCredentialsMessage");
		String expectedNoCredentialsAlertText = alert.getText();
		
		softassert.assertEquals(actualNoCredentialsAlertText, expectedNoCredentialsAlertText);
		if(actualNoCredentialsAlertText.equalsIgnoreCase(expectedNoCredentialsAlertText)) {
			alert.accept();
		}else {
			alert.dismiss();
			System.out.println("Login with no credentials is functional");
			softassert.assertAll();
		}
		}
		@AfterMethod
		public void tearDown() {
			driver.quit();
			
		
		
		
		
		
		
		
	
	

}
	}
