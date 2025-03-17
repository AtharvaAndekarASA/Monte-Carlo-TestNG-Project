package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	@FindBy(id="shipping-address1")
	private WebElement addressInput;
	
	@FindBy(id="shipping-address1-option-1")
	private WebElement addressSecondOption;

	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void addressInput(String address) {
		addressInput.sendKeys(address);
	}
	
	public void addressSecondOption() {
		addressSecondOption.click();
	}

}
