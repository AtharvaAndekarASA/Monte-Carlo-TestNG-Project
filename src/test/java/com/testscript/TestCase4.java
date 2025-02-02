package com.testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.genericLibraries.BaseClass;
import com.pom.AccountsPage;
import com.pom.LoginPage;
import com.pom.MonteCarloHomePage;
import com.pom.ProductWomensJacket;

public class TestCase4 extends BaseClass{
	@Test
	public void TestCase() throws IOException, Exception {
		MonteCarloHomePage mchp = new MonteCarloHomePage(driver);
		mchp.loginBtn();
		
		LoginPage lp = new LoginPage(driver);
		lp.username(dataUtilities.readingExcelSheetFile("Sheet1",1,1));
		lp.password(dataUtilities.readingExcelSheetFile("Sheet1",1,2));
		lp.login();
		
		AccountsPage acp = new AccountsPage(driver);
		acp.searchBoxCl();
		acp.searchBox(dataUtilities.readingDataPropertyFile("productNameTC04"));
		acp.whJacket();
		
		ProductWomensJacket pwj = new ProductWomensJacket(driver);
		pwj.size();
		Thread.sleep(2000);
		pwj.increaseQuantity();
		Thread.sleep(2000);
		pwj.addToCart();
		Thread.sleep(2000);
		pwj.initiateBtn();
		Thread.sleep(2000);
		
	}	
}
