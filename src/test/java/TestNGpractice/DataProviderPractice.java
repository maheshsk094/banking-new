package TestNGpractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider="getDat")
	public void travelling(String src, String dst)
	{
		System.out.println(src+"---->"+dst);
	}
	
	@DataProvider
	public Object[][] getDat()
	{
		Object[][] obj=new Object[3][2];
				obj[0][0] = "Bangalore";
				obj[0][1] = "Badami";	
				
				obj[1][0] = "Maldives";
				obj[1][1] = "Delhi";	
				
				obj[2][0] = "Bangalore";
				obj[2][1] = "Hubli";	
				return obj;
						
	}
	
	

}
