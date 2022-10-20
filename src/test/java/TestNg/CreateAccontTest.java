package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.BANKDOM_1.GenericUtility.BaseClass;
import com.BANKDOM_1.ObjectRepository.HomePage;
import com.BANKDOM_1.ObjectRepository.OpenAccountPage;

@Listeners(com.BANKDOM_1.GenericUtility.ListenerImplementaionClass.class)   //its for screenshot(copy qualified path from ListenerImplementaionClass select and right click on className and copy as qualified path)
public class CreateAccontTest extends BaseClass {

	@Test
public  void createAccount() throws Throwable {	
			
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
	    
        Assert.fail();                                                                // failed for screenshot
        
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
	}
	
	@Test
	public void modifyCustomer()
	{
		System.out.println("modify customer details");
	}
	
	@Test
	public void deleteCustomer()
	{
		System.out.println("deleted customer details");
	}
	
}
