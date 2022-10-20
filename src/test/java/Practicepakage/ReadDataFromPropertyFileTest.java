package Practicepakage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromPropertyFileTest {

	public static void main(String[] args) throws IOException {
	//create object for sourcefile
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.Properties");
		
		//create object for propertyfile
		Properties pObj=new Properties();
		//load
		pObj.load(fis);
		//get the data from Common data file
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
	    String PASSWORD = pObj.getProperty("password");
	    
	    System.out.println(BROWSER);
	    System.out.println(URL);
	    System.out.println(USERNAME);
	    System.out.println(PASSWORD);
	    
	 // WebDriverManager.chromedriver().setup();
	  //WebDriver driver=new ChromeDriver();
	    WebDriverManager.firefoxdriver().setup();
	    WebDriver driver=new FirefoxDriver();
	  driver.get(URL);
	  
	  
	/* WebElement ele = driver.findElement(By.xpath("(//a[@href='#''])[8]"));
	  Actions a=new Actions(driver);
	  a.moveToElement(ele).perform();
	  driver.findElement(By.xpath("//a[.='Login']")).click();

	  */
	driver.findElement(By.xpath("//a[.='Staff Login']")).click();
	    	

	}

}
