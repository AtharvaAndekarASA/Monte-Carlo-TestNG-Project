package com.testscript;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.genericLibraries.BaseClass;
import com.pom.AccountsPage;
import com.pom.BlanketsPage;
import com.pom.HomesByMcPage;
import com.pom.LoginPage;
import com.pom.MonteCarloHomePage;
import com.pom.ProductsBlanket;
import com.pom.StoreLocatorPage;

public class TestCase5 extends BaseClass{
	@Test
	public void TestCase() throws IOException, Exception {
		MonteCarloHomePage mchp = new MonteCarloHomePage(driver);
		mchp.loginBtn();
		
		LoginPage lp = new LoginPage(driver);
		lp.username(dataUtilities.readingExcelSheetFile("Sheet1",1,1));
		lp.password(dataUtilities.readingExcelSheetFile("Sheet1",1,2));
		lp.login();
		
		AccountsPage acp = new AccountsPage(driver);
		acp.homesByMc();
		
		HomesByMcPage hbmp = new HomesByMcPage(driver);
		hbmp.shopBlankets();
		
		BlanketsPage bp = new BlanketsPage(driver);
		bp.productBlanket();
		
		ProductsBlanket pb = new ProductsBlanket(driver);
		pb.productDetails();
		Reporter.log(pb.address(),true);
		pb.ourStores();
		
		StoreLocatorPage slp = new StoreLocatorPage(driver);
		slp.searchPincode(dataUtilities.readingDataPropertyFile("pcode2"));
		slp.getDirections();
	}
}
