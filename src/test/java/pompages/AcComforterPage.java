package pompages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.BaseClass;

public class AcComforterPage extends BaseClass{
	
	@FindBy(xpath="//button[text()='Size']")
	private WebElement size;
	
	@FindBy(xpath="//label[contains(text(),'Single ')]")
	private WebElement sizeSingle;
	
	@FindBy(xpath="//button[text()='Color']")
	private WebElement color;
	
	@FindBy(xpath="//label[contains(@style,'background-color: pink')]")
	private WebElement colorPink;
	
	@FindBy(xpath = "//li[contains(@class,'predictive-search__product')]")
	private List<WebElement> searchedProducts;
	
	@FindBy(xpath="//button[text()='Brand']")
	private WebElement brand;
	
	@FindBy(xpath="//label[contains(text(),'Monte Carlo')]")
	private WebElement brandMC;
	
	@FindBy(xpath="//button[text()='Availability']")
	private WebElement availability;
	
	@FindBy(xpath="//label[contains(text(),'In stock ')]")
	private WebElement availabilityInStock;
	
	@FindBy(xpath="//a[contains(text(),'Bed Comforter')]")
	private WebElement productA;
	
	@FindAll({@FindBy(xpath = "//product-item[@class=\"product-item  hhh Byee\"]//div[@class=\"title-wish\"]//a"),})
	private List<WebElement> products;
	
	@FindBy(xpath="//product-item[@class='product-item  hhh Byee']")
	private WebElement productss;
	
	// choose product by index
	@FindBy(xpath = "//div[@id='facet-main']//product-item[@class='product-item  hhh Byee']")
	private List<WebElement> listOfProducts;
	
	public AcComforterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void size(WebDriver driver) {
		webDriverUtilities.waitElement(size, driver);
		size.click();
	}
	
	public void sizeSingle(WebDriver driver) {
		webDriverUtilities.waitElement(sizeSingle, driver);
		sizeSingle.click();
	}
	
	public void color(WebDriver driver) {
		webDriverUtilities.waitElement(color, driver);
		color.click();
	}
	
	public void colorPink(WebDriver driver) {
		webDriverUtilities.waitElement(colorPink, driver);
		colorPink.click();
	}
	
	public void brand(WebDriver driver) {
		webDriverUtilities.waitElement(brand, driver);
		brand.click();
	}
	
	public void brandMC(WebDriver driver) {
		webDriverUtilities.waitElement(brandMC, driver);
		brandMC.click();
	}
	
	public void availability(WebDriver driver) {
		webDriverUtilities.waitElement(availability, driver);
		availability.click();
	}
	
	public void availabilityInStock(WebDriver driver) {
		webDriverUtilities.waitElement(availabilityInStock, driver);
		availabilityInStock.click();
	}
	
	public void product(WebDriver driver) {
		webDriverUtilities.waitElement(productA, driver);
		productA.click();
	}
	
	public WebElement getSize() {
		return size;
	}

	public WebElement getSizeSingle() {
		return sizeSingle;
	}

	public WebElement getColor() {
		return color;
	}

	public WebElement getColorPink() {
		return colorPink;
	}

	public WebElement getBrand() {
		return brand;
	}

	public WebElement getBrandMC() {
		return brandMC;
	}

	public WebElement getAvailability() {
		return availability;
	}

	public WebElement getAvailabilityInStock() {
		return availabilityInStock;
	}

	public WebElement getProduct() {
		return productA;
	}
	
//	public void selectSearchSuggestedProducts(int index, WebDriver driver) throws FileNotFoundException, IOException  {
//		for (int i = 1; i < products.size(); i++) {
//			WebElement product = driver.findElement(By.xpath("(//li[contains(@class,'predictive-search__product')])["
//					+ i + "]//div[@class='line-item__info']//span"));
//			webDriverUtilities.waitElement(product, driver);
//			String productName = product.getText();
//			dataUtilities.writePropertyFile("productName", productName);
//			product.click();
//		}
//	}
	
	public void selectTheProduct(int index, WebDriver driver) throws FileNotFoundException, IOException {
		
		//XPATH : (//a[contains(text(),'Bed Comforter for AC Room')])[1]
		webDriverUtilities.waitRefreshed(listOfProducts, driver);
		WebElement product = driver.findElement(By.xpath("(//a[contains(text(),'Bed Comforter for AC Room')])["+index+"]"));
		webDriverUtilities.scrollOnElement(product, driver);
		webDriverUtilities.waitElement(product, driver);
		String productName = product.getText();
		dataUtilities.writePropertyFile("productName", productName);
		webDriverUtilities.waitElement(product, driver);
		product.click();
	}
	
	public String textOfSelectedProduct(int index, WebDriver driver) throws FileNotFoundException, IOException {
		
		WebElement p = driver.findElement(By.xpath("(//product-item[@class='product-item  hhh Byee'])["+index+"]//div[3]/div/div[1]//a"));
		webDriverUtilities.waitElement(p, driver);
		String product_Name = p.getText();
		return product_Name;	 	
	}
	
	public void selectAnyProduct(int index, WebDriver driver) throws FileNotFoundException, IOException {
		
		//XPATH : (//div[@id='facet-main']//product-item[@class='product-item  hhh Byee'])[1]//div[@class='title-wish']/a
		webDriverUtilities.waitRefreshed(listOfProducts, driver);
		WebElement product = driver.findElement(By.xpath("(//div[@id='facet-main']//product-item[@class='product-item  hhh Byee'])["+index+"]//div[@class='title-wish']/a"));
		webDriverUtilities.scrollOnElement(product, driver);
		webDriverUtilities.waitElement(product, driver);
		String productName = product.getText();
		dataUtilities.writePropertyFile("productNameTC1", productName);
		product.click();
	}
	
	public void selectProduct(int index, WebDriver driver) throws FileNotFoundException, IOException {
		
		//XPATH : //product-item[@class='product-item  hhh Byee'])[1]
		webDriverUtilities.waitRefreshed(listOfProducts, driver);
		WebElement p = driver.findElement(By.xpath("(//product-item[@class='product-item  hhh Byee'])["+index+"]"));
		webDriverUtilities.waitElement(p, driver);
		String product_Name = p.getText();
		dataUtilities.writePropertyFile("productName", product_Name);
		webDriverUtilities.waitElementClick(p, driver);
		p.click();	
	}
}
