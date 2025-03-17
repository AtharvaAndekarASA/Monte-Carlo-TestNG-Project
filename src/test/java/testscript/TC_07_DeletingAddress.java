/* 
 TEST-CASE NO.7 Deleting the default address

1)Open Browser.
2)maximize the browser
3)Enter url
4)Click on Login/Signup.
5)Enter username and password.
6)Click on Login.
7)Verify whether you are on Account page.
8)Click on addresses.
9)Click on delete default address.                                      
10)verify the address is deleted                              
11)close the window.
 
*/

package testscript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pompages.AccountsPage;
import pompages.AddressPage;
import pompages.LoginPage;
import pompages.MonteCarloHomePage;

public class TC_07_DeletingAddress
 extends BaseClass{
	
	Logger lr = LogManager.getLogger(TC_07_DeletingAddress.class);
	@Test
	public void TestCase07_DeletingAddress() throws IOException, Exception {
		
		//Verify you are in Home Page.
		String homepageTitle = dataUtilities.readingDataPropertyFile("homepagetitle");
		assertEquals(driver.getTitle(), homepageTitle);
				
		MonteCarloHomePage mchp = new MonteCarloHomePage(driver);
				
		//Click on Login/Signup icon
		mchp.loginBtn();
		lr.info("Sign in clicked");
				
		LoginPage lp = new LoginPage(driver);
				
		//Enter email address
		lp.username(dataUtilities.readingExcelSheetFile("Sheet1",1,1));
		lr.info("Username entered");
				
		//Enter password
		lp.password(dataUtilities.readingExcelSheetFile("Sheet1",1,2));
		lr.info("Password entered");
				
		//Click on Login
		lp.login();
		lr.info("Log in clicked");
				
		//Verify you are in Accounts Page.
		String accountpageTitle = dataUtilities.readingDataPropertyFile("accountpageTitle");
		assertEquals(driver.getTitle(), accountpageTitle);
				
		AccountsPage acp = new AccountsPage(driver);
				
		//Click on addresses
		acp.addressAcc();
		lr.info("Address option clicked");
				
		AddressPage ap = new AddressPage(driver);
		
		WebElement dlt = ap.getDeleteaddress();
		webDriverUtilities.waitElement(dlt, driver);
		
		//Click on delete default address.
		ap.deleteDefaultAddress();
		lr.info("Address deleted");
		
		//Accept the pop-up
		webDriverUtilities.alertAcceptPopUp(driver);
		
		//Verify the address is deleted 
		webDriverUtilities.refreshk(driver);
	}	
}
