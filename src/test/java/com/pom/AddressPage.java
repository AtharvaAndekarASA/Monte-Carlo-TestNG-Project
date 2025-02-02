package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {

	@FindBy(xpath="(//button[@is='toggle-button'])[5]")
	private WebElement addNewAddress;

	@FindBy(id="address-new[first_name]")
	private WebElement addressFname;

	@FindBy(id="address-new[last_name]")
	private WebElement addressLname;

	@FindBy(id="address-new[address1]")
	private WebElement addressAddress;

	@FindBy(id="address-new[zip]")
	private WebElement addressZip;	

	@FindBy(xpath="//button[@is='loader-button']")
	private WebElement addressAdd;

	@FindBy(xpath="//span[text()='Address 2']")
	private WebElement addressVerify;
	
	@FindBy(xpath="(//button[text()='Delete'])[2]")
	private WebElement deleteaddress;
	
	public AddressPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void addNewAddress() {
		addNewAddress.click();
	}
	
	public void addressFname(String Fname) {
		addressFname.sendKeys(Fname);
	}
	
	public void addressLname(String Lname) {
		addressLname.sendKeys(Lname);
	}
	
	public void addressAddress(String addressReal) {
		addressAddress.sendKeys(addressReal);
	}
	
	public void addressZip(String pcode) {
		addressZip.sendKeys(pcode);
	}
	
	public void addressAdd() {
		addressAdd.click();
	}
	
	public String addressVerify() {
		return addressVerify.getText();
	}
	
	public void deleteaddress() {
		deleteaddress.click();
	}

}
