package com.LearnAutomation.testcases;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test_case_without_frameWork {
	
	@Test
	public void test1() {
		System.setProperty("webdriver.chrome.driver", "F:/Learnings/chromedriver_win32/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://freecrm.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("")).sendKeys("");
		driver.findElement(By.name("")).sendKeys("");
		driver.findElement(By.xpath("")).click();
		driver.quit();
		
	
		
		
		
		
		
		
		
	}

}
