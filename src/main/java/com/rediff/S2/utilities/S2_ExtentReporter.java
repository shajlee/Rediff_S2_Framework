package com.rediff.S2.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class S2_ExtentReporter {
	
	public static ExtentReports generateExtentReport() throws Exception {
		ExtentReports extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html");
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setReportName("Rediff Framewrok Hybrid S2 Results");
		sparkReporter.config().setDocumentTitle("Rediff Framewrok Hybrid S2 Test");
		sparkReporter.config().setTimeStampFormat("mm/dd/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter); 
		
		Properties Prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\rediff\\S2\\config\\Rediff_S2_Configurations.properties");
		Prop.load(ip);
		
		extentReport.setSystemInfo("Application URL", Prop.getProperty("url"));
		extentReport.setSystemInfo("Project Browser", Prop.getProperty("browser1"));
		extentReport.setSystemInfo("Valid Email", Prop.getProperty("validUsername"));
		extentReport.setSystemInfo("Valid Password", Prop.getProperty("validPassword"));
		extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));
		extentReport.setSystemInfo("Operating System Version", System.getProperty("os.version"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.runtime.version"));
		extentReport.setSystemInfo("QA Tester Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("QA Tester Country", System.getProperty("user.country"));
		extentReport.setSystemInfo("QA Tester Language", System.getProperty("user.language"));
		
		return extentReport;

}
}