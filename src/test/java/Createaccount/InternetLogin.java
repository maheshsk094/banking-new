package Createaccount;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.BANKDOM_1.GenericUtility.ExcelFileUtility;
import com.BANKDOM_1.GenericUtility.JavaUtility;
import com.BANKDOM_1.GenericUtility.PropertyFileUtility;
import com.BANKDOM_1.GenericUtility.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InternetLogin {

	public static void main(String[] args) throws Throwable {
		//Create object for general utility
		ExcelFileUtility eLib=new ExcelFileUtility();
		JavaUtility jLib=new JavaUtility();
		PropertyFileUtility pLib=new PropertyFileUtility();
		WebdriverUtility wLib=new WebdriverUtility();
		

		//get data commonDta from property file
		String BROWSER = pLib.ReadDataFromPropertyFile("browser");
		String URL = pLib.ReadDataFromPropertyFile("url");
		String USERNAME = pLib.ReadDataFromPropertyFile("username");
		String PASSWORD = pLib.ReadDataFromPropertyFile("password");

		
		//fetch from excel
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("sheet1");               
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
	
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		
		 WebElement ele5 = driver.findElement(By.partialLinkText("Internet Banking"));//nb space
	      // Actions a1= new Actions(driver);
	      // a1.moveToElement(ele5).perform();
		 wLib.mouseHover(driver, ele5);
	       driver.findElement(By.xpath("//a[.='Login ']")).click();
	       driver.findElement(By.name("customer_id")).sendKeys("1011922");
	       driver.findElement(By.name("password")).sendKeys("mahi123");
	       driver.findElement(By.name("login-btn")).click();
	       
	       driver.findElement(By.xpath("//li[.='My Profile']")).click();
	       Thread.sleep(2000);
	       driver.findElement(By.xpath("//li[.='My Account']")).click();
	       Thread.sleep(2000);
	       wLib.switchToWindow(driver, "myprofile"); // To switch the window to myprofile
	       Thread.sleep(2000);
	       wLib.switchToWindow(driver, "myacc");
	       Thread.sleep(2000);
	       driver.quit();
		
		

	}

}
