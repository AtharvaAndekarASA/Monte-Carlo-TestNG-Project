package genericLibraries;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(Listeners_Class.class)
public class BaseClass {
	
		//Globally declaring the Webdriverand the objects of DataUtilities and WebDriverUtilities for accessing it again 
		public static WebDriver driver;
		public DataUtilities dataUtilities = new DataUtilities();
		public WebDriverUtilities webDriverUtilities = new WebDriverUtilities();
		
		//Method for launching the browser before the test execution
		@BeforeMethod
		public void openApp() throws IOException, Exception {		
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(dataUtilities.readingDataPropertyFile("url"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		}
		
		//Method for closing the browser after test execution
		@AfterMethod
		public void closeApp() throws IOException {
			driver.quit();			
		}
}
