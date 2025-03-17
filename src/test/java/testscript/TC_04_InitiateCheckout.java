/* 
 TEST-CASE NO.4 Searching for Women's Jacket product, increasing quantity and initiating checkout
 
1.Open the browser
2.Maximize the browser
3.Enter the url                                                             
4.click on signin
5.Enter the username
6.Enter the password
7.click on login
8.click on search bar and search for women hooded jackets                                            9.click on view all results
9.click on any product
10.select the size
11.Increase the quantity to 2
12.Add the product to cart
13.intiate checkout
14.close the application.
 
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
import pompages.LoginPage;
import pompages.MonteCarloHomePage;
import pompages.ProductWomensJacket;

public class TC_04_InitiateCheckout extends BaseClass{
	
	Logger lr = LogManager.getLogger(TC_04_InitiateCheckout.class);
	@Test
	public void TestCase04_InitiateCheckout() throws IOException, Exception {
		
		//Verify you are in Home Page.
		String homepageTitle = dataUtilities.readingDataPropertyFile("homepagetitle");
		assertEquals(driver.getTitle(), homepageTitle);
		
		MonteCarloHomePage mchp = new MonteCarloHomePage(driver);
		
		//Click on Login/Signup icon
		mchp.loginBtn();
		lr.info("Sign in clicked");
		
		//Enter email address
		LoginPage lp = new LoginPage(driver);
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
		
		//Click on search
		acp.searchBoxCl();
		lr.info("Click on search box");
		
		//Search for Women's Hooded Jacket
		acp.searchBox(dataUtilities.readingDataPropertyFile("productNameTC04"));
		lr.info("Enter 'womens hooded jacket' in search box");
		
		//click on any product
		acp.whJacket();
		lr.info("Click on product : Women hooded jacket");
		
		ProductWomensJacket pwj = new ProductWomensJacket(driver);
		
		//Select the size
		WebElement s =  pwj.getSize();
		webDriverUtilities.waitElement(s, driver);
		pwj.size();
		lr.info("Size clicked");
		
		//Increase the quantity to 2
		WebElement iq =  pwj.getIncreaseQuantity();
		webDriverUtilities.waitElement(iq, driver);
		pwj.increaseQuantity();
		lr.info("Quantity increased");
		
		//Add the product to cart
		WebElement adc =  pwj.getAddToCart();
		webDriverUtilities.waitElement(adc, driver);
		pwj.addToCart();
		lr.info("Added to cart");
		
		//Click on intiate checkout
		WebElement inbtn =  pwj.getInitiateBtn();
		webDriverUtilities.waitElement(inbtn, driver);
		pwj.initiateBtn();
		lr.info("Initiate checkout button clicked");		
	}	
}
