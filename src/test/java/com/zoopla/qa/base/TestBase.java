package com.zoopla.qa.base;

import org.testng.annotations.AfterMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static FileInputStream inputStream;
	public static Properties properties;
	
	@BeforeSuite
	public void setup() throws IOException {
		String configPath = System.getProperty("user.dir") + "//src//test//resources//config//config.properties";
		
		inputStream = new FileInputStream(configPath);
		properties = new Properties();
		properties.load(inputStream);
		
		String browserName = properties.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if(browserName.equalsIgnoreCase("ie")){
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Integer.parseInt(properties.getProperty("implicit.wait")), TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(properties.getProperty("pageload.wait")), TimeUnit.SECONDS);
		
		driver.get(properties.getProperty("testUrl"));
	}
	

//	@AfterSuite
//	public void tearDown() {
//		if(driver!=null) {
//			driver.quit();
//		}
//	}
}
