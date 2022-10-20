package com.BANKDOM_1.GenericUtility;

import java.util.Date;
import java.util.Random;

/**
 * This class contains Java specific generic methods
 * @author user
 *
 */
public class JavaUtility {
	
	/*
	 * This method is used to get random number within the boundary from 0 to 10000
	 */
	
	public int randomNumber()
	{
		Random ran=new Random();
		int random = ran.nextInt();
		return random;
	}
	
	public String systemDate()
	{
		/**
		 * This method is used to get systemDate and Time
		 */
		Date date = new Date();
		String systemDate=date.toString().replaceAll(":", "-");             //repace all foe date format
		return systemDate;
	}

}
