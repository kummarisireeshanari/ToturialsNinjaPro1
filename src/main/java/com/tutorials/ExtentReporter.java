package com.tutorials;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	
	
	public static ExtentReports genterateExtentReport() throws IOException {
		
		ExtentReports extentReport = new ExtentReports();
		// \\test-output\\ExtentReports\\extentReport.html"
		 File extentReportFile =  new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		 ExtentSparkReporter sparkReporter =  new ExtentSparkReporter(extentReportFile);
		 
		 sparkReporter.config().setTheme(Theme.DARK);
		 sparkReporter.config().setReportName("TestNg Repoter Automation result");

		 sparkReporter.config().setDocumentTitle("TN Automation Report");
		 sparkReporter.config().setTimeStampFormat("dd/mm/yyyy hh:mm:sss");
		 
		 extentReport.attachReporter(sparkReporter);
		 
		 Properties configProp = new Properties();
		 File configPropFile =  new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialscongig\\qa\\config\\config.properties");
		 FileInputStream fisConfigProp = new FileInputStream(configPropFile);
		 configProp.load(fisConfigProp);
		 
		 extentReport.setSystemInfo("Application URL", configProp.getProperty("url"));
		 
		 extentReport.setSystemInfo("Browser Name", configProp.getProperty("browserName"));
		 extentReport.setSystemInfo("Email", configProp.getProperty("validEmail"));
		 extentReport.setSystemInfo("Password", configProp.getProperty("validPassword"));
		 extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		 extentReport.setSystemInfo("Username", System.getProperty("user.name"));
		 extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		 
		 return extentReport;
		 
	}
	
	
}
