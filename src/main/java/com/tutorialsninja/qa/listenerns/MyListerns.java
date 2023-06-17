package com.tutorialsninja.qa.listenerns;

import java.awt.Desktop;
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
import com.tutorials.ExtentReporter;
import com.tutorials.Utilites;

public class MyListerns implements ITestListener {
	ExtentReports extentReport;
	ExtentTest extenTest;
	WebDriver	driver;
	
// String testName;
 
	@Override
	public void onStart(ITestContext context) {
		
		
		try {
			 extentReport =  ExtentReporter.genterateExtentReport();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}
	
	@Override
	public void onTestStart(ITestResult result) {
		
		
		//testName = result.getName();
		 extenTest = extentReport.createTest( result.getName());
		extenTest.log(Status.INFO,  result.getName()+"started executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extenTest.log(Status.PASS,  result.getName()+"go successfully executed");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			
			e.printStackTrace();
		}
		
		String destinationScreenshotPath = Utilites.captureScreenshot(driver, result.getName());
		
		
		extenTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extenTest.log(Status.INFO, result.getThrowable());
		extenTest.log(Status.FAIL,  result.getName()+"got failed");
	
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		 
		extenTest.log(Status.INFO, result.getThrowable());
		extenTest.log(Status.SKIP,  result.getName()+ "got skipped");
		
		
		
	}


	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File extentReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	
	
	
}
