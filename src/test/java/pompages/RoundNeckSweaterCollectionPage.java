package pompages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.BaseClass;

public class RoundNeckSweaterCollectionPage extends BaseClass{

	@FindBy(xpath="//button[contains(text(),'Size')]")
	private WebElement size;
	
	@FindBy(xpath="//label[contains(text(),'38/M')]")
	private WebElement sizeSelect;
	
	@FindBy(xpath="//button[contains(text(),'Brand')]")
	private WebElement brand;
	
	@FindBy(xpath="//label[contains(text(),'Rock.it ')]")
	private WebElement brandRock;
	
	@FindBy(xpath="//button[contains(text(),'Sleeve')]")
	private WebElement sleeve;
	
	@FindBy(xpath="//label[contains(text(),'Full Sleeve ')]")
	private WebElement sleeveFull;
	
	@FindBy(xpath="(//product-item[@class='product-item  hhh Byee'])[3]")
	private WebElement thirdProduct;
	
	public RoundNeckSweaterCollectionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void size(WebDriver driver) {
		webDriverUtilities.waitElement(size, driver);
		size.click();
	}
	
	public void sizeSelect(WebDriver driver) {
		webDriverUtilities.waitElement(sizeSelect, driver);
		sizeSelect.click();
	}
	
	public void brand(WebDriver driver) {
		webDriverUtilities.waitElement(brand, driver);
		brand.click();
	}
	
	public void brandRock(WebDriver driver) {
		webDriverUtilities.waitElement(brandRock, driver);
		brandRock.click();
	}
	
	public void sleeve(WebDriver driver) {
		webDriverUtilities.waitElement(sleeve, driver);
		sleeve.click();
	}
	
	public void sleeveFull(WebDriver driver) {
		webDriverUtilities.waitElement(sleeveFull, driver);
		sleeveFull.click();
	}
	
	public void thirdProduct(WebDriver driver) {
		webDriverUtilities.waitElement(thirdProduct, driver);
		thirdProduct.click();
	}

	public WebElement getSize() {
		return size;
	}

	public WebElement getSizeSelect() {
		return sizeSelect;
	}

	public WebElement getBrand() {
		return brand;
	}

	public WebElement getBrandRock() {
		return brandRock;
	}

	public WebElement getSleeve() {
		return sleeve;
	}

	public WebElement getSleeveFull() {
		return sleeveFull;
	}

	public WebElement getThirdProduct() {
		return thirdProduct;
	}
	
	public void selectProduct(int index, WebDriver driver) throws FileNotFoundException, IOException {
		//for(int i=1;i<products.size();i++)
		
		WebElement p = driver.findElement(By.xpath("(//a[contains(text(),'Solid Round Neck Full Sleeve')])["+index+"]"));
		webDriverUtilities.waitElement(p, driver);
		String product_Name = p.getText();
		dataUtilities.writePropertyFile("productName", product_Name);
		webDriverUtilities.waitElementClick(p, driver);
		p.click();	
	}
	
	public String textOfSelectedProduct(int index, WebDriver driver) throws FileNotFoundException, IOException {
		WebElement p = driver.findElement(By.xpath("//product-item[@class='product-item  hhh Byee']["+index+"]//div[3]/div/div[1]//a"));
		webDriverUtilities.waitElement(p, driver);
		String productNameTC3 = p.getText();
		return productNameTC3;	 	
	}
	
	public void selectTheProduct(int index, WebDriver driver) throws FileNotFoundException, IOException {
		
		//XPATH : //product-item[@class='product-item  hhh Byee'][3]
		WebElement product = driver.findElement(By.xpath("(//product-item[@class='product-item  hhh Byee'])["+index+"]"));
		webDriverUtilities.scrollOnElement(product, driver);
		webDriverUtilities.waitElement(product, driver);
		String productNameTC3 = product.getText();
		dataUtilities.writePropertyFile("productNameTC3", productNameTC3);
		webDriverUtilities.waitElement(product, driver);
		product.click();
	}
	
}
