package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage {
	WebDriver driver;
	
	public WishlistPage(WebDriver driver){
        this.driver = driver;
    }
	public void addToBag() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='itemcard-moveToBag itemcard-boldFont']")).click();
		driver.findElement(By.xpath("//button[@class='sizeselect-sizeButton']")).click();
		driver.findElement(By.xpath("//div[@class='sizeselect-done']")).click();
		Thread.sleep(2000);
		
		
	
	}
	
}
