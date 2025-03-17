package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductStolePage {
	
	@FindBy(xpath="(//a[@data-tippy-content='Add to Wishlist'])[1]")
	private WebElement addToWishlist;
	
	@FindBy(id="flits_email_id")
	private WebElement popEmail;
	
	@FindBy(xpath="//button[contains(text(),'Add to Wishlist')]")
	private WebElement popAddToWishlist;
	
	@FindBy(xpath="//span[contains(text(),'Wishlist')]")
	private WebElement goToWishlist;
	
	@FindBy(xpath="//p[@class='flits-tingle-modal-popup-tagline-text']")
	private WebElement popText;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement popLoginBtn;
	
	public ProductStolePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void addToWishlist() {
		addToWishlist.click();
	}
	
	public void popEmail(String email) {
		popEmail.sendKeys(email);
	}
	
	public void popAddToWishlist() {
		popAddToWishlist.click();
	}
	
	public String popText() {
		return popText.getText();
	}
	
	public void goToWishlist() {
		goToWishlist.click();
	}
	
	public void popLoginBtn() {
		popLoginBtn.click();
	}
}
