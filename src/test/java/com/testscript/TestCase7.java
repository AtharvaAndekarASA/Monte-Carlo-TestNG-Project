package com.testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.genericLibraries.BaseClass;
import com.pom.AccountsPage;
import com.pom.AddressPage;
import com.pom.LoginPage;
import com.pom.MonteCarloHomePage;

public class TestCase7 extends BaseClass{
	@Test
	public void TestCase() throws IOException, Exception {
		MonteCarloHomePage mchp = new MonteCarloHomePage(driver);
		mchp.loginBtn();
		
		LoginPage lp = new LoginPage(driver);
		lp.username(dataUtilities.readingExcelSheetFile("Sheet1",1,1));
		lp.password(dataUtilities.readingExcelSheetFile("Sheet1",1,2));
		lp.login();
		
		AccountsPage acp = new AccountsPage(driver);
		acp.addressAcc();
		
		AddressPage ap = new AddressPage(driver);
		ap.deleteaddress();
		Thread.sleep(3000);
		
		webDriverUtilities.alertAcceptPopUp(driver);
		driver.navigate().refresh();
		
	}	
}
