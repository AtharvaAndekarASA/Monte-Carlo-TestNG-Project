package com.testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.genericLibraries.BaseClass;
import com.pom.AccountsPage;
import com.pom.CollectionsAll;
import com.pom.LoginPage;
import com.pom.MonteCarloHomePage;
import com.pom.ProductTC9SecondProduct;

public class TestCase9 extends BaseClass{
	@Test
	public void TestCase9a() throws IOException, Exception {
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
		ca.oldToNew();
		ca.secondProduct();
		
		ProductTC9SecondProduct pscp = new ProductTC9SecondProduct(driver);
		pscp.addToCart();
		Thread.sleep(3000);
		pscp.addEditNote();
		Thread.sleep(3000);
		pscp.cartNote(dataUtilities.readingDataPropertyFile("note"));
		Thread.sleep(3000);
		pscp.saveButton();
		Thread.sleep(5000);
		pscp.closeBtn();	
		
		
	}
}
