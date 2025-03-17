package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductTCeleven {
	
	@FindBy(xpath="//h1[text()='Men Olive Solid Sweatshirt']")
	private WebElement productName;
	
	public ProductTCeleven(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public String productName() {
		return productName.getText();
	}
}
