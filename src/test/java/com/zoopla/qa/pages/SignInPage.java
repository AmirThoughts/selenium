package com.zoopla.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.testcases.SignInPageTest;

public class SignInPage extends SignInPageTest{
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="signin_email")
	WebElement emailField;
	
	@FindBy(id="signin_password")
	WebElement passwordField;
	
	@FindBy(id="signin_submit")
	WebElement signInButton;
	
	
	public void doSignIn(String emailId, String password) {
		emailField.sendKeys(emailId);
		passwordField.sendKeys(password);
		signInButton.click();
	}
	
	
	
}
