package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	//Objects : this webelemnts are objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchrOption;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement searchrButton;
	
	
	public HomePage(WebDriver driver) {
		
		this.driver =driver;
		PageFactory.initElements(driver, this);
	
	}
	
	
	//Actions
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
	}
	
	public LoginPage selectLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	public RegisterPage  selectRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public SearchPage  clickOnSearchButton() {
		searchrButton.click();
		return new SearchPage(driver);
		
	}
	public void  enterProductIntoSearchBoxFiled(String productText) {
		searchrOption.sendKeys(productText);
	}
	
	
	public LoginPage navigateLoginOption() {
		myAccountDropMenu.click();
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage  navigateToRegisterOption() {
		myAccountDropMenu.click();
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public SearchPage  searchForAProduct(String productText) {
		searchrOption.sendKeys(productText);//
		searchrButton.click();
		return new SearchPage(driver);
	}
	
	
/*
	public void selectLoginOption() {
		loginOption.click();
		
	}

	public void  selectRegisterOption() {
		registerOption.click();
	}
	
	public SearchPage  clickOnSearchButton() {
		searchrButton.click();
		return new SearchPage(driver);
	}

	*/

}
