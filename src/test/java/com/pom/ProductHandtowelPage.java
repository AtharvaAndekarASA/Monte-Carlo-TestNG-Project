package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductHandtowelPage {
	
	@FindBy(xpath="//div[contains(@class,'filts-wishlist-product-style flits-wishlist-button-style ')]")
	private WebElement addWishlist;
	
	@FindBy(xpath="//span[contains(text(),'Wishlist')]")
	private WebElement goToWishlist;
	
	public ProductHandtowelPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void addWishlist() {
		addWishlist.click();
	}
	
	public void goToWishlist() {
		goToWishlist.click();
	}
}
