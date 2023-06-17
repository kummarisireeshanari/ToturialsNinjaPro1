package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	

	   WebDriver driver;
		
		//Objects : this webelemnts are objects
	   
		@FindBy(linkText="HP LP3065")
		 private WebElement validHpProduct;
		
		
		@FindBy(xpath="//div[@id='search']/descendant::button")
		 private WebElement serachButton;
		
		
		@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
		private WebElement noHpProductMessage;
		
		
		
		public SearchPage(WebDriver driver) {
			
			this.driver =driver;
			PageFactory.initElements(driver, this);
		
		}
		
		
		//Actions
		public boolean displayStatusOfHpProduct() {
			boolean displayed= validHpProduct.isDisplayed();
			return displayed;
		}
		
		

		public SearchPage searchProductButton() {
			serachButton.click();
			return new SearchPage(driver);
		}
		
		
		public String retriveNoProductWarningTextMessageText() {
			String  noProductWarningText = noHpProductMessage.getText();
			return noProductWarningText;
		}
		
		
		
		
		
		
	
	

}
