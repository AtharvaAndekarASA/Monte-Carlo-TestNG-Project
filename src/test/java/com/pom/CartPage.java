package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	@FindBy(id="order-note-toggle")
	private WebElement addEditNote;
	
	@FindBy(xpath="//textarea[@is='cart-note']")
	private WebElement cartNote;
	
	@FindBy(xpath="//button[@name='checkout']")
	private WebElement initiateCheckout;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void addEditNote() {
		addEditNote.click();
	}
	
	public void cartNote(String note) {
		cartNote.sendKeys(note);
	}
	
	public void initiateCheckout() {
		initiateCheckout.click();
	}

	
}
