package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlanketsPage {
	
	@FindBy(xpath="//a[contains(text(),'Printed Double Bed')]")
	private WebElement productBlanket;

	public BlanketsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void productBlanket() {
		productBlanket.click();
	}
	
}
