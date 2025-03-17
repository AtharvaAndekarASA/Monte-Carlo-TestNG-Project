/* 
 TEST-CASE NO.6 Adding new Address and setting it as default address

1)Open Browser.
2)maximize the browser
3)Enter url
4)Click on Login/Signup.
5)Enter username and password.
6)Click on Login.
7)Verify whether you are on Account page.
8)Click on addresses.
9)Click on add a new address.
10)Enter all the details
11)Click on Set it as default address.
12)Click on add a new address.
13)Verify weather the new address is added or not.
14)close the Window.
 
*/

package testscript;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import pompages.AccountsPage;
import pompages.AddressPage;
import pompages.LoginPage;
import pompages.MonteCarloHomePage;

public class TC_06_AddingAddress extends BaseClass{
	
	Logger lr = LogManager.getLogger(TC_06_AddingAddress.class);
	@Test
	public void TestCase06_Adding_Address() throws IOException, Exception {
		
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
		
		//Click on add a new address
		ap.addNewAddress();
		lr.info("Add new address clicked");
		
		//Enter all the details
		ap.addressFname(dataUtilities.readingDataPropertyFile("fname"));
		lr.info("Firstname entered");
		
		WebElement lname =  ap.getAddressLname();
		webDriverUtilities.waitElement(lname, driver);
		ap.addressLname(dataUtilities.readingDataPropertyFile("lname"));
		lr.info("Lastname entered");
		
		WebElement  adr=  ap.getAddressAddress();
		webDriverUtilities.waitElement(adr, driver);
		ap.addressAddress(dataUtilities.readingDataPropertyFile("address"));
		lr.info("Address entered");
		
		WebElement adz =  ap.getAddressZip();
		webDriverUtilities.waitElement(adz, driver);
		ap.addressZip(dataUtilities.readingDataPropertyFile("zip"));
		lr.info("Zip entered");
		
		//Click on Set it as default address.
		ap.setDefault();
		lr.info("Selected as default address");
		
		//Click on add new address
		WebElement add =  ap.getAddressAdd();
		webDriverUtilities.waitElement(add, driver);
		ap.addressAdd();
		lr.info("Add address option clicked");
		
		//Verify weather the new address is added or not
		SoftAssert adpg = new SoftAssert();
		adpg.assertEquals(ap.addressVerify(),dataUtilities.readingDataPropertyFile("addressVerify"));
		
		Reporter.log(ap.addressVerify(),true);
		lr.info("Address verified");
	}
}
