package Createaccount;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAC1 {
	private static final CharSequence AccountNumber = null;

	public static void main(String[] args) throws Throwable {

		//get data commonDta from property file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.Properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");

		
		//fetch from excel
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("sheet1");
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Open account
		driver.findElement(By.xpath("(//a[.='Open Account'])")).click();
		driver.findElement(By.name("name")).sendKeys(sh.getRow(1).getCell(0).toString());
		WebElement ele = driver.findElement(By.name("gender"));
		Select s = new Select(ele);
		s.selectByVisibleText("Male");
		driver.findElement(By.name("mobile")).sendKeys(sh.getRow(1).getCell(1).toString());
		driver.findElement(By.name("email")).sendKeys(sh.getRow(1).getCell(2).toString());
		driver.findElement(By.name("landline")).sendKeys(sh.getRow(1).getCell(3).toString());
		WebElement date = driver.findElement(By.xpath("//input[@placeholder='Date of Birth']"));
	date.click();
	date.sendKeys("10AA", Keys.TAB,"2022"); // ("10121996", Keys.TAB, "")
//((JavascriptExecutor) driver).executeScript("arguments[0].value='10012022'", date);
	//		
//		Robot r=new Robot();
//		r.keyPress(KeyEvent.VK_LEFT);
//		r.keyRelease(KeyEvent.VK_LEFT);
//		r.keyPress(KeyEvent.VK_LEFT);
//		r.keyRelease(KeyEvent.VK_LEFT);
//		r.keyPress(KeyEvent.VK_1);
//		r.keyRelease(KeyEvent.VK_1);
//		r.keyPress(KeyEvent.VK_5);
//		r.keyRelease(KeyEvent.VK_5);
//		r.keyPress(KeyEvent.VK_0);
//		r.keyRelease(KeyEvent.VK_0);
//		r.keyPress(KeyEvent.VK_2);
//		r.keyRelease(KeyEvent.VK_2);
//		r.keyPress(KeyEvent.VK_1);
//		r.keyRelease(KeyEvent.VK_1);
//		r.keyPress(KeyEvent.VK_9);
//		r.keyRelease(KeyEvent.VK_9);
//		r.keyPress(KeyEvent.VK_9);
//		r.keyRelease(KeyEvent.VK_9);
//		r.keyPress(KeyEvent.VK_6);
//		r.keyRelease(KeyEvent.VK_6);



		driver.findElement(By.xpath("//input[@placeholder='PAN Number']")).sendKeys(sh.getRow(1).getCell(4).toString());
		driver.findElement(By.name("citizenship")).sendKeys(sh.getRow(1).getCell(5).toString());
		driver.findElement(By.name("homeaddrs")).sendKeys(sh.getRow(1).getCell(6).toString());
		driver.findElement(By.name("officeaddrs")).sendKeys(sh.getRow(1).getCell(7).toString());
		WebElement ele1 = driver.findElement(By.name("state"));
		Select s1 = new Select(ele1);
		s1.selectByValue(sh.getRow(1).getCell(11).toString()); // fetch drop down
		WebElement ele2 = driver.findElement(By.name("city"));
		Select s2 = new Select(ele2);
		s2.selectByValue(sh.getRow(1).getCell(12).toString());
		driver.findElement(By.name("pin")).sendKeys(sh.getRow(1).getCell(8).toString());
		driver.findElement(By.name("arealoc")).sendKeys(sh.getRow(1).getCell(9).toString());
		WebElement ele3 = driver.findElement(By.name("acctype"));
		Select s3 = new Select(ele3);
		s3.selectByValue("Saving");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		String text = driver.switchTo().alert().getText();
		String applicationNumber="";
		for (int i=0;i<text.length();i++){
			if(Character.isDigit(text.charAt(i))){
				applicationNumber=applicationNumber+text.charAt(i);
			}
		}
		System.out.println(applicationNumber);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		//staff login and approve
		driver.findElement(By.xpath("//a[.='Staff Login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("staff_id")).sendKeys("210001");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("staff_login-btn")).click();

		//Approve account
		driver.findElement(By.name("apprvac")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("application_no")).sendKeys(applicationNumber);
		driver.findElement(By.name("search_application")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("approve_cust")).click();
		String text1 = driver.switchTo().alert().getText();
		String AccountNumber="";
		for (int i=0;i<text1.length();i++){
			if(Character.isDigit(text1.charAt(i))){
				AccountNumber=AccountNumber+text1.charAt(i);
			}
		}
		System.out.println(AccountNumber);
		
		driver.switchTo().alert().accept();
		driver.findElement(By.name("home")).click();

		//view customer by ac no
		driver.findElement(By.name("view_cust_by_ac")).click();
		driver.findElement(By.name("account_no")).sendKeys(AccountNumber);
		driver.findElement(By.name("submit_view")).click();
		driver.findElement(By.name("home")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("viewdet")).click();//view active customer
		driver.findElement(By.xpath("//a[.='Home']")).click();         
		
		//Apply debit card
		driver.findElement(By.xpath("//a[.='Apply Debit Card']")).click();
		driver.findElement(By.name("holder_name")).sendKeys(sh.getRow(1).getCell(0).toString());
		WebElement date1 = driver.findElement(By.xpath("//input[@placeholder='Date of Birth']"));
		date1.click();
		date1.sendKeys("10AA", Keys.TAB,"2022");
		driver.findElement(By.name("pan")).sendKeys(sh.getRow(1).getCell(4).toString());
		Thread.sleep(1000);
		driver.findElement(By.name("mob")).sendKeys(sh.getRow(1).getCell(1).toString());//to enter numeric value
		Thread.sleep(1000);
		driver.findElement(By.name("acc_no")).sendKeys(AccountNumber);
		driver.findElement(By.name("dbt_crd_submit")).click();
		
	 Alert alert = driver.switchTo().alert();
	String pinCode = alert.getText().split("Pin is : ")[1].split(" ")[0].trim();   //to get Debit card no. and pin separately
	String debitcardNumber= alert.getText().split("Debit Card No is : ")[1].split(" ")[0].trim();
	System.out.println(pinCode);
	System.out.println(debitcardNumber);
	Thread.sleep(2000);
	alert.accept();
	
		
	driver.findElement(By.xpath("//a[.='Home']")).click(); 

		
		//Internet banking registration
       WebElement ele4 = driver.findElement(By.partialLinkText("Internet Banking"));//nb space
       Actions a= new Actions(driver);
       a.moveToElement(ele4).perform();
		driver.findElement(By.xpath("//a[.='Register']")).click();
		driver.findElement(By.name("holder_name")).sendKeys(sh.getRow(1).getCell(0).toString());
		driver.findElement(By.name("accnum")).sendKeys(AccountNumber);
		driver.findElement(By.name("dbtcard")).sendKeys(debitcardNumber);
		driver.findElement(By.name("dbtpin")).sendKeys(pinCode);
		driver.findElement(By.name("mobile")).sendKeys(sh.getRow(1).getCell(1).toString());
		driver.findElement(By.name("pan_no")).sendKeys(sh.getRow(1).getCell(4).toString());
		WebElement date3 = driver.findElement(By.xpath("//input[@placeholder='Date of Birth']"));
		date3.click();
		date3.sendKeys("10AA", Keys.TAB,"2022");
		driver.findElement(By.name("last_trans")).sendKeys("0000");
		driver.findElement(By.name("password")).sendKeys(sh.getRow(1).getCell(10).toString());
		driver.findElement(By.name("cnfrm_password")).sendKeys(sh.getRow(1).getCell(10).toString());
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		String text4 = driver.switchTo().alert().getText();
		String InternetID="";
		for (int i=0;i<text4.length();i++){
			if(Character.isDigit(text4.charAt(i))){
				InternetID=InternetID+text4.charAt(i);
			}
		}
		System.out.println(InternetID);
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[.='Home']")).click(); 
		Thread.sleep(2000);
		
		
		//Internet banking login
		 WebElement ele5 = driver.findElement(By.partialLinkText("Internet Banking"));//nb space
	       Actions a1= new Actions(driver);
	       a1.moveToElement(ele5).perform();
	       driver.findElement(By.xpath("//a[.='Login ']")).click();
	       driver.findElement(By.name("customer_id")).sendKeys(InternetID);
	       driver.findElement(By.name("password")).sendKeys(sh.getRow(1).getCell(10).toString());
	       driver.findElement(By.name("login-btn")).click();
	       
	       //change password
	       driver.findElement(By.xpath("//li[.='Change Password']")).click();
	       driver.findElement(By.name("oldpass")).sendKeys(sh.getRow(1).getCell(10).toString());
	       driver.findElement(By.name("cnfrm")).sendKeys(sh.getRow(1).getCell(10).toString());
	       driver.findElement(By.name("newpass")).sendKeys(sh.getRow(1).getCell(11).toString());
	       driver.findElement(By.name("change_pass")).click();
	       Thread.sleep(2000);
	       driver.switchTo().alert().accept();
	       driver.findElement(By.name("logout_btn")).click();
	       
	}
}

