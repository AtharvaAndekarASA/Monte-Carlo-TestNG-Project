package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductTCten {
	
	@FindBy(xpath="(//a[@data-tippy-content='Add to Wishlist'])[1]")
	private WebElement addToWishlist;
	
	@FindBy(xpath="//span[contains(text(),'Wishlist')]")
	private WebElement goToWishlist;
	
	public ProductTCten(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void addToWishlist() {
		addToWishlist.click();
	}
	
	public void goToWishlist() {
		goToWishlist.click();
	}
}
