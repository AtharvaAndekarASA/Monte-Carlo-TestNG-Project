package com.testscript;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.genericLibraries.BaseClass;
import com.pom.AccountsPage;
import com.pom.LoginPage;
import com.pom.MonteCarloHomePage;
import com.pom.ProductTCeleven;

public class TestCase11 extends BaseClass{
	@Test
	public void TestCase() throws IOException, Exception {
		MonteCarloHomePage mchp = new MonteCarloHomePage(driver);
		mchp.loginBtn();
		
		LoginPage lp = new LoginPage(driver);
		lp.username(dataUtilities.readingExcelSheetFile("Sheet1",1,1));
		lp.password(dataUtilities.readingExcelSheetFile("Sheet1",1,2));
		lp.login();
		
		AccountsPage acp = new AccountsPage(driver);
		acp.mcLogo();
		
		mchp.newArrival();
		mchp.nextArrow();
		Thread.sleep(3000);
		WebElement mo = mchp.getNextArrowProduct();
		webDriverUtilities.mouseHover(mo, driver);
		//mchp.nextArrowProduct();
		mchp.quickview();
		mchp.increaseQuantity();
		mchp.viewDetails();
		
		ProductTCeleven ptce = new ProductTCeleven(driver);
		String product = ptce.productName();
		Reporter.log(product,true);
		
		
		
	}
}
