/*
	
*/

package com.genericLibraries;

import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;								
import java.io.IOException;

//Class for accessing external data
public class DataUtilities {
	
	//Method for accessing properties file
	public String readingDataPropertyFile(String data) throws Exception, IOException {
		
		Properties properties = new Properties();
		properties.load(new FileInputStream(AutoConstant.propertyFilePath));
		return properties.getProperty(data);
		
	}

	//Method for accessing excel file
	public String readingExcelSheetFile(String sheetname, int rowNo, int cellNo) throws Exception, IOException {
		
		FileInputStream fis = new FileInputStream(AutoConstant.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetname).getRow(rowNo).getCell(cellNo).getStringCellValue();
		
	}
}
