package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CollectionsAll {
	
	@FindBy(xpath="(//button[@is='toggle-button'])[5]")
	private WebElement filterDate;

	@FindBy(xpath="//span[text()='Date, old to new']")
	private WebElement oldToNew;
	
	@FindBy(xpath="//span[text()='Price, high to low']")
	private WebElement highToLow;
	
	@FindBy(xpath="(//a[contains(text(),'Womens ')])[2]")
	private WebElement secondProduct;
	
	@FindBy(xpath="(//a[contains(text(),' Cotton')])[10]")
	private WebElement productTC10;
	
	public CollectionsAll(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void filterDate() {
		filterDate.click();
	}
	
	public void oldToNew() {
		oldToNew.click();
	}
	
	public void highToLow() {
		highToLow.click();
	}
	
	public void secondProduct() {
		secondProduct.click();
	}
	
	public void productTC10() {
		productTC10.click();
	}

}
