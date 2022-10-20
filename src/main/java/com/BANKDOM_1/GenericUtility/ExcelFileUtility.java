package com.BANKDOM_1.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * It is developed using apache poi libraries, which is used to handle ms excel sheet
 * @author user
 *
 */

public class ExcelFileUtility {
	/**
	 * Used to read the data from excel file
	 * @param sheetname
	 * @param rowNo
	 * @param columnNo
	 * @return 
	 * @throws Throwable 
	 * @throws Throwable
	 */
	
	public String readDataFronExcelFile(String sheetname, int rowNo, int celNo) throws Throwable
	{
		FileInputStream fis= new FileInputStream(IpathConstants.Excelpath);
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(sheetname);
		 Row row = sh.getRow(rowNo);
		 Cell cel = row.getCell(celNo);
		 String value= cel.getStringCellValue();
		 return value;  
	}
	/**
	 * This method is used to write the data into excel file
	 * @param sheetname
	 * @param rowNo
	 * @param celNo
	 * @param value
	 * @param throwable
	 * @throws Throwable 
	 */
	public void writeDataIntoExcel(String sheetName, int rowNo, int celNo, String data) throws Throwable
	{
		FileInputStream fis= new FileInputStream(IpathConstants.Excelpath);
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(sheetName);
		 Row row = sh.getRow(rowNo);
		 Cell cel = row.getCell(celNo);
		 cel.setCellValue(data);
		 FileOutputStream fos= new FileOutputStream(IpathConstants.Excelpath);
		 wb.write(fos);
		 wb.close();
	}
	/**
	 * This method is used to get last row number
	 * @param sheetName
	 * @return 
	 * @throws Throwable 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable
	 */
	public int getLastRowNo(String sheetName) throws EncryptedDocumentException, Throwable
	{
		FileInputStream fis= new FileInputStream(IpathConstants.Excelpath);
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(sheetName);
		 int lastRow = sh.getLastRowNum();
		 return lastRow;
	}
	
	/**
	 * This is used for read data for DataProvider
	 * @throws Throwable 
	 */
	public Object[][] readMultipleSetOfData(String SheetName) throws Throwable
	{
		FileInputStream fis= new FileInputStream(IpathConstants.Excelpath);
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(SheetName);
		 int lastRow=sh.getLastRowNum()+1;
		 int lastCell=sh.getRow(0).getLastCellNum();
		 
		 Object[][] obj=new Object[lastRow+1][lastCell];
		 for (int i = 0; i <lastRow; i++)
		 {
			for (int j =0; j <lastCell; j++) 
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		 }
		 
		 return obj;		 
	}
		
}
