package com.crm.SDET26.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	@Test
public void SampleJDBCExecuteUpdate() throws SQLException {
	  Driver driver = new Driver();
	  DriverManager.registerDriver(driver);
	  
	 Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/SDET26", "root", "root");
	 
	 Statement stat = con.createStatement();
	 
	 int result  = stat.executeUpdate("insert into empinfo values('spiderman' , 15 , 'mali');");
	 if(result==1) {
		 Reporter.log("data inserted succesfully",true);
	 } else {
		 Reporter.log("data is not inserted successfully",true);
	 }
	 con.close();
	} 
  
}


