package com.app.tests;

import org.testng.annotations.Test;

import com.app.pages.CartPage;
import com.app.pages.HomePage;
import com.app.pages.LoginPage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class AppTests {
	WebDriver driver ;
	Properties propObj;
	LoginPage login;
	HomePage home;
	CartPage cart;
	
	
  @BeforeMethod
  public void launchBrowser() throws Exception {
	  
	  String rootFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", rootFolder+"//src//test//resources//chromedriver.exe");
		driver=new ChromeDriver();
		login = new LoginPage(driver);
		home = new HomePage(driver);
		cart = new CartPage(driver);
		
		propObj= new Properties();
		propObj.load(new FileInputStream(rootFolder + "//src//main//resources//myData//application.properties"));
		String appUrl = propObj.getProperty("appurl");
		driver.manage().window().maximize(); 
		driver.get(appUrl);
		Thread.sleep(5000);
  }
  
   
  @Test
  public void Scenario2() throws Exception, IOException {
	  String rootFolder = System.getProperty("user.dir");
	  propObj= new Properties();
	  propObj.load(new FileInputStream(rootFolder + "//src//main//resources//myData//application.properties"));
	  String gmail = propObj.getProperty("appUseremailId");
	  String password = propObj.getProperty("appPwd");
	  login.enterGmail(gmail);
	  login.enterPassword(password);
	  login.loginButton();
	  String expected = "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra";
	  String actual = driver.getTitle();
	Assert.assertEquals(actual, expected,"page not loaded");
	  Thread.sleep(1500);
	  driver.quit();

  }
  @Test
  public void Scenario4() throws Exception, IOException {
	  String rootFolder = System.getProperty("user.dir");
	  propObj= new Properties();
	  propObj.load(new FileInputStream(rootFolder + "//src//main//resources//myData//application.properties"));
	  String gmail = propObj.getProperty("appUseremailId");
	  String password = propObj.getProperty("appPwd");
	  login.enterGmail(gmail);
	  login.enterPassword(password);
	  login.loginButton();
	  home.enterBag();
	  cart.checkBag();
	  WebElement checkBag= driver.findElement(By.xpath("//span[@data-reactid='910']"));
	  String number = checkBag.getText();
	  Assert.assertNotEquals(number, "0", "Cart is still empty");
	  Thread.sleep(1500);
	  driver.quit();
	  
	  
  }
  

}
