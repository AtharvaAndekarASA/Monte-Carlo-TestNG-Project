package com.testscript;

import java.io.IOException;

import org.openqa.selenium.WebElement;
//import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericLibraries.BaseClass;
import com.pom.AcComforterPage;
import com.pom.AccountsPage;
import com.pom.LoginPage;
import com.pom.MonteCarloHomePage;
import com.pom.ProductBedSheetPage;
import com.pom.WishlistPage;

public class TestCase1 extends BaseClass{
	
	@Test
	public void TestCase() throws IOException, Exception {
		MonteCarloHomePage mchp = new MonteCarloHomePage(driver);
		mchp.loginBtn();
		
		LoginPage lp = new LoginPage(driver);
		lp.username(dataUtilities.readingExcelSheetFile("Sheet1",1,1));
		lp.password(dataUtilities.readingExcelSheetFile("Sheet1",1,2));
		lp.login();
		
		//Assert.assertEquals(dataUtilities.readingDataPropertyFile("accountpageTitle"), driver.getTitle(), "Verified Accounts Page false");
		
		AccountsPage ap = new AccountsPage(driver);
		WebElement mo = ap.getHomeFSection();
		Thread.sleep(2000);
		webDriverUtilities.mouseHover(mo,driver);
		ap.acComforter();
		
		AcComforterPage acp = new AcComforterPage(driver);
		acp.size();
		Thread.sleep(2000);
		acp.sizeSingle();
		Thread.sleep(2000);
//		acp.color();
//		Thread.sleep(2000);
//		acp.colorPink();
//		Thread.sleep(2000);
		acp.brand();
		Thread.sleep(2000);
		acp.brandMC();
		Thread.sleep(2000);
		acp.availability();
		Thread.sleep(2000);
		acp.availabilityInStock();
		Thread.sleep(2000);
		acp.product();
		
		ProductBedSheetPage pbsp = new ProductBedSheetPage(driver);
		pbsp.addWishlist();
		pbsp.goToWishlist();
		
		//Assert.assertEquals(dataUtilities.readingDataPropertyFile("wishlistTitle"), driver.getTitle(), "Verified Wishlist Page false");
		
		WishlistPage wlsp = new WishlistPage(driver);
		Thread.sleep(2000);
		wlsp.addToCart();		
		
		//Assert.assertEquals(dataUtilities.readingDataPropertyFile("productNameCrtlist"), driver.getTitle(), "Verified Product in Cart Page false");	
		
	}
}
