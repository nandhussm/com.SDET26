package com.crm.SDET26.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
@Test
public class ByUsingTryAndCatchAndFinalyBlock {
     
     public  void ByUsingTryAndCatchAndFinalyBlock() throws SQLException {
    	 Connection con = null;
    	 try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Reporter.log("registered successfully",true);
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet26", "root", "root");
		 Reporter.log("connection successfully",true); 
		
		Statement stat = con.createStatement();
		Reporter.log("statement successfully",true);
		
		ResultSet result = stat.executeQuery("select * from empinfo;");
		Reporter.log("result successfully",true);
		while(result.next()) {
			System.out.println(result.getString(1));
		}
		
     }
     catch(Exception e) {
    	Reporter.log("exception handling succesful"); 
     }
    	 finally {
    		 con.close();
    	 }
    	 
}
}
