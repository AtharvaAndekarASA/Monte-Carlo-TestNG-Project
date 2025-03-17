/* 
 TEST-CASE NO.2 Removing and adding Hand Towel Product in the wishlist

1.Open the browser
2.Maximize the browser                     
3.Enter the URL
4.Click on Login
5.Enter Username and password
6.Verify the AccountPage
7.Click on Searchbox
8.Search for Hand Towels
9.Scrolldown upto fourth product
10.Click on the fourth product
11.Add to Wishlist
12.Click on Wishlist
13.Verify if the product is added to the wishlist
14.Click on the close button
15.Verify if the product is removed or not

*/

package testscript;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import pompages.AccountsPage;
import pompages.LoginPage;
import pompages.MonteCarloHomePage;
import pompages.ProductHandtowelPage;
import pompages.WishlistPage;

public class TC_02_HandTowelProductAdding extends BaseClass {
    
    Logger lr = LogManager.getLogger(TC_02_HandTowelProductAdding.class);
    
    @Test
    public void TestCase02_HandTowelProductAdding() throws IOException, Exception {
        
        //Verify you are in Home Page.
        String homepageTitle = dataUtilities.readingDataPropertyFile("homepagetitle");
		assertEquals(driver.getTitle(), homepageTitle);
		
		MonteCarloHomePage mchp = new MonteCarloHomePage(driver);
		
		//Click on Login/Signup icon
        mchp.loginBtn();
        lr.info("Sign in clicked");
        
        LoginPage lp = new LoginPage(driver);
        
        //Enter email address
        lp.username(dataUtilities.readingExcelSheetFile("Sheet1", 1, 1));
        lr.info("Entered username");
        
        //Enter password
        lp.password(dataUtilities.readingExcelSheetFile("Sheet1", 1, 2));
        lr.info("Entered password");
        
        //Click on Login
        lp.login();
        lr.info("Log in clicked");
        
        //Verify you are in Accounts Page.
        String accountpageTitle = dataUtilities.readingDataPropertyFile("accountpageTitle");
		assertEquals(driver.getTitle(), accountpageTitle);
        
        AccountsPage acp = new AccountsPage(driver);
        
        //Click on  SearchBox icon
        acp.searchBoxCl();
        lr.info("Searchbox clicked");
        
        //Search for hand towels
        acp.searchBox(dataUtilities.readingDataPropertyFile("productNameTC03"));
        lr.info("Search keys sent");
        
        //Click on hand towel
        acp.handTowel();
        lr.info("Clicked hand towel");
        
        String HndTowelText = acp.textHandTowel();
        
        ProductHandtowelPage pht = new ProductHandtowelPage(driver);     
        
        //Click on add to wishlist
        pht.addWishlist();
        lr.info("Added to wishlist");
        
        //Click on wishlist button
        pht.goToWishlist();
        lr.info("Clicked on wishlist icon");
        
        WishlistPage wlsp = new WishlistPage(driver);
        
        String WLtext = wlsp.textWishlistHandTowel();
        
        //Verify if the product is added to the wishlist
        SoftAssert wlst = new SoftAssert();
        wlst.assertEquals(HndTowelText, WLtext);
        
        WebElement mo = wlsp.getWishlistHandTowel();
        webDriverUtilities.waitElement(mo, driver);
        webDriverUtilities.mouseHover(mo, driver);
        lr.info("Mouse overed on product");
        
        //Click on the close button
        wlsp.closeButton();
        lr.info("Button closed ");
        
        //Verify if the product is removed or not
        webDriverUtilities.refreshk(driver);
    }    
}
