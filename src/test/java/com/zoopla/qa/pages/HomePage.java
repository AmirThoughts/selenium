package com.zoopla.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zoopla.qa.testcases.HomePageTest;

public class HomePage extends HomePageTest {
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Sign in")
	WebElement signInButton;
	
	@FindBy(id="search-input-location")
	WebElement searchLocation;
	
	@FindBy(xpath="//ul[contains(@class, 'ui-widget-content')]/li")
	List<WebElement> searchLocationSuggestions;
	
	
	@FindBy(xpath="//select[@id='forsale_price_min']")
	WebElement minimumPriceDropdown;
	
	@FindBy(xpath="//select[@id='forsale_price_max']")
	WebElement maximumPriceDropdown;
	
	@FindBy(xpath="//select[@id='property_type']")
	WebElement propertyTypeDropdown;
	
	@FindBy(xpath="//select[@id='beds_min']")
	WebElement minimumBedsDropdown;
	
	@FindBy(id="search-submit")
	WebElement searchButton;
	
	
	public void clickOnSignInLink() {
		signInButton.click();
	}
	
	public void selectSearchLocation(WebElement locationField, String location, List<WebElement> locationSuggestions, int index) throws InterruptedException {
		locationField.sendKeys(location);
		Thread.sleep(2000);
//		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(properties.getProperty("explicit.wait")));
//		wait.until(ExpectedConditions.visibilityOfAllElements(locationSuggestions));
		locationSuggestions.get(index).click();
	}
	
	public void searchProperty() throws InterruptedException{
		selectSearchLocation(searchLocation,"London", searchLocationSuggestions, 4);
		selectFromDropdown(minimumPriceDropdown, "30000");
		selectFromDropdown(maximumPriceDropdown, "80000");
		selectFromDropdown(propertyTypeDropdown, "houses");
		selectFromDropdown(minimumBedsDropdown, "3");
		searchButton.click();
	}
	
	public void selectFromDropdown(WebElement dropDown, String option) {
		Select select = new Select(dropDown);
		select.selectByValue(option);
	}
	
}
