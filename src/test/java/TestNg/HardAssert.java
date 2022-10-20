package TestNg;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.Assert.*;  //if we write assert.*  then no need to write Assert.assetEquals import assetEquals from in condition 13th line
import org.testng.annotations.Test;

public class HardAssert {
	
	@Test
	public void create(){
		System.out.println("-step1");
		System.out.println("-step2");
		System.out.println("-step3");
		assertEquals("A", "B", "notmatching");         //notmatching will display in output
		System.out.println("-step4");
		System.out.println("-step5");
	}
	
			

	@Test
	public void update(){
		System.out.println("-step6");
		System.out.println("-step7");
		assertEquals("X", "Y", "notmatching");
		System.out.println("-step8");
	}

}
