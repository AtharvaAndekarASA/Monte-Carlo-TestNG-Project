/* 
 TEST-CASE NO.5 Get Manufacturer's Address and navigate to store on Google Maps
 
1) open browser
2) enter url https://www.montecarlo.in/
3) click on login/signup btn 
4) Enter Email
5) Enter Password
6) click on login btn
7) verify you are in profile page
8) click on monte carlo home link it will redirect you "Homes by Monte Carlo"
9) scroll down till shop blankets btn element and click shop blankets button
10) Select the product and click on that product
11) it will redirect you that product page and then click on product details & description
12) get the manufacture address text
13) scroll to end then you will find link Our Stores and then click on it.
14) verify your page through title  that you are in our stores page
15) you will find search box you can search (by city,state or zip) then send keys zip code 
16) you will find store located in that location in that pincode
17) click on getDirections btn that is visible on the store card
18) it should navigates you google map.     
19)Close the application. 

*/

package testscript;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import pompages.AccountsPage;
import pompages.BlanketsPage;
import pompages.HomesByMcPage;
import pompages.LoginPage;
import pompages.MonteCarloHomePage;
import pompages.ProductsBlanket;
import pompages.StoreLocatorPage;

public class TC_05_ManufacturerAddress extends BaseClass{
	
	Logger lr = LogManager.getLogger(TC_05_ManufacturerAddress.class);
	@Test
	public void TestCase05_ManufactureAddress() throws IOException, Exception {
		
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
		
		//Click on monte carlo home link it will redirect you "Homes by Monte Carlo"
		acp.homesByMc();
		lr.info("Homes by MonteCarlo clicked");
		
		HomesByMcPage hbmp = new HomesByMcPage(driver);
		
		//Scroll down till shop blankets button element and click Shop Blankets button
		hbmp.shopBlankets();
		lr.info("Shop Blanket clicked");
		
		BlanketsPage bp = new BlanketsPage(driver);
		
		//Select the product and click on that product
		bp.productBlanket();
		lr.info("Blanket selected");
		
		ProductsBlanket pb = new ProductsBlanket(driver);
		
		//Click on product details & description
		pb.productDetails();
		lr.info("Clicked on view details");
		
		//Get the manufacturer address text
		Reporter.log(pb.address(),true);
		lr.info("Got the address");
		
		//Click on Our Stores
		pb.ourStores();
		lr.info("Clicked on our stores");
		
		//Verify your page through title  that you are in our stores page
		String storeLocatorpageTitle = dataUtilities.readingDataPropertyFile("storeLocatorPageTitle");
		assertEquals(driver.getTitle(), storeLocatorpageTitle);
		
		StoreLocatorPage slp = new StoreLocatorPage(driver);
		
		//Verify your page through title  that you are in our stores page
		SoftAssert stlp = new SoftAssert();
		stlp.assertEquals(driver.getTitle(), dataUtilities.readingDataPropertyFile("storeLocatorPageTitle"));
		
		//Search by city,state,pincode or zip then send keys to zip code
		slp.searchPincode(dataUtilities.readingDataPropertyFile("pcode2"));
		lr.info("Searched pincode");
		
		//Click on getDirections btn that is visible on the store card
		slp.getDirections();
		lr.info("Got directions");
	}
}
