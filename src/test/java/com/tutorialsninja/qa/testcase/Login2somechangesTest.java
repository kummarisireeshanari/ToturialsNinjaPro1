package com.tutorialsninja.qa.testcase;


import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import com.tutorialsninja.qa.pages.HomePage;

import com.tutorialnija.qa.base.Base;
import com.tutorials.Utilites;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;

public class Login2somechangesTest extends Base {

	 LoginPage loginPage;
	 AccountPage accountpage;
	 
	public Login2somechangesTest() {
		super();
	}
	
	 public WebDriver driver;
	
	@BeforeMethod
	public void Setup() {
		
	  driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));	
	  HomePage homepage = new HomePage(driver);
	  loginPage =  homepage.navigateLoginOption();
		
	  
		
	}
	
	@AfterMethod
	public void  teardown() {
		driver.quit();
	}
	
	@Test(priority=1, dataProvider="validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email, String password) {
		
		
			
		accountpage = loginPage.login(email, password);
		
		Assert.assertTrue(accountpage.getDispalyStatusOfEditYourAccountInformationOption());
		
		
		}
	
	@DataProvider(name = "validCredentialsSupplier")
	public Object[][] supplyTestData() {
		
		Object[][] data = Utilites.getTestDataFromExcel("Login");
		return data;
	}

	
	@Test(priority=2, dataProvider="validCredentialsSupplier")
	public void verifyLoginWithInvalidcredentials(String email, String password) {
		
		loginPage.login(Utilites.generateEmailTimeStamp1(), dataProp.getProperty("invalidPassword"));
		
		//String Waraningmsge = 
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatch");
		Assert.assertTrue(loginPage.retriveEmailPasswordNotMatchingWaringMessageText().contains(expectedWarningMessage), "Expected Warning message is not dispalyed");
			
	}
	
	

@Test(priority=3, dataProvider="validCredentialsSupplier")
public void verifyLoginWithInvalidEmailAndValidPassword(String email, String password) {
	
	loginPage.login(dataProp.getProperty("invalidEmail"), prop.getProperty("validPassword"));
	Assert.assertTrue(loginPage.retriveEmailPasswordNotMatchingWaringMessageText().contains(dataProp.getProperty("emailPasswordNoMatch")), "Expected Warning message is not dispalyed");
	
}


@Test(priority=4, dataProvider="validCredentialsSupplier")
public void verifyLoginWithNoValues(String email, String password) {
	
	
	loginPage.clickOnLoginButton();
	Assert.assertTrue(loginPage.retriveEmailPasswordNotMatchingWaringMessageText().contains(dataProp.getProperty("emailPasswordNoMatch")), "Expected Warning message is not dispalyed");
	
}
}