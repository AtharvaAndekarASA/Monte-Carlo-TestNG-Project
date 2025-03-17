/* 
 TEST-CASE NO.10 Selecting Second Autosuggestion after Verifying the product and Adding to cart
 
01. open browser
02. enter url https://www.montecarlo.in/
03. verify homepage
04. click on login/sign up
05. enter username
06. enter password
07. click login
08. click on cart
09. make sure "Your cart is empty" text is displaying
10. click start shopping.
11  click on sort by
12. select 'high to low'
13. add any product to wishlist
14. click on wishlist
15. verify if product got added to wishlist
16. add that item to cart
17. enter text in 'add order note' 
18. initiate checkout click
19. enter text bangalore and select second suggesstion
20.close the application
 
*/

package testscript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pompages.AccountsPage;
import pompages.CartPage;
import pompages.CheckoutPage;
import pompages.CollectionsAll;
import pompages.LoginPage;
import pompages.MonteCarloHomePage;
import pompages.ProductTCten;
import pompages.WishlistPage;

public class TC_10_ProductVerification extends BaseClass{
	
	Logger lr = LogManager.getLogger(TC_10_ProductVerification.class);
	@Test
	public void TestCase10_ProductVerification() throws IOException, Exception {
		
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
		lr.info("Log in clicked");
		
		//Verify you are in Accounts Page.
		String accountpageTitle = dataUtilities.readingDataPropertyFile("accountpageTitle");
		assertEquals(driver.getTitle(), accountpageTitle);
		
		AccountsPage acp = new AccountsPage(driver);
		
		//Click on Cart
		acp.cartCl();
		lr.info("Cart clicked");
		
		//Click on Start shopping
		acp.cartStrtShopping();
		lr.info("Start shopping clicked");
		
		CollectionsAll ca = new CollectionsAll(driver);
		
		//Select Filters : Date
		ca.filterDate();
		lr.info("Selected the date filter");
		
		//Select Filters : Price-High to low
		ca.highToLow();
		lr.info("Selected the high to low filter");
		
		//Select any product
		ca.productTC10();
		lr.info("Selected the product");
		
		ProductTCten ptct = new ProductTCten(driver);
		
		//Add any product to wishlist
		ptct.addToWishlist();
		lr.info("Added to wishlist");
		
		//Click on wishlist
		ptct.goToWishlist();
		lr.info("Navigated to wishlist");
		
		WishlistPage wlp = new WishlistPage(driver);
		
		//Verify if product got added to wishlist		
		String product = wlp.bedSheetVerify();
		Reporter.log(product,true);
		lr.info("Product displayed");
		
		//Add that item to cart
		if(product.equals(dataUtilities.readingDataPropertyFile("productNameTC10"))) {
			wlp.addToCart();
		}
		lr.info("Product verified and added");
		
		CartPage cp = new CartPage(driver);
		
		//Click on Add Order Note
		cp.addEditNote();
		lr.info("Clicked on add note");
		
		//Enter text in 'add order note'
		cp.cartNote(dataUtilities.readingDataPropertyFile("note"));
		lr.info("Entered the cart note");
		
		//Click initiate Checkout
		cp.initiateCheckout();
		lr.info("Clicked initiate checkout");
		
		CheckoutPage chp = new CheckoutPage(driver);
		
		//Enter text bangalore
		chp.addressInput(dataUtilities.readingDataPropertyFile("address1"));
		lr.info("Address entered : Bangalore");
		
		//Select second suggesstion
		chp.addressSecondOption();
		lr.info("Selected second auto suggestion");
		
	}
}
