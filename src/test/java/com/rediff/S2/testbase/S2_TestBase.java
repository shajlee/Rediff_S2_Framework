package com.rediff.S2.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.rediff.S2.utilities.S2_Utilities;

public class S2_TestBase {
	
	public static WebDriver driver;
	public static ChromeOptions optionsC;
	public static FirefoxOptions optionsF;
	public static EdgeOptions optionsE;
	public Properties prop;
	public FileInputStream ip;
	
	public S2_TestBase() throws IOException {
		prop = new Properties();
	    ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\rediff\\S2\\config\\Rediff_S2_Configurations.properties");
		prop.load(ip);
	}
	
	
	
	
	public WebDriver launchBrowserAndInitializeApplication(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			optionsC = new ChromeOptions();
			optionsC.addArguments("--incognito");
			optionsC.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new ChromeDriver(optionsC);
		}else if(browserName.equalsIgnoreCase("firefox")) {
			optionsF = new FirefoxOptions();
			optionsF.addArguments("--incognito");
			optionsF.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new FirefoxDriver(optionsF);
		}else if(browserName.equalsIgnoreCase("edge")) {
			optionsE = new EdgeOptions();
			optionsE.addArguments("--incognito");
			optionsE.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new EdgeDriver(optionsE);
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(S2_Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(S2_Utilities.PAGELOAD_TIME));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(S2_Utilities.SCRIPT_TIME_OUT));
		driver.manage().deleteAllCookies();
		return driver;
		
		
		
			
			
			
		}
	}


