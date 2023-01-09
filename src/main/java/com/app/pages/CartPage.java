package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	WebDriver driver;
	WishlistPage wishlist;
	public CartPage(WebDriver driver){
        this.driver = driver;
    }
	public void checkBag() throws Exception {
		
		try {
			WebElement check= driver.findElement(By.xpath("//div[contains(text(), 'Hey, it feels so light!')]"));
			String text= check.getText();
		    if(text.equals("Hey, it feels so light!")) {
		    	driver.findElement(By.xpath("//div[@class='button-base-button emptyCart-base-wishlistButton ']")).click();
		    	wishlist = new WishlistPage(driver);
		    	wishlist.addToBag();
		    }
		}
		catch (NoSuchElementException e){	
			System.out.println("Cart is not empty");
		}
		
	    
	}
	
}
