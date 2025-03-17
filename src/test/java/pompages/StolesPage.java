package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StolesPage {
	
	@FindBy(xpath="(//input[@aria-label=\"From price\"])[2]")
	private WebElement lowValueprice;
	
	@FindBy(xpath="(//input[@aria-label=\"To price\"])[2]")
	private WebElement highValueprice;
	
	@FindBy(xpath="//a[text()='Reset filters']")
	private WebElement reset;
	
	@FindBy(xpath="//a[contains(text(),' Design Stole')]")
	private WebElement productStole;

	public StolesPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void lowValueprice(String lValue) {
		lowValueprice.sendKeys(lValue);
	}
	
	public void highValueprice(String hValue) {
		highValueprice.sendKeys(hValue);
	}
	
	public void reset() {
		reset.click();
	}
	
	public void productStole() {
		productStole.click();
	}
}
