package com.rediff.S2.listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.rediff.S2.utilities.S2_ExtentReporter;

public class S2_Listeners implements ITestListener {
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		try {
			extentReport = S2_ExtentReporter.generateExtentReport();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		String TestName = result.getName();
		extentTest = extentReport.createTest(TestName);
		extentTest.log(Status.INFO, TestName + "Initialized & Started Executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String TestName = result.getName();
		extentTest = extentReport.createTest(TestName);
		extentTest.log(Status.PASS, TestName + "Successfully Executed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String TestName = result.getName();
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\test-output\\ScreenShots\\" + TestName + ".png";
		try {
			FileHandler.copy(source, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		extentTest.addScreenCaptureFromPath(destination);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, TestName + "failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String TestName = result.getName();
		extentTest = extentReport.createTest(TestName);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, TestName + "Got Skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		String TestName = result.getName();
		System.out.println(TestName + "With This Much Percentage");
		System.out.println(result.getThrowable());
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Rediff S2 Project Initialized, Executed and Successfully Concluded");
		extentReport.flush();
		

}
}
