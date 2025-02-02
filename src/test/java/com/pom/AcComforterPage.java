package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcComforterPage {
	
	@FindBy(xpath="//button[text()='Size']")
	private WebElement size;
	
	@FindBy(xpath="//label[contains(text(),'Single ')]")
	private WebElement sizeSingle;
	
	@FindBy(xpath="//button[text()='Color']")
	private WebElement color;
	
	@FindBy(id="filter.p.m.custom.color-7")
	private WebElement colorPink;
	
	@FindBy(xpath="//button[text()='Brand']")
	private WebElement brand;
	
	@FindBy(xpath="//label[contains(text(),'Monte Carlo')]")
	private WebElement brandMC;
	
	@FindBy(xpath="//button[text()='Availability']")
	private WebElement availability;
	
	@FindBy(xpath="//label[contains(text(),'In stock ')]")
	private WebElement availabilityInStock;
	
	@FindBy(xpath="//a[contains(text(),'Printed Polyester ')]")
	private WebElement product;
	
	public AcComforterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void size() {
		size.click();
	}
	
	public void sizeSingle() {
		sizeSingle.click();
	}
	
	public void color() {
		color.click();
	}
	
	public void colorPink() {
		colorPink.click();
	}
	
	public void brand() {
		brand.click();
	}
	
	public void brandMC() {
		brandMC.click();
	}
	
	public void availability() {
		availability.click();
	}
	
	public void availabilityInStock() {
		availabilityInStock.click();
	}
	
	public void product() {
		product.click();
	}
}
