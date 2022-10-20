package com.BANKDOM_1.GenericUtility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImplementationClass  implements ITestListener{
	
	ExtentReports report;     //line 73
	ExtentTest test;         //line 26
	
	public void onTestStart(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"--testScript execution started--");		
	}
	

	public void onTestSuccess(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"--->passed");
		Reporter.log(MethodName+"--testScript execution started--");	
	}
	
	
	public void onTestFailure(ITestResult result) {
		
		String FailedScript = result.getMethod().getMethodName();
	//String Fscript = FailedScript+ new JavaUtility().systemDate();     // its for date and time
		
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.sDriver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
		String path=".\\Screenshot\\"+FailedScript+".png";
		File dst = new File(path);  // take Fscript in FailedScript for date & time
		try 
		{
			FileUtils.copyFile(src, dst);    //only write this try catch automatically takes
		} 
		catch (IOException e) 
		{			
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(path);
		
	}
	
	

	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.FAIL, MethodName+"--->skipped");
		
		//it will capture the exception and log it in the group
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"--testScript execution skipped--");			
	}
	
	
public void onStart(ITestContext context) { 
	//Execution starts here
	//configure the report
	ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report.html");
	htmlReport.config().setDocumentTitle("BANKDOM Execution Report");
	htmlReport.config().setTheme(Theme.DARK);
	htmlReport.config().setReportName("BANKDOM Execution Report");
	
	report=new ExtentReports();             //global
	
	report.attachReporter(htmlReport);
	report.setSystemInfo("Base Browser", "Chrome");
	report.setSystemInfo("OS", "wINDOWS");
	report.setSystemInfo("bASE-url", "http://192.168.0.231/domain/Online_Banking_System/index.php");
	report.setSystemInfo("Report Name", "Mahesh");	
	}


public void onFinish(ITestContext context) {
		
	//consolidate all the parameters and generate the report
	report.flush();
	}

	
}
