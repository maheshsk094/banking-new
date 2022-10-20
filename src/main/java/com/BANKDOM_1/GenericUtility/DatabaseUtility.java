package com.BANKDOM_1.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Result;
import com.mysql.jdbc.Driver;

/**
 * This class contains generic methods to read data from database
 * @author user
 */

public class DatabaseUtility {
	
	/**
	 * This method is used to get database connection
	 */
			
	Connection con=null;  // global variabel

	public void connectToDB() throws Throwable{
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
	 con = DriverManager.getConnection(IpathConstants.dbURL, IpathConstants.dbUsername, IpathConstants.dbPassword); // create global variable
	}
	
	/*
	 * This method will excecute the query and return the matching data to the user
	 * @param query
	 * @param columnIndex
	 * @param expDta
	 * @return
	 * @throws Throeable
	 */

	
	 public String excecutequeryAndGetData(String query, int columnIndex, String expData) throws Throwable
	 {
		 String data=null;
		 boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		 while(result.next())
		 {
			data= result.getString(columnIndex);
			 if (data.equalsIgnoreCase(expData)) 
			 {
				 flag=true;   // flag rising
				 break;
				
			}
		 }
		 if(flag)
		 {
			 System.out.println(data+"-->data verified");
			 return expData;
		 }
		
		 else {
			System.out.println(data+"-->data not verified");
			return "";
		}
			 
		 }
	 /**
	  * This method is used to close the database
	 * @throws Throwable 
	  * @throws Throwable
	  */
	 public void closeDB() throws Throwable
	 {
		con.close(); 
	 }
}
