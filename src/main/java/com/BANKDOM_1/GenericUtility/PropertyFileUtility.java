package com.BANKDOM_1.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class contains
 * @author user
 *
 */
public class PropertyFileUtility {
	
	/**
	 * This class will read data from property file
	 * @param key
	 * @return
	 * @throws Throwable 
	 * @throws Throwable
	 */

	public String ReadDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.Filepath);
		Properties pLib=new Properties();
		pLib.load(fis);
		String value=pLib.getProperty(key);
				
		return value;
		
	}
}
