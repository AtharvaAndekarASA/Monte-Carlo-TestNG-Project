package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

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
	
	//Method for writing in property file
	public void writePropertyFile(String key, String value) throws FileNotFoundException, IOException {
		
		Properties properties = new Properties();
		properties.load(new FileInputStream(AutoConstant.propertyFilePath));
		properties.setProperty(key, value);
		properties.store(new FileOutputStream(AutoConstant.propertyFilePath), "Updated File");
	
	}
}
