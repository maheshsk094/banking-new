package Createaccount;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDataTest {
	public static void main(String[] args) throws Throwable {

		//get data commonDta from property file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.Properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		FileInputStream fisexcel=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fisexcel);
		String URL = pObj.getProperty("url");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[.='Staff Login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("staff_id")).sendKeys("210001");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("staff_login-btn")).click();
		driver.findElement(By.name("viewdet")).click(); //view active customer
		Thread.sleep(4000);
		List<WebElement> list = driver.findElements(By.xpath("//table/tbody/tr"));
		System.out.println(list.size());
		for(int i=2;i<=list.size();i++){
		
			List<WebElement> subList = driver.findElements(By.xpath("//table/tbody/tr["+i+"]/td"));
			for(int j=0;j<subList.size();j++){
				try{
				wb.getSheet("Sheet2").getRow(i-1).createCell(j).setCellValue(subList.get(j).getText());
				}catch(Exception e){
					wb.getSheet("Sheet2").createRow(i-1).createCell(j).setCellValue(subList.get(j).getText());
				}
			}
		}
		wb.write(new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx"));
		System.out.println("Data Updated in excel");

	}
}
