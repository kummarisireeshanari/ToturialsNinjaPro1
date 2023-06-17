package com.tutorialsninja.qa.testcase;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialnija.qa.base.Base;
import com.tutorials.Utilites;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.pages.RegisterPage;
//import com.tutorialsninja.qa.utils.Utilities;

public class RigsterTest extends Base {
	
	
	public RigsterTest() throws Exception  {
		super();
		
	}
	RegisterPage registerpage;
	
	public  WebDriver driver;
	 AccountSuccessPage accountScuccesspage;
	
	@BeforeMethod
	public void Setup() {
		
       
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		
		HomePage homepage = new HomePage(driver);
		registerpage = homepage.navigateToRegisterOption();
		 
			
	}
	
	

	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void verifyRegisterAnAccountWithMandatoryFields() {
		
		accountScuccesspage=	registerpage.registerWithManndataryFields(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),Utilites.generateEmailTimeStamp1(),dataProp.getProperty("telePhoneNumber"),prop.getProperty("validPassword"));
		 Assert.assertEquals(accountScuccesspage.retriveAccountSuccessPageHeding(), dataProp.getProperty("accountSueccsfullyCreatedHeading"),"Account Success page is not dispalyed");
		 
		//String actualSuccessfulHeading = accountScuccesspage.retriveAccountSuccessPageHeding();
			//Assert.assertEquals(accountSueccsfullyCreatedHeading, dataProp.getProperty("accountSueccsfullyCreatedHeading"),"Account Success page is not dispalyed");
			

	
	}
	
	
	@Test(priority=2)
public void verifyRegisteringAccountByProvidingAllFields() {
	
		accountScuccesspage = registerpage.registerWithAllManndataryFields(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),Utilites.generateEmailTimeStamp1(),dataProp.getProperty("telePhoneNumber"),prop.getProperty("validPassword"));
	Assert.assertEquals(accountScuccesspage.retriveAccountSuccessPageHeding(), dataProp.getProperty("accountSueccsfullyCreatedHeading"));
	

}

	@Test(priority=3)
	public void verifyRegisteringAccountWithExtistingEmailAddreess() {
		
		
		accountScuccesspage = registerpage.registerWithAllManndataryFields(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),prop.getProperty("validEmail"),dataProp.getProperty("telePhoneNumber"),prop.getProperty("validPassword"));
		Assert.assertTrue(registerpage.retriveDuplicateEmailAddressWarning().contains(dataProp.getProperty("duplicateEmailWarning")), "Warning message regarding duplicate email adress is not diplayed");

	//	*[@id=\"account-register\"]/div[1]	

	}
	
	
	/*
	@Test(priority=4)
	public void verifyRegisteringAccountWithoutDeatils() {
		
		
		//registerpage.selectPrivarcyPolicy();
		
		registerpage.clickOnConitune();
		Assert.assertTrue(registerpage.displayStatusOfWarningMessages(dataProp.getProperty("privacyPolicyWarning"), dataProp.getProperty("firstNameWarning"), prop.getProperty("emailWarning"), dataProp.getProperty("telephoneWarning"), dataProp.getProperty("passwordWarning")));
		
		
		//String actualPrivatePolicyWsrning = registerpage.retrvePrivacyPolicyWarning();
		//Assert.assertTrue(registerpage.retrvePrivacyPolicyWarning().contains(dataProp.getProperty("privacyPolicyWarning")), "Privacy Policy Warning message is not diplayed");

		
		//String actualFirstNameWarning= registerpage.retriveFirstNameWarning();
		//Assert.assertEquals(registerpage.retriveFirstNameWarning(), dataProp.getProperty("firstNameWarning"),"First Name Warning Message is not  Dispalyed");
		
		
		//String actualLastNameWarninng1 = registerpage.retrveLastNameWarning();
		//Assert.assertEquals(actualLastNameWarninng1, dataProp.getProperty("lastNameWarning"),"Last Name Warning Message is not  Dispalyed");
		
		//String actualEmailWarning= registerpage.retriveEmailAddressWarning();
		//Assert.assertEquals(registerpage.retriveEmailAddressWarning(), dataProp.getProperty("emailWarning"),"Email Warning Message is not  Dispalyed");
		
		//String actualTelephoneWarninng = registerpage.retrveTelephoneWarning();
		//Assert.assertEquals(registerpage.retrveTelephoneWarning(), dataProp.getProperty("telephoneWarning"),"Phone Warning Message is not  Dispalyed");
		
		
		//String actualPasswordWarning= registerpage.retrvePasswordWarning();
		//Assert.assertEquals(registerpage.retrvePasswordWarning(),dataProp.getProperty("passwordWarning"),"password Warning Message is not  Dispalyed");
	
		

	}
	*/

}
