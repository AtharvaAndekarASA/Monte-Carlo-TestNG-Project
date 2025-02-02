package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {
	
	@FindBy(xpath="//button[text()='Add to Cart']")
	private WebElement addToCart;
	
	@FindBy(xpath="//p[contains(text(),'Cotton')]")
	private WebElement wishlistHandTowel;
	
	@FindBy(xpath="//button[@class='flits-button flits-primary-btn flits-remove-product']")
	private WebElement closeButton;
	
	@FindBy(xpath="//p[contains(text(),'TC Cotton')]")
	private WebElement bedSheetVerify;
	
	public WebElement getWishlistHandTowel() {
		return wishlistHandTowel;
	}

	public WishlistPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void addToCart() {
		addToCart.click();
	}	
	
	public void closeButton() {
		closeButton.click();
	}
	
	public String bedSheetVerify() {
		return bedSheetVerify.getText();
	}
}
