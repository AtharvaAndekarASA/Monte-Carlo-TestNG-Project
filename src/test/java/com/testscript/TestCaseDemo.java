package com.testscript;

import java.io.IOException;

import org.testng.annotations.Test;
import com.pom.AccountsPage;
import com.pom.LoginPage;
import com.pom.MonteCarloHomePage;

public class TestCaseDemo extends TestCase9 {
	@Test(dependsOnMethods = "TestCase9a")
	public void TestCase() throws IOException, Exception {
		MonteCarloHomePage mchp = new MonteCarloHomePage(driver);
		mchp.loginBtn();
		
		LoginPage lp = new LoginPage(driver);
		lp.username(dataUtilities.readingExcelSheetFile("Sheet1",1,1));
		lp.password(dataUtilities.readingExcelSheetFile("Sheet1",1,2));
		lp.login();
		
		AccountsPage acp = new AccountsPage(driver);
		acp.cartCl();
		acp.addEditNote();
		acp.cartNote(dataUtilities.readingDataPropertyFile("note"));
		acp.saveButton();
		acp.closeBtn();
	}
}
