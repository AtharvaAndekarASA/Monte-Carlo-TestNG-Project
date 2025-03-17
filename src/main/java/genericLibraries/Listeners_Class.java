package genericLibraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners_Class implements ITestListener{

	public ExtentReports reports = new ExtentReports();
	private ExtentTest test;
	public static ExtentTest stest;
	
	@Override
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
		stest=test;
	}	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+"Pass");
		test.pass(result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot takesscreenshot = (TakesScreenshot)BaseClass.driver;
		File src = takesscreenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(AutoConstant.photoFilePath+result.getMethod().getMethodName()+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.fail(result.getMethod().getMethodName()+"Fail");
		test.fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName()+"Skip");
		test.skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./Reports/");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("MonteCarlo");
		
		reports.attachReporter(spark);
		reports.setSystemInfo("Username","Atharva");
		reports.setSystemInfo("OS","windows");
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}	
}