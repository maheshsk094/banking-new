package TestNg;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.BANKDOM_1.GenericUtility.BaseClass;
import com.BANKDOM_1.ObjectRepository.ApplyDebitCardPage;
import com.BANKDOM_1.ObjectRepository.ApprovePendingAcc;
import com.BANKDOM_1.ObjectRepository.HomePage;
import com.BANKDOM_1.ObjectRepository.OpenAccountPage;
import com.BANKDOM_1.ObjectRepository.StaffHomePage;
import com.BANKDOM_1.ObjectRepository.StaffLoginPage;

public class ApplyDebitCard extends BaseClass {
	@Test
	public  void createAccount() throws Throwable {
			
			
			//get data commonDta from property file
			String USERNAME = pLib.ReadDataFromPropertyFile("username");
			String PASSWORD = pLib.ReadDataFromPropertyFile("password");
							
			//Open account
			HomePage hp=new HomePage(driver);
			hp.openAccount();
		
			OpenAccountPage oap=new OpenAccountPage(driver);
			oap.openAccountPage(eLib.readDataFronExcelFile("Sheet1", 1, 0), "Male", eLib.readDataFronExcelFile("Sheet1", 1, 1), eLib.readDataFronExcelFile("Sheet1", 1, 2), 
					eLib.readDataFronExcelFile("Sheet1", 1, 3),eLib.readDataFronExcelFile("Sheet1", 1, 4), eLib.readDataFronExcelFile("Sheet1", 1, 5), 
					eLib.readDataFronExcelFile("Sheet1", 1, 6), eLib.readDataFronExcelFile("Sheet1", 1, 7), eLib.readDataFronExcelFile("Sheet1", 1, 11),
					eLib.readDataFronExcelFile("Sheet1", 1, 12), eLib.readDataFronExcelFile("Sheet1", 1, 8), eLib.readDataFronExcelFile("Sheet1", 1, 9),
					eLib.readDataFronExcelFile("Sheet1", 1, 14));
		
			WebElement date = driver.findElement(By.xpath("//input[@placeholder='Date of Birth']"));
		    date.click();
		    date.sendKeys("10AA", Keys.TAB,"2022"); // ("10121996", Keys.TAB, "")
		    driver.findElement(By.name("submit")).click();
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
		
			hp.staffLogin();
			StaffLoginPage slp=new StaffLoginPage(driver);
			slp.loginPage(USERNAME, PASSWORD);
	
		//Approve account
		StaffHomePage shp=new StaffHomePage(driver);
		shp.apprvAcc();
		
		ApprovePendingAcc apa=new ApprovePendingAcc(driver);
		apa.approveAcc(applicationNumber);
	
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
	   
	 //Apply debit card
	 		String pans = (eLib.readDataFronExcelFile("Sheet1", 1, 4));
	 		String mbl = (eLib.readDataFronExcelFile("Sheet1", 1, 1));//to enter numeric value
	 		String names = (eLib.readDataFronExcelFile("Sheet1", 1, 0));
	 		hp.homeLink();
	 		hp.applyDebitCard();
	 		
	 		ApplyDebitCardPage adc=new ApplyDebitCardPage(driver);
	 		adc.applyDebitCard(names, pans, mbl, AccountNumber);
	 			 		
	 		WebElement date1 = driver.findElement(By.xpath("//input[@placeholder='Date of Birth']"));
	 		date1.click();
	 		date1.sendKeys("10AA", Keys.TAB,"2022");
	 		
	 		Thread.sleep(4000);
	 		driver.findElement(By.name("dbt_crd_submit")).click();
	 		Thread.sleep(4000);
	 	
	 	 Alert alert = driver.switchTo().alert();
	 	String pinCode = alert.getText().split("Pin is : ")[1].split(" ")[0].trim();   //to get Debit card no. and pin separately
	 	String debitcardNumber= alert.getText().split("Debit Card No is : ")[1].split(" ")[0].trim();
	 	System.out.println(pinCode);
	 	System.out.println(debitcardNumber);
	 	Thread.sleep(2000);
	 	alert.accept();
	 	hp.homeLink();
	}
		
}
