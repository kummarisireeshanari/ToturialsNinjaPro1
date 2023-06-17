package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	

	   WebDriver driver;
		
		//Objects : this webelemnts are objects
	   
	   @FindBy(id="input-firstname")
		 private WebElement fistNameFields;
	   
	   @FindBy(id="input-lastname")
		 private WebElement lastNameFields;
	   
		@FindBy(id="input-email")
		 private WebElement emailAddressFields;
		

		@FindBy(id="input-telephone")
		private WebElement telephoneField;
		
		
		@FindBy(id="input-password")
		private WebElement passwordFields;
		

		@FindBy(id="input-confirm")
		private WebElement confirmpasswordFields;
		
		

		@FindBy(xpath="//input[@name='newsletter'][@value='1']")
		private WebElement yestNewSletterOption;
		
		@FindBy(name="agree")
		private WebElement policyprivarcyFileds;
		//agree
		
		@FindBy(xpath="//input[@value='Continue']")
		private WebElement conituethetext;
		
		@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
		private WebElement duplicateEmailAddressWarning;
		
		@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
		private WebElement priverPolicyWarning;
		
		@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
		private WebElement firstNameWarning;
		
		@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
		private WebElement lastNameWarning;
		

		@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
		private WebElement emailWarning;
		
		@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
		private WebElement passwordWarning;
		
		@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
		private WebElement telePhoneNumberWarning;
		
		
		public RegisterPage(WebDriver driver) {
			
			this.driver =driver;
			PageFactory.initElements(driver, this);
	
		}
		
		
		//Actions
		public void enterFirstAddress(String fristNameText) {
			fistNameFields.sendKeys(fristNameText);
		}
		
		public void enterLastAddress(String lastNameText) {
			lastNameFields.sendKeys(lastNameText);
		}
		
		public void enterEmailAddress(String emailText) {
			emailAddressFields.sendKeys(emailText);
		}
		
		public void entertelephoneNumber(String telephonenumber) {
			telephoneField.sendKeys(telephonenumber);
		}
		
		public void enterPassword(String  passwordText) {
			passwordFields.sendKeys(passwordText);

		}
		

		public void enterConifrmPassword(String  passwordText) {
			confirmpasswordFields.sendKeys(passwordText);
		}

		
		public void selectYesNewSletterOption() {
			yestNewSletterOption.click();
		}
		
		
		public void selectPrivarcyPolicy() {
			policyprivarcyFileds.click();
		}
		
		/*	
		
		public void clickOnConitune() {
			conituethetext.click();
		}
		
		*/	
	public AccountSuccessPage clickOnConitune() {
			
			conituethetext.click();
			return new AccountSuccessPage(driver);
			
		
		
		}
		
		public String retriveDuplicateEmailAddressWarning() {
			String duplicateEmailAddressWarningText =  duplicateEmailAddressWarning.getText();
			return duplicateEmailAddressWarningText;
			
		}
		
		public String retrvePrivacyPolicyWarning() {
			String privacyPolicyWarningText =priverPolicyWarning.getText();
			return privacyPolicyWarningText;
		}
		
		public String retriveFirstNameWarning() {
			String firstNameWarningText =  firstNameWarning.getText();
			return firstNameWarningText;
			
		}
		
		public String retrveLastNameWarning() {
			String lastNameyWarningText =lastNameWarning.getText();
			return lastNameyWarningText;
		}
		
		public String retriveEmailAddressWarning() {
			String emailAddressWarningText =  emailWarning.getText();
			return emailAddressWarningText;
			
		}
		
		public String retrvePasswordWarning() {
			String passwordWarningText =passwordWarning.getText();
			return passwordWarningText;
		}
		
		public String retrveTelephoneWarning() {
			String telePhoneWarningText =telePhoneNumberWarning.getText();
			return telePhoneWarningText;
		}

   public AccountSuccessPage registerWithManndataryFields(String fristNameText,String lastNameText, String emailText,String telephonenumber, String passwordText) {
	   fistNameFields.sendKeys(fristNameText);
	   lastNameFields.sendKeys(lastNameText);
	   emailAddressFields.sendKeys(emailText);
	   telephoneField.sendKeys(telephonenumber);
	   passwordFields.sendKeys(passwordText);
	   confirmpasswordFields.sendKeys(passwordText);
	   policyprivarcyFileds.click();
	   conituethetext.click();
		return new AccountSuccessPage(driver);
		
	   
   }
   
   
   public AccountSuccessPage registerWithAllManndataryFields(String fristNameText,String lastNameText, String emailText,String telephonenumber, String passwordText) {
	   fistNameFields.sendKeys(fristNameText);
	   lastNameFields.sendKeys(lastNameText);
	   emailAddressFields.sendKeys(emailText);
	   telephoneField.sendKeys(telephonenumber);
	   passwordFields.sendKeys(passwordText);
	   confirmpasswordFields.sendKeys(passwordText);
	   yestNewSletterOption.click();
	   policyprivarcyFileds.click();
	   conituethetext.click();
		return new AccountSuccessPage(driver);
		
	   
   }
   /*
   public boolean displayStatusOfWarningMessages(String expectedPrivacyPolicyWarning,String expectedFirstNameWarning,String expectedEmailAddressWarning,String expectedTelephoneWarning,String expectedPasswordWarning) {
		
	  // String actualPrivacyPolicyWarningText  = priverPolicyWarning.getText();
		boolean privacyPolicyWarningStatus = priverPolicyWarning.getText().contains(expectedPrivacyPolicyWarning);
		
		//String actualFirstNameWarningText =  firstNameWarning.getText();
		boolean firstNameWarningStatus = firstNameWarning.getText().equals(expectedFirstNameWarning);
		
		//String actualLastNameyWarningText =lastNameWarning.getText();
		//boolean lastNameWarningStatus = lastNameWarning.getText().equals(expectedLastNameWarning);
		
		
		//String actualEmailAddressWarningText =  emailWarning.getText();
		boolean emailWarningStatus = emailWarning.getText().equals(expectedEmailAddressWarning);
		
		//String  actualTelePhoneWarningText =telePhoneNumberWarning.getText();
		boolean telephoneWarningStatus = telePhoneNumberWarning.getText().equals(expectedTelephoneWarning);
		
		//String   actualPasswordWarningText =passwordWarning.getText();
		boolean passwordWarningStatus = passwordWarning.getText().equals(expectedPasswordWarning);
		
		return privacyPolicyWarningStatus && firstNameWarningStatus  && emailWarningStatus && telephoneWarningStatus && passwordWarningStatus;
	}
*/
		
}
