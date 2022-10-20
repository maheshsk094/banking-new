package MySQL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.BANKDOM_1.GenericUtility.PropertyFileUtility;
import com.BANKDOM_1.GenericUtility.WebdriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccontTest {
	
public static void main(String[] args) throws Throwable {

		PropertyFileUtility pLib=new PropertyFileUtility();
		WebdriverUtility wLib=new WebdriverUtility();
		

		String URL = pLib.ReadDataFromPropertyFile("url");
			
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
	
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
			
		//Open account
		
		driver.findElement(By.xpath("//a[.=' International Banking']")).click();	
		driver.findElement(By.xpath("(//a[.='Open Account'])")).click();
	    driver.quit();
		
    }



}
