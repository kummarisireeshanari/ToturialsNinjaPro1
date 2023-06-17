package com.tutorialnija.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorials.Utilites;

public class Base {
	
	WebDriver driver;
	 public Properties prop;
	 public Properties dataProp;
	
	public   Base()   {
		
		 prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialscongig\\qa\\config\\config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		dataProp = new Properties();
		File dataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsnija\\qa\\testdata\\testdata.properties");
		                                       //C:\Users\kumma\eclipse-workspace\TutorialsNinjaSeleniumProj\src\main\java\com\tutorialsnija\qa\testdata
		try {
			
			FileInputStream dataFis = new FileInputStream(dataPropFile);
			dataProp.load(dataFis);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		

	}
	
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
		
		
     if(browserName.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
			
		}
         ChromeOptions options = new ChromeOptions();
		   //options.addArguments("--remote-allow-origins=*");
            // options.addArguments("--headless=new");
         options.setExperimentalOption("detach", true);
		   driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilites.IMPLICT_WAIT_TIME));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilites.PAGE_LOAD_TIME));
			driver.get(prop.getProperty("url"));
			
			return   driver;
			
			
			 //driver = new ChromeDriver(options);
			

}
}
