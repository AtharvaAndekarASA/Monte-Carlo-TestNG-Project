package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {

	@FindBy(xpath="//button[contains(text(),'Add a new ')]")
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

	@FindBy(xpath="//p[contains(text(),'newly Added address')]")
	private WebElement addressVerify;
	
	@FindBy(xpath="(//button[text()='Delete'])[2]")
	private WebElement deleteaddress;
	
	@FindBy(xpath="//span[text()='Default address']//parent::div//div[2]//form")
	private WebElement deleteDefaultAddress;
	
	@FindBy(xpath="//p[contains(text(),'Default')]")
	private WebElement defaultaddress;
	
	@FindBy(id="address-new[default]")
	private WebElement setDefault;
	
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
	
	public void deleteDefaultAddress() {
		deleteDefaultAddress.click();
	}
	
	public void setDefault() {
		setDefault.click();
	}

	public WebElement getAddNewAddress() {
		return addNewAddress;
	}

	public WebElement getAddressFname() {
		return addressFname;
	}

	public WebElement getAddressLname() {
		return addressLname;
	}

	public WebElement getAddressAddress() {
		return addressAddress;
	}

	public WebElement getAddressZip() {
		return addressZip;
	}

	public WebElement getAddressAdd() {
		return addressAdd;
	}

	public WebElement getAddressVerify() {
		return addressVerify;
	}

	public WebElement getDeleteaddress() {
		return deleteaddress;
	}

}
