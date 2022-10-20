package com.BANKDOM_1.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.BANKDOM_1.ObjectRepository.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public DatabaseUtility dLib=new DatabaseUtility();
	public JavaUtility jLib=new JavaUtility();
	public ExcelFileUtility eLib=new ExcelFileUtility();
	public PropertyFileUtility pLib=new PropertyFileUtility();
	public WebdriverUtility wLib=new WebdriverUtility();
	public WebDriver driver;
	public static WebDriver sDriver;    // for listener
	
/*	@BeforeSuite (groups={"smoke","regression"})
	public void connectToDB() throws Throwable
	{
		dLib.connectToDB();
		System.out.println("-->connect to DB");
	}          */
	
	
	@BeforeClass(groups={"smoke","regression"})
	public void launchBrowser() throws Throwable
	{
		System.out.println("-->launch browser--");
		String BROWSER=pLib.ReadDataFromPropertyFile("browser");
		
	//	if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		} 
/*		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}        
		else
		{
			driver=new InternetExplorerDriver();
		}           */
	
/*	@Parameters("BROWSER")
	@BeforeClass(groups={"smoke","regression"})               // for cross browser execution
	public void launchBrowser(String BROWSER) throws Throwable
	{
		System.out.println("-->launch browser--");
	//	String BROWSER=pLib.ReadDataFromPropertyFile("browser");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}        
		else
		{
			driver=new InternetExplorerDriver();
		}    */
		
		sDriver=driver;     // for listener refer line 24
		wLib.waitForPageLoad(driver);
		wLib.maximizeWindow(driver);
	}
	
	@BeforeMethod (groups={"smoke","regression"})
	public void login() throws Throwable
	{
		String URL=pLib.ReadDataFromPropertyFile("url");
		String USERNAME=pLib.ReadDataFromPropertyFile("username");
		String PASSWORD=pLib.ReadDataFromPropertyFile("password");
		
		driver.get(URL);
		
/*		StaffLoginPage slp=new StaffLoginPage(driver);
		slp.loginPage(USERNAME, PASSWORD);      */
	}
	
	@AfterMethod (groups={"smoke","regression"})
	public void logot()
	{
		HomePage hp=new HomePage(driver);
		hp.staffLogin();
	}
	
	@AfterClass (groups={"smoke","regression"})
	public void closeBrowser()
	{
		driver.quit();
	}
	
/*	@AfterSuite (groups={"smoke","regression"})
	public void closeDB() throws Throwable
	{
		dLib.closeDB();
		System.out.println("-> close DB");
	}          */
		
	
}
