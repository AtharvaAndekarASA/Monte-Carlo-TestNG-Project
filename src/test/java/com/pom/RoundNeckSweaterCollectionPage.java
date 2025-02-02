package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoundNeckSweaterCollectionPage {

	@FindBy(xpath="//button[contains(text(),'Size')]")
	private WebElement size;
	
	@FindBy(xpath="//label[contains(text(),'38/M')]")
	private WebElement sizeSelect;
	
	@FindBy(xpath="//button[contains(text(),'Brand')]")
	private WebElement brand;
	
	@FindBy(xpath="//label[contains(text(),'Rock.it ')]")
	private WebElement brandRock;
	
	@FindBy(xpath="//button[contains(text(),'Sleeve')]")
	private WebElement sleeve;
	
	@FindBy(xpath="//label[contains(text(),'Full Sleeve ')]")
	private WebElement sleeveFull;
	
	@FindBy(xpath="(//a[contains(text(),'Solid Round Neck Full Sleeve')])[3]")
	private WebElement thirdProduct;
	
	public RoundNeckSweaterCollectionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void size() {
		size.click();
	}
	
	public void sizeSelect() {
		sizeSelect.click();
	}
	
	public void brand() {
		brand.click();
	}
	
	public void brandRock() {
		brandRock.click();
	}
	
	public void sleeve() {
		sleeve.click();
	}
	
	public void sleeveFull() {
		sleeveFull.click();
	}
	
	public void thirdProduct() {
		thirdProduct.click();
	}
	
}
