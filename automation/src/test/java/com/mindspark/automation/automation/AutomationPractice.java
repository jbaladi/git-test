package com.mindspark.automation.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomationPractice {
	public WebDriver driver;
	//This Before Class always runs before starting any other testing
	@BeforeClass(alwaysRun=true)
	  public void begin() {
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Jason\\Desktop\\Selenium Jars\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		 driver = new FirefoxDriver();
	  }
	
	//This After Class always runs after ending testing. The method exits FireFox.
	@AfterClass(alwaysRun=true)
	public void teardown() {
		driver.quit();
}	
	
	//This test verifies that if the User can log into a website.
	@Test
	  public void SignOnTest1() {
		  driver.get("http://automationpractice.com/index.php");
		  WebElement login = driver.findElement(By.className("login"));
		  login.click();
		  WebElement emailAddress = driver.findElement(By.id("email"));
		  emailAddress.sendKeys("jbaladi@mindsparktech.com");
		  WebElement password = driver.findElement(By.id("passwd"));
		  password.sendKeys("test");
		  WebElement loginButton = driver.findElement(By.id("SubmitLogin"));
		  loginButton.click();
		  
		  
	  }
	//This test verifies, if a user can register for a website.
	@Test
	public void RegisterTest2()
	{
		driver.get("http://automationpractice.com/index.php");
		WebElement login = driver.findElement(By.className("login"));
		login.click();
		WebElement emailAddressCreate = driver.findElement(By.id("email_create"));
		emailAddressCreate.sendKeys("jbaladi@mindsparktech.com");
		emailAddressCreate.sendKeys(Keys.ENTER);
		WebElement submitButton = driver.findElement(By.id("SubmitCreate"));
		submitButton.click();
	}
	//This test verifies, if a user can click through to the Registration page on the web site
	@Test
	  public void SearchTest3() {
		  driver.get("http://automationpractice.com/index.php");
		  WebElement search = driver.findElement(By.xpath("//*[@id='search_query_top']"));
		  search.sendKeys("t-shirt");
		  WebElement searchButton=driver.findElement(By.xpath("//button[@name=\"submit_search\"]"));
		  searchButton.click();
	  }
}
