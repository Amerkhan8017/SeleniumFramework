package com.LearnAutomation.utility;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	
	public static WebDriver startApplication(WebDriver driver,String browserName , String appURL) {
	
		if(browserName.equalsIgnoreCase("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "F:\\Learnings\\SeleniumFramework\\Drivers\\chromedriver.exe");
			
			driver=new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
}
		
		else if(browserName.equalsIgnoreCase("Firefox")){
			
			//System.setProperty("webdriver.gecko.driver", "F:\\Learnings\\SeleniumFramework\\Drivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
	}
		else if(browserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "/SeleniumFramework/Drivers/chromedriver.exe");  //Needs to add the IE drivers location here 
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			
		}
		else {
			System.out.println("we do not support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		return driver;
		
	
}
	public static void QuitBrowser(WebDriver driver) {
		driver.quit();
	}
	
	
}
