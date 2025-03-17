package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductBedSheetPage {

	@FindBy(xpath="//a[contains(@class,'flits-wls-button')]")
	private WebElement addWishlist;
	
	@FindBy(xpath="//span[contains(text(),'Wishlist')]")
	private WebElement goToWishlist;
	
	public ProductBedSheetPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void addWishlist() {
		addWishlist.click();
	}
	
	public void goToWishlist() {
		goToWishlist.click();
	}
}
