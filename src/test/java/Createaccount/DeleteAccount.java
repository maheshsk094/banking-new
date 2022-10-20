package Createaccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.BANKDOM_1.GenericUtility.ExcelFileUtility;
import com.BANKDOM_1.GenericUtility.PropertyFileUtility;
import com.BANKDOM_1.GenericUtility.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteAccount {

	public static void main(String[] args) throws Throwable {
		//Create object for general utility
		ExcelFileUtility eLib=new ExcelFileUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		WebdriverUtility wLib=new WebdriverUtility();
		

		//get data commonDta from property file

		String URL = pLib.ReadDataFromPropertyFile("url");
		String USERNAME = pLib.ReadDataFromPropertyFile("username");
		String PASSWORD = pLib.ReadDataFromPropertyFile("password");
          
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
	
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		
		driver.findElement(By.xpath("//a[.='Staff Login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("staff_id")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("staff_login-btn")).click();
		driver.findElement(By.name("del_cust")).click();
		
		
		//To delete the customers			
		for (int i = 10; i <= 52; i++)
		{
		
		driver.findElement(By.name("Cust_ac_no")).sendKeys(eLib.readDataFronExcelFile("Sheet2", i, 3));
		Thread.sleep(2000);
		driver.findElement(By.name("Cust_ac_Id")).sendKeys(eLib.readDataFronExcelFile("Sheet2", i, 2));
		Thread.sleep(2000);
		driver.findElement(By.name("reason")).sendKeys(eLib.readDataFronExcelFile("Sheet1", 1, 15));
		Thread.sleep(2000);
		driver.findElement(By.name("delete")).click();
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		
		 }
	
  }
}
