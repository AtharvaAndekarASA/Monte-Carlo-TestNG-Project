package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomensPage {
	
	@FindBy(xpath="//*[@id=\"shopify-section-template--24170044031264__c29bfcea-d30e-4c65-986d-878a5f6594b5\"]/div/div/div/div/div[5]/a/img")
	private WebElement stoleImg;
	
	public WomensPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void stoleImg() {
		stoleImg.click();
	}

}
