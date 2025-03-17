package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id="customer[email]")
	private WebElement username;
	
	@FindBy(id="customer[password]")
	private WebElement password;
	
	@FindBy(xpath="//span[text()='Login']")
	private WebElement login;	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void username(String uName) {
		username.sendKeys(uName);
	}
	
	public void password(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void login() {
		login.click();
	}
	
}
