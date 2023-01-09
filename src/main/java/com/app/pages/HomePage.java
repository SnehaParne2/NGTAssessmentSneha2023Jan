package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
WebDriver driver;
	
	public HomePage(WebDriver driver){
        this.driver = driver;
    }
	public void enterBag() {
		driver.findElement(By.xpath("//span[.='Bag']")).click();
	}
	
}
