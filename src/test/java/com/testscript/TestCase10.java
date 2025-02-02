package com.testscript;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.genericLibraries.BaseClass;
import com.pom.AccountsPage;
import com.pom.CartPage;
import com.pom.CheckoutPage;
import com.pom.CollectionsAll;
import com.pom.LoginPage;
import com.pom.MonteCarloHomePage;
import com.pom.ProductTCten;
import com.pom.WishlistPage;

public class TestCase10 extends BaseClass{
	@Test
	public void TestCase() throws IOException, Exception {
		MonteCarloHomePage mchp = new MonteCarloHomePage(driver);
		mchp.loginBtn();
		
		LoginPage lp = new LoginPage(driver);
		lp.username(dataUtilities.readingExcelSheetFile("Sheet1",1,1));
		lp.password(dataUtilities.readingExcelSheetFile("Sheet1",1,2));
		lp.login();
		
		AccountsPage acp = new AccountsPage(driver);
		acp.cartCl();
		acp.cartStrtShopping();
		
		CollectionsAll ca = new CollectionsAll(driver);
		ca.filterDate();
		ca.highToLow();
		ca.productTC10();
		
		ProductTCten ptct = new ProductTCten(driver);
		ptct.addToWishlist();
		ptct.goToWishlist();
		
		WishlistPage wlp = new WishlistPage(driver);
		String product = wlp.bedSheetVerify();
		Reporter.log(product,true);
		
//		String homepageTitle = dataUtilies.readPropertyFile("homepageTitle");
//		assertEquals(driver.getTitle(), homepageTitle);
		
		if(product.equals(dataUtilities.readingDataPropertyFile("productNameTC10"))) {
			wlp.addToCart();
		}
		
		CartPage cp = new CartPage(driver);
		cp.addEditNote();
		cp.cartNote(dataUtilities.readingDataPropertyFile("note"));
		cp.initiateCheckout();
		
		CheckoutPage chp = new CheckoutPage(driver);
		chp.addressInput(dataUtilities.readingDataPropertyFile("address1"));
		chp.addressSecondOption();
		
	}
}
