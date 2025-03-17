/* 
 TEST-CASE NO.3 Searching for a product and verifying the delivery Pincode

1.Open the browser
2.Maximize the browser                    
3.Enter the URL
4.Click Login/Signup
5.Enter Username and password 
6.Click Login
7.Verify the Account page 
8.MouseOver on Mens section
9.Click on Round Neck Sweaters
10.Click on size filter
11.Select 38 / M(94)
12.Scroll down & Click on Brand filter
13.Select the checkbox of Rock.it
14.Scroll down & Click on sleeve filter
15.Select the checkbox of Full Sleeve
16.Select the third product
17.Scroll & Enter the pincode in Check Pincode TextBox
18.Click on Check pincode
19.Close the window

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
import pompages.AccountsPage;
import pompages.LoginPage;
import pompages.MonteCarloHomePage;
import pompages.ProductRoundNeckTshirt;
import pompages.RoundNeckSweaterCollectionPage;

public class TC_03_VerifyPincode extends BaseClass{

	Logger lr = LogManager.getLogger(TC_03_VerifyPincode.class);
	
	@Test
	public void TestCase03_VerifyPincode() throws IOException, Exception {
		
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
		
		//Mouse over on Mens
		WebElement mo = acp.getMenSection();
		webDriverUtilities.mouseHover(mo, driver);
		lr.info("Mouse over on mens section");
		
		//Click on Round Neck sweaters
		acp.rnSweaters();
		lr.info("Clicked on Round Neck Sweaters");
		
		RoundNeckSweaterCollectionPage rnsc = new RoundNeckSweaterCollectionPage(driver);
		
		//Click on Size
		rnsc.size(driver);
		WebElement s =  rnsc.getSize();
		webDriverUtilities.waitElement(s, driver);
		lr.info("Size clicked");
		
		//Select size
		WebElement  ss =  rnsc.getSizeSelect();
		webDriverUtilities.waitElement(ss, driver);
		rnsc.sizeSelect(driver);
		lr.info("Size selected");
		
		//Click on Brand
		WebElement b =  rnsc.getBrand();
		webDriverUtilities.waitElement(b, driver);
		rnsc.brand(driver);
		lr.info("Brand clicked");
		
		//Select brand
		WebElement br =  rnsc.getBrandRock();
		webDriverUtilities.waitElement(br, driver);
		rnsc.brandRock(driver);
		lr.info("Rock.it Brand selected");
		
		//Click on Sleeve
		WebElement sl =  rnsc.getSleeve();
		webDriverUtilities.waitElement(sl, driver);
		rnsc.sleeve(driver);
		lr.info("Sleeve clicked");
		
		//Select full sleeve
		WebElement slf =  rnsc.getSleeveFull();
		webDriverUtilities.waitElement(slf, driver);
		rnsc.sleeveFull(driver);
		lr.info("FullSleeve selected");
		
		//Click on third product
		WebElement trp =  rnsc.getThirdProduct();
		webDriverUtilities.waitElement(trp, driver);
		
		String productText = rnsc.textOfSelectedProduct(3,driver);
		rnsc.selectTheProduct(3, driver);
		lr.info("Clicked on third product");
			
		ProductRoundNeckTshirt prnts = new ProductRoundNeckTshirt(driver);
		
		SoftAssert rnts = new SoftAssert();
		rnts.assertNotEquals(productText, dataUtilities.readingDataPropertyFile("productName"));
		
		//Enter the pincode in Check Pincode TextBox
		prnts.pincodeBox(dataUtilities.readingDataPropertyFile("pcode"));
		lr.info("Entered pincode");
		
		//Click on Check pincode
		prnts.chckpincodeBox();
		lr.info("Clicked on Pincode checkbox");	
	}	
}
