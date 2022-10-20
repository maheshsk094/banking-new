package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.Query;
import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabaseTest {

	public static void main(String[] args) throws SQLException {
		
		Driver driver=new Driver();
		//step1: register the database
		DriverManager.registerDriver(driver);
		
		//step2:get connection for database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdom", "root", "root");
		
		//step3: issue create statement
		Statement stat = con.createStatement();
		String query = "select* from bank";
		
		
		//step4: execute query
	 ResultSet result = stat.executeQuery(query);
	 while(result.next())         //to fetch all columns data
	 {
		System.out.println(result.getString(1)+""+result.getInt(2));
	 }
		
		//step5: close database
		con.close();
		 

	}

}
