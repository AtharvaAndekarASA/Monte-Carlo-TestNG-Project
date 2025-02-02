package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductWomensJacket {
	
	@FindBy(xpath="//label[contains(text(),'36/M')]")
	private WebElement size;
	
	@FindBy(xpath="(//button[@class='quantity-selector__button'])[2]")
	private WebElement increaseQuantity;
	
	@FindBy(id="AddToCart")
	private WebElement addToCart;

	@FindBy(xpath="//a[text()='Women Maroon Solid Hooded Full Sleeve Jacket']")
	private WebElement cartProduct;
	
	@FindBy(xpath="//button[@name='checkout']")
	private WebElement initiateBtn;

	public ProductWomensJacket(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public void size() {
		size.click();
	}

	public void increaseQuantity() {
		increaseQuantity.click();
	}

	public void addToCart() {
		addToCart.click();
	}

	public void cartProduct() {
		cartProduct.getText();
	}
	
	public void initiateBtn() {
		initiateBtn.click();
	}

}
