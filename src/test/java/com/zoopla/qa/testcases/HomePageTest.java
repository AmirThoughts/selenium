package com.zoopla.qa.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.zoopla.qa.base.TestBase;
import com.zoopla.qa.pages.HomePage;
import com.zoopla.qa.pages.SignInPage;

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	SignInPage signInPage;
	
	@BeforeClass
	public void instantiatePage() {
		homePage =  new HomePage(driver);
		signInPage = new SignInPage(driver);
	}

	
	@Test
	public void validateLogin() throws InterruptedException { 
		SoftAssert assertion = new SoftAssert();
		homePage.clickOnSignInLink();
		signInPage.doSignIn(properties.getProperty("emailId"), properties.getProperty("password"));
		boolean isSignedInPresent =driver.getCurrentUrl().contains("signedin");
		assertion.assertTrue(isSignedInPresent, "Signed in successfully");
		assertion.assertAll();
	}
	
	@Test
	public void validateSearch() throws InterruptedException {
		SoftAssert assertion = new SoftAssert();
		Thread.sleep(5000);
		homePage.searchProperty();
		boolean isFlatSalePresent = driver.getCurrentUrl().contains("for-sale");
		assertion.assertTrue(isFlatSalePresent, "Landed to Search Page");
		assertion.assertAll();
	}
	
	
	
	
	
	
	
	
	
	
}
