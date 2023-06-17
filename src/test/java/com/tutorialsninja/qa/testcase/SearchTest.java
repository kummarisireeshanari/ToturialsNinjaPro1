package com.tutorialsninja.qa.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialnija.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

// Updated Comment i added more details
public class SearchTest extends Base{

	HomePage homepage;
	SearchPage searchpage;
    public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		homepage = new HomePage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
	
		searchpage = homepage.searchForAProduct(dataProp.getProperty("validProduct"));
		Assert.assertTrue(	searchpage.displayStatusOfHpProduct(),"valid product HP is not dispalyed  in the search results");
		
	}
	
	
	

	@Test(priority=2) // if is failed  , priority 3 also failed
	public void verifySearchWithInValidProduct() {
		
		searchpage = homepage.searchForAProduct(dataProp.getProperty("invalidProduct"));
		Assert.assertEquals(searchpage.retriveNoProductWarningTextMessageText(),"abc","No product message in search results is not diplayed");
		
		//Assert.assertEquals(searchpage.retriveNoProductWarningTextMessageText(),dataProp.getProperty("NoProductTextInSearchResults"),"No product message in search results is not diplayed");
		// There is no product that matches the search criteria.","No product message in search results is not diplayed"
	}
	
	

	
	//@Test(priority=3 , dependsOnMethods= {"verifySearchWithInValidProduct", "verifySearchWithValidProduct"}) // it is execute 3 times 1, 2 & 3rd one
	@Test(priority=3) // it is execute 3 times 1, 2 & 3rd one
	public void verifySearchWithoutAnyProduct() {
			
		searchpage =homepage.clickOnSearchButton();	
		Assert.assertEquals(searchpage.retriveNoProductWarningTextMessageText(), dataProp.getProperty("NoProductTextInSearchResults"),"No product message in search results is not diplayed");
		
}
}

