package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsBlanket {
	@FindBy(xpath="//span[@class='ft__']")
	private WebElement productDetails;
	
	@FindBy(xpath="//p[contains(text(),'Fashions Limited Unit-4')]")
	private WebElement address; //getText
	
	@FindBy(linkText="Our Stores")
	private WebElement ourStores;
	
	public ProductsBlanket(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void productDetails() {
		productDetails.click();
	}
	
	public String address() {
		return address.getText();
	}
	
	public void ourStores() {
		ourStores.click();
	}
	
}
