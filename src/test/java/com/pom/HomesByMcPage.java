package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomesByMcPage {
	
	@FindBy(partialLinkText="SHOP ")
	private WebElement shopBlankets;
	
//	@FindBy(xpath="//*[@id=\"shopify-section-template--24170044817696__f5d600e7-2318-4f2d-b585-c88a7b57e3b3\"]/section/div/image-with-text/div/div/div[6]/div/image-with-text-item/div/div/a/text()")
//	private WebElement shopBlankets;
//	
	public HomesByMcPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void shopBlankets() {
		shopBlankets.click();
	}
}
