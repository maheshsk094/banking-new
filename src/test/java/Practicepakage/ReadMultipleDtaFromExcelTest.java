package Practicepakage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDtaFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("sheet1");
		int lastrow = sh.getLastRowNum();
		
		for (int i = 0; i <= lastrow; i++) {
			Row ro = sh.getRow(i);
			int celvalue = ro.getLastCellNum();
			
			for (int j = 0; j < celvalue; j++) {
				Cell cel = ro.getCell(j);
				String value = cel.toString();
				System.out.println(value);
			}
		}

	}

}
