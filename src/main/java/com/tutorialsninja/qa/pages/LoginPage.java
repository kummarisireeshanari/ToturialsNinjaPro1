package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
    public WebDriver driver;
	
	//Objects : this webelemnts are objects
   
	@FindBy(id="input-email")
	 private WebElement emailAddressFields;
	
	@FindBy(id="input-password")
	private WebElement passwordFields;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,' alert-dismissible')]")
	 private WebElement emailAddressNotMacting;
	
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver =driver;
		PageFactory.initElements(driver, this);
	
	}
	
	
	//Actions
	public void enterEmailAddress(String emailText) {
		emailAddressFields.sendKeys(emailText);
	}
	
	
	public void enterPassword(String  passwordText) {
		passwordFields.sendKeys(passwordText);
	
	
	}
	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	}
	
	public AccountPage login(String emailText,String  passwordText ) {
		emailAddressFields.sendKeys(emailText);
		passwordFields.sendKeys(passwordText);
		loginButton.click();
		return new AccountPage(driver);
	}
	
	/*
	public void clickOnLoginButton() {
		loginButton.click();
		
	}
	
	
	}
	*/
	
	public String retriveEmailPasswordNotMatchingWaringMessageText() {
		String  warningText = emailAddressNotMacting.getText();
		return warningText;
	}
	
	
	
	
	
	
	
	
	
}
