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

public class ListenerImplementaionClass implements ITestListener {

	
	public void onTestStart(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		Reporter.log(MethodName+"--testScript execution started--");		
	}
	

	public void onTestSuccess(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		Reporter.log(MethodName+"--testScript execution started--");	
	}
	
	
	public void onTestFailure(ITestResult result) {
		
		String FailedScript = result.getMethod().getMethodName();
		String Fscript = FailedScript+ new JavaUtility().systemDate();     // its for date and time
		
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.sDriver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshot\\"+Fscript+".png");  // take Fscript in FailedScript for date & time
		try 
		{
			FileUtils.copyFile(src, dst);    //only write this try catch automatically takes
		} 
		catch (IOException e) 
		{			
			e.printStackTrace();
		}
		
	}
	
	

	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		Reporter.log(MethodName+"--testScript execution skipped--");			
	}
	
	
public void onFinish(ITestContext context) {
		
	}

	public void onStart(ITestContext context) { 
		
	}





}
