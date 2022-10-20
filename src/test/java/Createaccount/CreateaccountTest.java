package Createaccount;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import com.BANKDOM_1.GenericUtility.ExcelFileUtility;
import com.BANKDOM_1.GenericUtility.JavaUtility;
import com.BANKDOM_1.GenericUtility.PropertyFileUtility;
import com.BANKDOM_1.GenericUtility.WebdriverUtility;
import com.BANKDOM_1.ObjectRepository.ApplyDebitCardPage;
import com.BANKDOM_1.ObjectRepository.ApprovePendingAcc;
import com.BANKDOM_1.ObjectRepository.HomePage;
import com.BANKDOM_1.ObjectRepository.InternetBankingRegister;
import com.BANKDOM_1.ObjectRepository.OpenAccountPage;
import com.BANKDOM_1.ObjectRepository.StaffHomePage;
import com.BANKDOM_1.ObjectRepository.StaffLoginPage;
import com.BANKDOM_1.ObjectRepository.VieCustomerByAccNo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateaccountTest {
	private static final CharSequence AccountNumber = null;

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
	//	driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
			
		//Open account
		HomePage hp=new HomePage(driver);
		hp.openAccount();
	//	driver.findElement(By.xpath("(//a[.='Open Account'])")).click();
		
		
		OpenAccountPage oap=new OpenAccountPage(driver);
		oap.openAccountPage(eLib.readDataFronExcelFile("Sheet1", 1, 0), "Male", eLib.readDataFronExcelFile("Sheet1", 1, 1), eLib.readDataFronExcelFile("Sheet1", 1, 2), 
				eLib.readDataFronExcelFile("Sheet1", 1, 3),eLib.readDataFronExcelFile("Sheet1", 1, 4), eLib.readDataFronExcelFile("Sheet1", 1, 5), 
				eLib.readDataFronExcelFile("Sheet1", 1, 6), eLib.readDataFronExcelFile("Sheet1", 1, 7), eLib.readDataFronExcelFile("Sheet1", 1, 11),
				eLib.readDataFronExcelFile("Sheet1", 1, 12), eLib.readDataFronExcelFile("Sheet1", 1, 8), eLib.readDataFronExcelFile("Sheet1", 1, 9),
				eLib.readDataFronExcelFile("Sheet1", 1, 14));
		
	/*	driver.findElement(By.name("name")).sendKeys(eLib.readDataFronExcelFile("Sheet1", 1, 0));
		WebElement ele = driver.findElement(By.name("gender"));
	//	Select s = new Select(ele);
	//	s.selectByVisibleText(sh.getRow(1).getCell(13).toString());
		wLib.select(ele, eLib.readDataFronExcelFile("Sheet1", 1, 13));
		driver.findElement(By.name("mobile")).sendKeys(eLib.readDataFronExcelFile("Sheet1", 1, 1));
		driver.findElement(By.name("email")).sendKeys(eLib.readDataFronExcelFile("Sheet1", 1, 2));
		driver.findElement(By.name("landline")).sendKeys(eLib.readDataFronExcelFile("Sheet1", 1, 3));   */
		WebElement date = driver.findElement(By.xpath("//input[@placeholder='Date of Birth']"));
	    date.click();
	    date.sendKeys("10AA", Keys.TAB,"2022"); // ("10121996", Keys.TAB, "")
	    driver.findElement(By.name("submit")).click();
	    driver.findElement(By.xpath("//input[@type='submit']")).click(); 


	/*	driver.findElement(By.xpath("//input[@placeholder='PAN Number']")).sendKeys(eLib.readDataFronExcelFile("Sheet1", 1, 4));
		driver.findElement(By.name("citizenship")).sendKeys(eLib.readDataFronExcelFile("Sheet1", 1, 5));
		driver.findElement(By.name("homeaddrs")).sendKeys(eLib.readDataFronExcelFile("Sheet1", 1, 6));
		driver.findElement(By.name("officeaddrs")).sendKeys(eLib.readDataFronExcelFile("Sheet1", 1, 7));
		WebElement ele1 = driver.findElement(By.name("state"));
		//Select s1 = new Select(ele1);
		//s1.selectByValue(sh.getRow(1).getCell(11).toString()); // fetch drop down
		wLib.select(ele1, eLib.readDataFronExcelFile("Sheet1", 1, 11));
		WebElement ele2 = driver.findElement(By.name("city"));
		//Select s2 = new Select(ele2);
		//s2.selectByValue(sh.getRow(1).getCell(12).toString());
		wLib.select(ele2, eLib.readDataFronExcelFile("Sheet1", 1, 12));
		driver.findElement(By.name("pin")).sendKeys(eLib.readDataFronExcelFile("Sheet1", 1, 8));
		driver.findElement(By.name("arealoc")).sendKeys(eLib.readDataFronExcelFile("Sheet1", 1, 9));
		WebElement ele3 = driver.findElement(By.name("acctype"));
		//Select s3 = new Select(ele3);
		//s3.selectByValue("Saving");
		wLib.select(ele3, eLib.readDataFronExcelFile("Sheet1", 1, 14));
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();         */
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
		hp.staffLogin();
		StaffLoginPage slp=new StaffLoginPage(driver);
		slp.loginPage(USERNAME, PASSWORD);
		
	/*	driver.findElement(By.xpath("//a[.='Staff Login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("staff_id")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("staff_login-btn")).click();          */

		//Approve account
		StaffHomePage shp=new StaffHomePage(driver);
		shp.apprvAcc();
		
		ApprovePendingAcc apa=new ApprovePendingAcc(driver);
		apa.approveAcc(applicationNumber);
	/*	driver.findElement(By.name("apprvac")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("application_no")).sendKeys(applicationNumber);
		driver.findElement(By.name("search_application")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("approve_cust")).click();     */
		String text1 = driver.switchTo().alert().getText();
		String AccountNumber="";
		for (int i=0;i<text1.length();i++){
			if(Character.isDigit(text1.charAt(i))){
				AccountNumber=AccountNumber+text1.charAt(i);
			}
		}
		System.out.println(AccountNumber);
		
		driver.switchTo().alert().accept();
	   shp.staffHomeBtn();
		//driver.findElement(By.name("home")).click();

		
		//view customer by ac no
		shp.viewByAccNo();
		VieCustomerByAccNo vcbap=new VieCustomerByAccNo(driver);
		vcbap.viewCustomerByAccNo(AccountNumber);
		shp.staffHomeBtn();
	/*	driver.findElement(By.name("view_cust_by_ac")).click();
		driver.findElement(By.name("account_no")).sendKeys(AccountNumber);
		driver.findElement(By.name("submit_view")).click();
		driver.findElement(By.name("home")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("viewdet")).click();//view active customer
		driver.findElement(By.xpath("//a[.='Home']")).click();      */        
		
		
		//Apply debit card
		String pans = (eLib.readDataFronExcelFile("Sheet1", 1, 4));
		String mbl = (eLib.readDataFronExcelFile("Sheet1", 1, 1));//to enter numeric value
		String names = (eLib.readDataFronExcelFile("Sheet1", 1, 0));
		hp.homeLink();
		hp.applyDebitCard();
		ApplyDebitCardPage adc=new ApplyDebitCardPage(driver);
		adc.applyDebitCard(names, pans, mbl, AccountNumber);
		
		//driver.findElement(By.xpath("//a[.='Apply Debit Card']")).click();
		
		WebElement date1 = driver.findElement(By.xpath("//input[@placeholder='Date of Birth']"));
		date1.click();
		date1.sendKeys("10AA", Keys.TAB,"2022");
		
		Thread.sleep(4000);
		driver.findElement(By.name("dbt_crd_submit")).click();
		Thread.sleep(4000);
	//	driver.findElement(By.name("acc_no")).sendKeys(AccountNumber);
	//	driver.findElement(By.name("dbt_crd_submit")).click();
		
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
		
	InternetBankingRegister ibr=new InternetBankingRegister(driver);
	ibr.internetBankRegister(eLib.readDataFronExcelFile("Sheet1", 1, 0), AccountNumber, debitcardNumber, pinCode, eLib.readDataFronExcelFile("Sheet1", 1, 1),
			eLib.readDataFronExcelFile("Sheet1", 1, 4), "0000", eLib.readDataFronExcelFile("Sheet1", 1, 10), eLib.readDataFronExcelFile("Sheet1", 1, 10));
      
      
		/*driver.findElement(By.name("holder_name")).sendKeys(eLib.readDataFronExcelFile("Sheet1", 1, 0));
		driver.findElement(By.name("accnum")).sendKeys(AccountNumber);
		driver.findElement(By.name("dbtcard")).sendKeys(debitcardNumber);
		driver.findElement(By.name("dbtpin")).sendKeys(pinCode);
		driver.findElement(By.name("mobile")).sendKeys(eLib.readDataFronExcelFile("Sheet1", 1, 1));
		driver.findElement(By.name("pan_no")).sendKeys(eLib.readDataFronExcelFile("Sheet1", 1, 4));        */
		
		WebElement date3 = driver.findElement(By.xpath("//input[@placeholder='Date of Birth']"));
		date3.click();
		date3.sendKeys("10AA", Keys.TAB,"2022");
		driver.findElement(By.name("submit")).click();
		
		/*driver.findElement(By.name("last_trans")).sendKeys("0000");
		driver.findElement(By.name("password")).sendKeys(eLib.readDataFronExcelFile("Sheet1", 1, 10));
		driver.findElement(By.name("cnfrm_password")).sendKeys(eLib.readDataFronExcelFile("Sheet1", 1, 10));
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);         */
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
	      // Actions a1= new Actions(driver);
	      //a1.moveToElement(ele5).perform();
		 wLib.mouseHover(driver, ele5);
		
		 
	       driver.findElement(By.xpath("//a[.='Login ']")).click();
	       driver.findElement(By.name("customer_id")).sendKeys(InternetID);
	       driver.findElement(By.name("password")).sendKeys(eLib.readDataFronExcelFile("Sheet1", 1, 10));          
	       driver.findElement(By.name("login-btn")).click();            
	       
	     //change password
	       driver.findElement(By.xpath("//li[.='Change Password']")).click();
	       driver.findElement(By.name("oldpass")).sendKeys(eLib.readDataFronExcelFile("Sheet1", 1, 10));
	       driver.findElement(By.name("cnfrm")).sendKeys(eLib.readDataFronExcelFile("Sheet1", 1, 10));
	       driver.findElement(By.name("newpass")).sendKeys(eLib.readDataFronExcelFile("Sheet1", 1, 11));
	       driver.findElement(By.name("change_pass")).click();
	       Thread.sleep(2000);
	       driver.switchTo().alert().accept();
	       
	       driver.findElement(By.name("logout_btn")).click();
	       driver.quit();
	     
	       
	}
}