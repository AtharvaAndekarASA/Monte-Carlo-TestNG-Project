/* 
 TEST-CASE NO.9 Adding a note to product in Wishlist or Cart
 
1.Open the browser
2.Maximize the browser                     
3.Enter the Url
4.Click on Login
5.Enter Username and password
6.Verify the homepage 
7.Click on cart
8.Click on start Shopping
9.Select Filters : Date Old to New
10.Click on the Product
11.Click on add to cart
12.Click on add/Edit Order Note
13.Enter the desired text 
14.Click on save
15.Click on Close Button.

*/

package testscript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pompages.AccountsPage;
import pompages.CollectionsAll;
import pompages.LoginPage;
import pompages.MonteCarloHomePage;
import pompages.ProductTC9SecondProduct;

public class TC_09_AddToWhishLlistAndCart
 extends BaseClass{
	
	Logger lr = LogManager.getLogger(TC_09_AddToWhishLlistAndCart.class);
	@Test
	public void TestCase09_AddToWhishLlistAndCart() throws IOException, Exception {
		
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
		
		//Click on cart
		acp.cartCl();
		lr.info("Clicked on cart");		
		
		//Click on Start Shopping
		acp.cartStrtShopping();
		lr.info("Clicked on start shopping");
		
		CollectionsAll ca = new CollectionsAll(driver);
		
		//Select Filters : Date
		ca.filterDate();
		lr.info("Selected the date filter");
		
		//Select Filters : Date-Old to New
		ca.oldToNew();
		lr.info("Select on the Old to New filter");
		
		//Click on the Product
		ca.secondProduct();
		lr.info("Select the second product");
		
		ProductTC9SecondProduct pscp = new ProductTC9SecondProduct(driver);
		
		//Click on Add to cart
		pscp.addToCart();
		lr.info("Clicked on add to cart");
		
		//Click on Add/Edit Order Note
		WebElement editnote =  pscp.getAddEditNote();
		webDriverUtilities.waitElement(editnote, driver);
		pscp.addEditNote();
		lr.info("Clicked on Add Note");
		
		//Enter the desired text 
		WebElement cartnote =  pscp.getCartNote();
		webDriverUtilities.waitElement(cartnote, driver);
		pscp.cartNote(dataUtilities.readingDataPropertyFile("note"));
		lr.info("Entered the note");
		
		//Click on save
		WebElement save =  pscp.getSaveButton();
		webDriverUtilities.waitElement(save, driver);
		pscp.saveButton();
		lr.info("Clicked the save button");
		
		//Click on Close Button.
		WebElement close =  pscp.getCloseBtn();
		webDriverUtilities.waitElement(close, driver);
		pscp.closeBtn();	
		lr.info("Clicked the close button");
				
	}
}
