package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductTC9SecondProduct {
	
	@FindBy(id="AddToCart")
	private WebElement addToCart;
	
	@FindBy(xpath="//button[@title='Close']")
	private WebElement closeBtn;
	
	@FindBy(id="order-note-toggle")
	private WebElement addEditNote;
	
	@FindBy(id="cart[note]")
	private WebElement cartNote;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveButton;
	
	public ProductTC9SecondProduct(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void addToCart() {
		addToCart.click();
	}
	
	public void addEditNote() {
		addEditNote.click();
	}
	
	public void cartNote(String note) {
		cartNote.sendKeys(note);
	}
	
	public void saveButton() {
		saveButton.click();
	}
	
	public void closeBtn() {
		closeBtn.click();
	}

}
