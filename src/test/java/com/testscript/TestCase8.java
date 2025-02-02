package com.testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.genericLibraries.BaseClass;
import com.pom.MonteCarloHomePage;
import com.pom.ProductStolePage;
import com.pom.StolesPage;
import com.pom.WomensPage;

public class TestCase8 extends BaseClass{
	@Test
	public void TestCase() throws IOException, Exception {
		MonteCarloHomePage mchp = new MonteCarloHomePage(driver);
		mchp.womenSection();
		
		WomensPage wp = new WomensPage(driver);
		wp.stoleImg();
		
		StolesPage sp = new StolesPage(driver);
		sp.lowValueprice(dataUtilities.readingDataPropertyFile("lValue1"));
		sp.highValueprice(dataUtilities.readingDataPropertyFile("hValue1"));
		sp.reset();
		Thread.sleep(2000);
		sp.lowValueprice(dataUtilities.readingDataPropertyFile("lValue2"));
		sp.highValueprice(dataUtilities.readingDataPropertyFile("hValue2"));
		sp.productStole();
		
		ProductStolePage psp = new ProductStolePage(driver);
		psp.addToWishlist();
		psp.goToWishlist();
		
	}
}
