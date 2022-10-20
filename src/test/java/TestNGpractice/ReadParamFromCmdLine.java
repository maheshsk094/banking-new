package TestNGpractice;

import org.testng.annotations.Test;

public class ReadParamFromCmdLine {
	
	@Test
	public void parameters()
	{
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		System.out.println("BROWSER");	
		System.out.println("URL");
	}

}
