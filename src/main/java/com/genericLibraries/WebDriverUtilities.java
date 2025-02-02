/*
	
*/

package com.genericLibraries;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

//Class for declaring WebElement handling methods
public class WebDriverUtilities {
	//Declaring the WebDriver reference variable globally
	//public WebDriver driver;
	
	/* Declaring the Class object globally can consume huge memory consumption
	   so declare the class object locally in every method.
	
	//Declaring Actions Class object globally
	Actions ac = new Actions(driver);
	
	//Declaring Alert Interface object globally
	Alert alert = driver.switchTo().alert();
	
	//Declaring the JavascriptExecutor Interface globally and typecasting the WebDriver Element 
	JavascriptExecutor javascriptexecutor = (JavascriptExecutor)driver;	
		
	*/
	
	//Method for Mouse Over Action
	public void mouseHover(WebElement ele,WebDriver driver) {
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).perform();
	}
	
	//Method for Right Click Action
	public void rightClick(WebElement ele,WebDriver driver) {
		Actions ac = new Actions(driver);
		ac.contextClick(ele).perform();
	}
	
	//Method for Double Click Action
	public void doubleClick(WebElement ele,WebDriver driver) {
		Actions ac = new Actions(driver);
		ac.doubleClick(ele).perform();
	}
	
	//Method for handling dropdown elements
	public void dropdown(WebElement ele, String text) {
		Select s = new Select(ele);
		s.selectByVisibleText(text);	
	}
	
	//Method for switching to frame with the address of the frame element
	public void frameWithWebELementAddress(WebElement ele,WebDriver driver) {
		driver.switchTo().frame(ele);
	}
	
	//Method for switching to frame with the index of the frame element
	public void frameWithIndex(int num,WebDriver driver) {
		driver.switchTo().frame(num);
	}
	
	//Method for switching back to main frame
		public void backTomainFrame(int num,WebDriver driver) {
			driver.switchTo().defaultContent();
		}
	
	//Method for accepting alert
	public void alertAcceptPopUp(WebDriver driver) {
//		Alert alert = driver.switchTo().alert();
//		alert.accept();		
		driver.switchTo().alert().accept();
	}
	
	//Method for dismiss alert
	public void alertDismissPopUp(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();	
		//driver.switchTo().alert().dismiss();
	}
	
	//Method for getting text of the alert
	public void alertPopUpText(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		Reporter.log(alert.getText(), true);		
	}
	
	//Method for scrolling from top to bottom
	public void scrollToptoBottom(WebDriver driver) {
		JavascriptExecutor javascriptexecutor = (JavascriptExecutor)driver;
		javascriptexecutor.executeScript("window.scrollBy(0,500)");
	}
	
	//Method for scrolling from bottom to top
	public void scrollBottomtoTop(WebDriver driver) {
		JavascriptExecutor javascriptexecutor = (JavascriptExecutor)driver;
		javascriptexecutor.executeScript("window.scrollBy(0,-500)");
	}
	
	//Method for scrolling on any specific element
	public void scrollOnElement(WebElement ele,WebDriver driver) {
		JavascriptExecutor javascriptexecutor = (JavascriptExecutor)driver;
		javascriptexecutor.executeScript("arguments[0].scrollIntoView()",ele);
	}
	
	//Method for switching to child window tab
	public void switchChildWindow(WebDriver driver) {
		Set<String> child = driver.getWindowHandles();
		
		for(String ch : child) {
			driver.switchTo().window(ch);
		}
	}
	
	//Method for switching to multiple window tabs
	public void multipleTabs(int index,WebDriver driver) {
		Set<String> child = driver.getWindowHandles();
		ArrayList<String> arraylist = new ArrayList<String>(child);
		driver.switchTo().window(arraylist.get(index));
	}
	
	//Method for Explicitly waiting for any element to be visible
	public void waitElement(WebElement ele,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	//Method for Explicitly waiting for any element to be clickable
	public void waitElementClick(WebElement ele,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
}
