package com.BANKDOM_1.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplemetationClass implements IRetryAnalyzer {
 
	int count=0;
	int retryLimit=3;
	public boolean retry(ITestResult arg0) {
		
		if(count<retryLimit)
		{
			count++;
			return true;
		}
		return false;
	}

}
