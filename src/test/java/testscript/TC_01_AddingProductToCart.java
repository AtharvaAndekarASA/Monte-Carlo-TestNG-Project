/* 
 TEST-CASE NO.1 Adding Product to Wishlist, Cart and verifying the product

1-launch browser
2-enter application url-https://www.montecarlo.in/
3-click on Login/Signup icon
4-enter email address
5-enter password
6-click on  login
7-verify you are in AccountPage.
8-Mouse over on Home Furnishing
9-click on  AC Comforter
10.click on size and select the size
11-Scroll down click on color and select the colour
12-Scroll down click on brand and select the brand of item
13-Scroll down click on availability and choose in stock
14-Click on any product and click add to wishlist.
15-click on wishlist button
16-verify you are in wishlist page
17-Verify the item is added to wishlist or not.
18-if the item present in the wishlist,click on add to cart.
19-click on add to cart icon
20-verify the item is  added  to cart 
21-close the application.

*/

package testscript;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import pompages.AcComforterPage;
import pompages.AccountsPage;
import pompages.LoginPage;
import pompages.MonteCarloHomePage;
import pompages.ProductBedSheetPage;
import pompages.WishlistPage;

public class TC_01_AddingProductToCart extends BaseClass{

	Logger lr = LogManager.getLogger(TC_01_AddingProductToCart.class);
	
	@Test
	public void TestCase01_AddingProductToCart() throws IOException, Exception {
		
		//Verify you are in Home Page.
		String homepageTitle = dataUtilities.readingDataPropertyFile("homepagetitle");
		assertEquals(driver.getTitle(), homepageTitle);
		
		MonteCarloHomePage mchp = new MonteCarloHomePage(driver);
		
		//Click on Login/Signup icon
		mchp.loginBtn();
		lr.info("Sign in clicked");
		
		LoginPage lp = new LoginPage(driver);
		
		//Enter email address
		lp.username(dataUtilities.readingExcelSheetFile("Sheet1",1,1));
		lr.info("Username entered");
		
		//Enter password
		lp.password(dataUtilities.readingExcelSheetFile("Sheet1",1,2));
		lr.info("Password entered");
		
		//Click on Login
		lp.login();
		lr.info("Login clicked");
		
		//Verify you are in Accounts Page.
		String accountpageTitle = dataUtilities.readingDataPropertyFile("accountpageTitle");
		assertEquals(driver.getTitle(), accountpageTitle);	
		
		AccountsPage ap = new AccountsPage(driver);
		
		//Mouse over on Home Furnishing
		WebElement mo = ap.getHomeFSection();
		webDriverUtilities.mouseHover(mo,driver);
		lr.info("Mouse hovered on Home Furnishing section");
		
		//Click on  AC Comforter
		ap.acComforter();
		lr.info("AC Comforter clicked");
		
		AcComforterPage acp = new AcComforterPage(driver);
		
		//Click on size
		WebElement s =  acp.getSize();
		webDriverUtilities.waitElementClick(s, driver);
		acp.size(driver);
		lr.info("Size option clicked ");
		
		//Select the size
		WebElement ss =  acp.getSizeSingle();
		webDriverUtilities.waitElementClick(ss, driver);
		acp.sizeSingle(driver);
		lr.info("Size single selected");
		
		//Click on color
		WebElement cl =  acp.getColor();
		webDriverUtilities.waitElementClick(cl, driver);
		acp.color(driver);
		lr.info("Color clicked");
		
		//Select the color
		WebElement clpnk =  acp.getColorPink();
		webDriverUtilities.waitElementClick(clpnk, driver);
		acp.colorPink(driver);
		lr.info("Pink Color selected");
		
		//Click on brand
		WebElement b =  acp.getBrand();
		webDriverUtilities.waitElementClick(b, driver);
		acp.brand(driver);
		lr.info("Brand clicked");
		
		//Select the brand
		WebElement bmc =  acp.getBrandMC();
		webDriverUtilities.waitElementClick(bmc, driver);
		acp.brandMC(driver);
		lr.info("Monte Carlo selected");
		
		//Click on availabaility
		WebElement av =  acp.getAvailability();
		webDriverUtilities.waitElementClick(av, driver);
		acp.availability(driver);
		lr.info("Availaibility clicked");
		
		//Select the availability
		WebElement avin =  acp.getAvailabilityInStock();
		webDriverUtilities.waitElementClick(avin, driver);
		acp.availabilityInStock(driver);
		lr.info("In stock avaialability selected");
		
		String productText = acp.textOfSelectedProduct(2, driver);
		
		//Click on the product
		acp.selectTheProduct(2, driver);
		lr.info("Product selected");
		
		ProductBedSheetPage pbsp = new ProductBedSheetPage(driver);
		
		//Click on add to wishlist
		pbsp.addWishlist();
		lr.info("Added to wishlist");
		
		//Click on wishlist button
		pbsp.goToWishlist();
		lr.info("Navigate to wishlist page");
		
		//verify you are in wishlist page
		String wishlistPageTitle = dataUtilities.readingDataPropertyFile("wishlistTitle");
		assertEquals(driver.getTitle(), wishlistPageTitle);
	    
		WishlistPage wlsp = new WishlistPage(driver);
		
		//Verify the item is added to wishlist or not.
		SoftAssert wshlst = new SoftAssert();
		wshlst.assertEquals(productText, dataUtilities.readingDataPropertyFile("productName"));
		
		//Click on add the product to cart
		WebElement act =  wlsp.getAddToCart();
		webDriverUtilities.waitElement(act, driver);
		wlsp.addToCart();
		lr.info("Add to cart");		
		
		//Verify the item is added to cart or not.
		SoftAssert crt = new SoftAssert();
		crt.assertEquals(productText, dataUtilities.readingDataPropertyFile("productName"));
		crt.assertAll();
	}
}
