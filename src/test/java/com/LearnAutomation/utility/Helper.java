package com.LearnAutomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;

public class Helper {
	
	//Screenshot , alerts , windows, sync issues , javascript executors
	
	public static String captureScreenshot(WebDriver driver) {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenshotPath = System.getProperty("user.dir")+"/Screenshots/OrangeHRM"+getCurrentDateTime()+".png";
		
		//"F:\\Learnings\\SeleniumFramework\\Screenshots/"+getCurrentDateTime() +".png")
		
		
		try {
			FileHandler.copy(src, new  File(screenshotPath));
			
			System.out.println("Screenshot captured ");
		} catch (IOException e) {
			System.out.println("Unable to capture the screenshot"+e.getMessage());
			
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateTime() {
	DateFormat CustomFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	
	Date CurrentDate = new Date();
	return	CustomFormat.format(CurrentDate);
	}
	
		
		
		
	}


