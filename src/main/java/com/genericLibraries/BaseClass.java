/*
  	A Base Class is created to store the basic driver functions 
  	that needs to be called again and again over the time in each 
  	and every test case. For e.g.Launching the browser, entering 
  	the url, implicitly waiting, getting the title, maximizing the
  	browser, closing the browser. Moreover the handling of WebElements
  	can also be called in the base class. We just need to create a 
  	seperate class 'WebDriverutilities' for handling Webelements. We 
  	can also access	external data from external files like properties
  	file and excel file by creating another class of 'DataUtilities' 
  	where you can initiate the properties file and the excel sheet.
  	Call the methods of Data Utilities in Base Class for accessing 
  	external data.
  	
*/

package com.genericLibraries;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(Listener.class)
public class BaseClass {
	
		//globally declaring the WebDriver reference variable
		public static WebDriver driver;
		//globally declaring the DataUtilities Object
		public DataUtilities dataUtilities = new DataUtilities();
		//globally declaring the WebDriverUtilities Object
		public WebDriverUtilities webDriverUtilities = new WebDriverUtilities();
		
		@BeforeMethod
		public void openApp() throws IOException, Exception {
			
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(dataUtilities.readingDataPropertyFile("url"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
		}
		
		@AfterMethod
		public void closeApp() throws IOException {
			//driver.close();
			driver.quit();
			
		}
}
