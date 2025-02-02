package com.testscript;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.genericLibraries.BaseClass;
import com.pom.AccountsPage;
import com.pom.LoginPage;
import com.pom.MonteCarloHomePage;
import com.pom.ProductRoundNeckTshirt;
import com.pom.RoundNeckSweaterCollectionPage;

public class TestCase3 extends BaseClass{

	@Test
	public void TestCase() throws IOException, Exception {
		MonteCarloHomePage mchp = new MonteCarloHomePage(driver);
		mchp.loginBtn();
		
		LoginPage lp = new LoginPage(driver);
		lp.username(dataUtilities.readingExcelSheetFile("Sheet1",1,1));
		lp.password(dataUtilities.readingExcelSheetFile("Sheet1",1,2));
		lp.login();
		
		AccountsPage acp = new AccountsPage(driver);
		WebElement mo = acp.getMenSection();
		Thread.sleep(9000);
		webDriverUtilities.mouseHover(mo, driver);
		acp.rnSweaters();
		
		RoundNeckSweaterCollectionPage rnsc = new RoundNeckSweaterCollectionPage(driver);
		rnsc.size();
		Thread.sleep(2000);
		rnsc.sizeSelect();
		Thread.sleep(2000);
		rnsc.brand();
		Thread.sleep(2000);
		rnsc.brandRock();
		Thread.sleep(2000);
		rnsc.sleeve();
		Thread.sleep(2000);
		rnsc.sleeveFull();
		Thread.sleep(2000);
		rnsc.thirdProduct();
		Thread.sleep(2000);
			
		ProductRoundNeckTshirt prnts = new ProductRoundNeckTshirt(driver);
		prnts.pincodeBox(dataUtilities.readingDataPropertyFile("pcode"));
		prnts.chckpincodeBox();
		
	}	
}
