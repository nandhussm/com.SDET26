package com.crm.SDET26.practice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
public class SampleJDBCExecuteQuery {
	@Test
	public void SampleJDBCExecuteQuery() throws SQLException {
		
	
		//step 1 = register to db
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//step2 = get connection from db - provide db name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet26", "root", "root");
		
		//step 3 = issue create statement 
		Statement state = con.createStatement();
		
		//step 4 = execute a query = provide table name
		ResultSet result = state.executeQuery("select * from empinfo;");
		
		while(result.next()) {
			System.out.println(result.getString(1));
		}
		//step 5 = close the connection
		con.close();
		
	}
   
    
   
}
