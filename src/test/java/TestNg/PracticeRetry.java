package TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeRetry {
	
	@Test(retryAnalyzer=com.BANKDOM_1.GenericUtility.RetryImplemetationClass.class)   //qualified path from RetryImplemetationClass
	public void retry()
	{
		System.out.println("--Test 1--");
		System.out.println("--Test 2--");
		Assert.fail();
		System.out.println("--Test 3--");
	}

}
