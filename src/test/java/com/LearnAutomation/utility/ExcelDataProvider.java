package com.LearnAutomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		
		File src = new File("F:\\Learnings\\SeleniumFramework\\TestData\\Data.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			 wb =new XSSFWorkbook(fis) ;
		} catch (Exception e) {
			
			System.out.println("Unable to read Excel file "+e.getMessage());
		
		}
	}
	
	public double getNumericData(int sheetindex , int row, int column) {
		return wb.getSheetAt(sheetindex).getRow(row).getCell(column).getNumericCellValue();			
	}
		
		public String getStringData(String sheetname , int row, int column) {
			return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		}
		public double getNumericData(String sheetname , int row, int column) {
			return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();			
		}
		
		
		
		
		
		
	

}
