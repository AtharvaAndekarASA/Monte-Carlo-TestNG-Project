package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonteCarloHomePage {
	
	@FindBy(xpath="//span[contains(text(),'Login/Signup')]")
	private WebElement loginBtn;
	
	@FindBy(linkText="WOMEN")
	private WebElement womenSection;
	
	@FindBy(xpath="//button[text()='New Arrival']")
	private WebElement newArrival;
	
	@FindBy(xpath="(//button[@class='product-list__arrow prev-next-button prev-next-button--next'])[2]")
	private WebElement nextArrow;

	@FindBy(xpath="(//product-item[@class='product-item  hhh Byee'])[7]")
	private WebElement nextArrowProduct;

	@FindBy(xpath="//span[text()='Quick view']")
	private WebElement quickview;
	
	@FindBy(xpath="(//button[@class='quantity-selector__button'])[2]")
	private WebElement increaseQuantity;
	
	@FindBy(xpath="//a[text()='View details']")
	private WebElement viewDetails;
	
	public MonteCarloHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void loginBtn() {
		loginBtn.click();
	}
	
	public void womenSection() {
		womenSection.click();
	}
	
	public void newArrival() {
		newArrival.click();
	}
	
	public void nextArrow() {
		nextArrow.click();
	}
	
	public WebElement getNextArrowProduct() {
		return nextArrowProduct;
	}

	public void nextArrowProduct() {
		nextArrowProduct.click();
	}
	
	public void quickview() {
		quickview.click();
	}
	
	public void increaseQuantity() {
		increaseQuantity.click();
	}
	
	public void viewDetails() {
		viewDetails.click();
	}
	
}

