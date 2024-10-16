package com.LearnAutomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configDataProvider {
	
	
	Properties prop;

	
	
	public configDataProvider() {
		
		File src = new File("F:\\Learnings\\SeleniumFramework\\Config\\config.properties");
	
		
	 try {
		FileInputStream fis = new FileInputStream(src);
		  prop = new Properties();
		  prop.load(fis);
	} catch (Exception e) {
		
		System.out.println("not able to load config file  >>"+e.getMessage());
	
	}
	  
	 
	 
	}
	
	
	
	public String getdataFromconfig(String KeyToSearch) {
		
		return	prop.getProperty(KeyToSearch);
		
	}
	
public String getBrowser() {
		
	return	prop.getProperty("Browser");
		
	}

public String getStageURl() {
	
	return prop.getProperty("qaURL");
	
}

	
	
}
