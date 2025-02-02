package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductRoundNeckTshirt {
	@FindBy(id="pincode")
	private WebElement pincodeBox;
	
	@FindBy(id="check-pincode")
	private WebElement chckpincodeBox;
	
	public ProductRoundNeckTshirt(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void pincodeBox(String pcode) {
		pincodeBox.sendKeys(pcode);
	}
	
	public void chckpincodeBox() {
		chckpincodeBox.click();
	}
}
