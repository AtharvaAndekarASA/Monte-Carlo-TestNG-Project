/* 
 TEST-CASE NO.8 Without logging in, Resetting the Filter of price and Adding To Wishlist
 
1. Open the Browser
2. Enter the Url.
3. Click on Women.
4. Click on stole.
5. Set the price range from 0 to 500.
6. No result text should be visible.
7.Click on reset filter button.
8.Set the range from 499 to 2000.
9.Click on the first product.
10.Click on the wishlist of the product.
11.Verify the popup Text
12.Check the producted is added to wishlist.
 
*/

package testscript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import pompages.MonteCarloHomePage;
import pompages.ProductStolePage;
import pompages.StolesPage;
import pompages.WomensPage;

public class TC_08_ResetFilterAddToWishlist extends BaseClass{
	
	Logger lr = LogManager.getLogger(TC_08_ResetFilterAddToWishlist.class);
	@Test
	public void TestCase08_ResetFilterAddToWishlist() throws IOException, Exception {
		
		//Verify you are in Home Page.
		String homepageTitle = dataUtilities.readingDataPropertyFile("homepagetitle");
		assertEquals(driver.getTitle(), homepageTitle);
		
		MonteCarloHomePage mchp = new MonteCarloHomePage(driver);
		
		//Click on Women section
		mchp.womenSection();
		lr.info("Clicked on womens section");
		
		WomensPage wp = new WomensPage(driver);
		
		//Click on stole
		wp.stoleImg();
		lr.info("Stole option clicked");
		
		StolesPage sp = new StolesPage(driver);
		
		//Set the price range from 0 to 500
		sp.lowValueprice(dataUtilities.readingDataPropertyFile("lValue1"));
		lr.info("Low range value of 0 entered");
		
		sp.highValueprice(dataUtilities.readingDataPropertyFile("hValue1"));
		lr.info("High range value of 500 entered");
		
		//Click on reset filter button
		sp.reset();
		lr.info("Clicked on reset");
		
		//Set the range from 499 to 2000
		sp.lowValueprice(dataUtilities.readingDataPropertyFile("lValue2"));
		lr.info("Low range value 500 entered");
		
		sp.highValueprice(dataUtilities.readingDataPropertyFile("hValue2"));
		lr.info("High range value 2000 entered");
		
		//Click on the first product
		sp.productStole();
		lr.info("Product stole clicked");
		
		ProductStolePage psp = new ProductStolePage(driver);
		
		//Click on the wishlist of the product
		psp.addToWishlist();
		lr.info("Add to wishlist clicked");
		
		psp.popEmail(dataUtilities.readingDataPropertyFile("username"));
		
		psp.popAddToWishlist();
		
		String popUpText = psp.popText();
		
		//Verify the popup Text
		SoftAssert pt = new SoftAssert();
		pt.assertEquals(popUpText,dataUtilities.readingDataPropertyFile("popTextTC8") );
		
		//Check the producted is added to wishlist
		psp.goToWishlist();
		lr.info("Wishlist option clicked");		
	}
}
