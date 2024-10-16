package com.LearnAutomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.LearnAutomation.pages.LoginPage;
import com.LearnAutomation.pages.baseClass;
import com.LearnAutomation.utility.ExcelDataProvider;
import com.LearnAutomation.utility.Helper;

public class LoginTestOrangeHRM extends baseClass{
	
	
	
	@Test
	public void startApp() {
		
		logger=report.createTest("Login to OrangeHRM");
		
		
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting application");
		
		loginPage.LogintoOrangeHRM(excel.getStringData("login", 0, 0), excel.getStringData("login", 0, 1));
		
		logger.pass("Login done successfully");
		
		
		Helper.captureScreenshot(driver);
		
	}

}
