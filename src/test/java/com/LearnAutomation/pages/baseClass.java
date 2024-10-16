package com.LearnAutomation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.LearnAutomation.utility.BrowserFactory;
import com.LearnAutomation.utility.ExcelDataProvider;
import com.LearnAutomation.utility.Helper;
import com.LearnAutomation.utility.configDataProvider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig.ExtentSparkReporterConfigBuilder;

public class baseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public configDataProvider config ;
	
	public ExtentReports report;
	public ExtentTest logger;
	
	
	
	@BeforeSuite
	public void setupSuite() {
		
		Reporter.log("Setting up reports and  Test is getting ready", true);
		
		 excel = new ExcelDataProvider();
		 config= new configDataProvider();
		 
		 ExtentSparkReporter extent = new ExtentSparkReporter( new File("F:\\Learnings\\SeleniumFramework\\Reports/OrangeHRM"+Helper.getCurrentDateTime()+".html"));
		 report = new ExtentReports();
		 report.attachReporter(extent);
		 Reporter.log("Settings done , test can be started ", true);
		 
		 
	}
	
	@Parameters({"browser","urlToBeTested"})
	@BeforeClass
	public void setup(String browser , String url) {
		
//		@BeforeClass
//		public void setup() {
		
		Reporter.log("Trying to start browser and Getting application ready ", true);
		
		//driver =BrowserFactory.startApplication(driver, config.getBrowser(), config.getStageURl());
		
		driver =BrowserFactory.startApplication(driver, browser, url);
		
		if (driver == null) {
	        System.out.println("Browser initialization failed. Exiting test.");
	        throw new RuntimeException("Browser initialization failed.");
	        
	        
		}
		Reporter.log("Browser and application is up and running", true);
	}
	@AfterClass
	public void tearDown() {
		BrowserFactory.QuitBrowser(driver);
	}
	
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		Reporter.log("Test is about to end", true);
		
		if(result.getStatus()==ITestResult.FAILURE) {
			//Helper.captureScreenshot(driver); //Not need this line because in the next line its integrated with report
			logger.fail("Test failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			
			logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

		}
		
			
		report.flush();
		Reporter.log("Test completed>>> reports Generated", true);
		
	}
	

}
