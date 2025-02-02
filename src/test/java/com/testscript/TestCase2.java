package com.testscript;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.genericLibraries.BaseClass;
import com.pom.AccountsPage;
import com.pom.LoginPage;
import com.pom.MonteCarloHomePage;
import com.pom.ProductHandtowelPage;
import com.pom.WishlistPage;

public class TestCase2 extends BaseClass{

	@Test
	public void TestCase() throws IOException, Exception {
		MonteCarloHomePage mchp = new MonteCarloHomePage(driver);
		mchp.loginBtn();
		
		LoginPage lp = new LoginPage(driver);
		lp.username(dataUtilities.readingExcelSheetFile("Sheet1",1,1));
		lp.password(dataUtilities.readingExcelSheetFile("Sheet1",1,2));
		lp.login();
		
		AccountsPage acp= new AccountsPage(driver);
		acp.searchBoxCl();
		acp.searchBox(dataUtilities.readingDataPropertyFile("productNameTC03"));
		acp.handTowel();
		
		ProductHandtowelPage pht = new ProductHandtowelPage(driver);
		pht.addWishlist();
		pht.goToWishlist();
		
		WishlistPage wlsp = new WishlistPage(driver);
		WebElement mo = wlsp.getWishlistHandTowel();
		webDriverUtilities.mouseHover(mo, driver);
		wlsp.closeButton();
		
	}	
}
