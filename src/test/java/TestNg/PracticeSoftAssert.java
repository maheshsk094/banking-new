package TestNg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PracticeSoftAssert {
	
	@Test
	public void create()
	{
		System.out.println("--step1");
		System.out.println("--step2");
		 SoftAssert sa=new SoftAssert();
		 sa.assertEquals("A", "B");
		 System.out.println("--step3");
		 sa.assertAll();
		
	}

}
