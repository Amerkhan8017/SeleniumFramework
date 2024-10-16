package com.LearnAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver ;
	public LoginPage(WebDriver  ldriver) {
		
		
		this.driver=ldriver;
	}
	
	//@FindBy(name="username") WebElement uname;
	@FindBy(name="username") WebElement uname;
	@FindBy(name="password") WebElement pass;
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']") WebElement LoginButton;
	
	public void LogintoOrangeHRM(String usernameApplication , String passApplication) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		
		}
		
		uname.sendKeys(usernameApplication);
		pass.sendKeys(passApplication);
		LoginButton.click();
	}
	
	
	

}
