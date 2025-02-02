package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {
	
	@FindBy(xpath="//li[@data-item-title='HOME FURNISHING']")
	private WebElement homeFSection;
	
	@FindBy(partialLinkText="AC Comforter")
	private WebElement acComforter;
	
	@FindBy(xpath="//a[contains(@aria-label,'Search')]")
	private WebElement searchBoxCl;
	
	@FindBy(xpath="//input[contains(@aria-label,'Search')]")
	private WebElement searchBox;
	
	@FindBy(xpath="//span[contains(text(),'Cotton')]")
	private WebElement handTowel;
	
	@FindBy(xpath="//a[text()='MEN']")
	private WebElement menSection;
	
	@FindBy(xpath="//a[contains(text(),'WOMEN')]")
	private WebElement womenSection;
	
	@FindBy(xpath="//img[@alt='women coat']")
	private WebElement womenImg;
	
	@FindBy(xpath="//span[contains(text(),'Hooded Full Sleeve Jacket')]")
	private WebElement whJacket;
	
	@FindBy(xpath="(//span[@class='header__logo'])[3]")
	private WebElement homesByMc;
	
	@FindBy(xpath="(//a[@aria-label='Cart'])[2]")
	private WebElement cartCl;

	@FindBy(xpath="//a[text()='Start shopping']")
	private WebElement cartStrtShopping;
	
	@FindBy(id="order-note-toggle")
	private WebElement addEditNote;
	
	@FindBy(id="cart[note]")
	private WebElement cartNote;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveButton;
	
	@FindBy(xpath="//img[@alt='Monte Carlo logo']")
	private WebElement mcLogo;

	
	public WebElement getWomenSection() {
		return womenSection;
	}

	@FindBy(partialLinkText="Round Neck Sweaters")
	private WebElement rnSweaters;
	

	@FindBy(xpath="//h3[text()='Addresses']")
	private WebElement addressAcc;
	
	@FindBy(xpath="//button[@title='Close']")
	private WebElement closeBtn;
	
	public WebElement getMenSection() {
		return menSection;
	}

	public WebElement getHomeFSection() {
		return homeFSection;
	}
	
	public AccountsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void acComforter() {
		acComforter.click();
	}
	
	public void searchBoxCl() {
		searchBoxCl.click();
	}
	
	public void searchBox(String productName) {
		searchBox.sendKeys(productName);
	}
	
	public void handTowel() {
		handTowel.click();
	}

	public void rnSweaters() {
		rnSweaters.click();
	}
	
	public void whJacket() {
		whJacket.click();
	}
	
	public void homesByMc() {
		homesByMc.click();
	}

	public void addressAcc() {
		addressAcc.click();
	}
	
	public void cartCl() {
		cartCl.click();
	}

	public void cartStrtShopping() {
		cartStrtShopping.click();
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
	
	public void mcLogo() {
		mcLogo.click();
	}
	
}
