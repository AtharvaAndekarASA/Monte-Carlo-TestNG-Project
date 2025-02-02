package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreLocatorPage {
	
	@FindBy(id="searchInput")
	private WebElement searchPincode;
	
	@FindBy(xpath="//a[@class='directions-btn']")
	private WebElement getDirections;

	public StoreLocatorPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void searchPincode(String pcode) {
		searchPincode.sendKeys(pcode);
	}
	
	public void getDirections() {
		getDirections.click();
	}


}
