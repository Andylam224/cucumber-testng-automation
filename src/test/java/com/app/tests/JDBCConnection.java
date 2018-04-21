package com.app.tests;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.util.SystemOutLogger;
import org.testng.annotations.Test;

public class JDBCConnection {
	String oracleDbUrl="jdbc:oracle:thin:@ec2-35-170-245-33.compute-1.amazonaws.com:1521:xe";
	String oracleDbPassword="hr";
	String oracleDbUsername="hr";
	
	@Test
	public void oracleJDBC() throws SQLException {
		Connection connection=DriverManager.getConnection(oracleDbUrl, oracleDbUsername, oracleDbPassword);
		//Statement statement=connection.createStatement();
		Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet=statement.executeQuery("select * from countries");
//		resultSet.next();
//		System.out.println(resultSet.getString("Country_name"));
//		System.out.println(resultSet.getString(1));
//		System.out.println(resultSet.getInt("region_id"));
//		
//		resultSet.next();
//		System.out.println(resultSet.getString("Country_name"));
//		System.out.println(resultSet.getString(1));
//		System.out.println(resultSet.getInt("region_id"));
//		
//		resultSet.next();
//		System.out.println(resultSet.getString("Country_name"));
//		System.out.println(resultSet.getString(1));
//		System.out.println(resultSet.getInt("region_id"));
		
//	while(resultSet.next()) {
//		System.out.println(resultSet.getString(1)+"-"+resultSet.getString("country_name")+"-"+resultSet.getInt("region_id"));
//	}
//		resultSet.next();
//		System.out.println(resultSet.getRow());
//		//prints 0 since it starts at the beginning
//		
//		resultSet.previous();
//		resultSet.first();
//		resultSet.last();
//		System.out.println(resultSet.getRow());
//		tells you how many records are there
		
	//find out how many records in the resultset
		resultSet.last();
		int rowsCount=resultSet.getRow();
		System.out.println("Number of rows: "+ rowsCount);
		
	
	
	

	statement.close();
	resultSet.close();
	connection.close();
	}

	@Test
	public void jdbcMetaData() throws SQLException {
		Connection connection=DriverManager.getConnection(oracleDbUrl, oracleDbUsername, oracleDbPassword);
		Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		//String sql="select employee_id, last_name,job_id,salary from employees";
		String sql="select * from employees";
		ResultSet resultSet=statement.executeQuery(sql);
		
		//Database metadata
		DatabaseMetaData dbMetadata=connection.getMetaData();
		System.out.println("User:"+ dbMetadata.getUserName());
		System.out.println("Database type:"+ dbMetadata.getDatabaseProductName());
		
	//	resultSet metadata
		ResultSetMetaData rsMetadata=resultSet.getMetaData();
		System.out.println("Columns count:"+rsMetadata.getColumnCount());
		System.out.println(rsMetadata.getColumnName(1));
		//print all column names using a loop
		for(int i=1;i<=rsMetadata.getColumnCount();i++) {
			System.out.println(i+"->"+ rsMetadata.getColumnName(i));
		}
		
		//Throw result into a List of Maps
		//create a list of maps
		
		List<Map<String,Object>> list=new ArrayList<>();
	//	ResultSetMetaData rsMdata= resultSet.getMetaData();
		
		int columnCount=rsMetadata.getColumnCount();
		System.out.println(rsMetadata.getColumnName(1));
		resultSet.beforeFirst();
		while(resultSet.next()) {
			Map<String,Object>rowMap=new HashMap<>();
			
			for(int col=1;col<=columnCount;col++) {
				rowMap.put(rsMetadata.getColumnName(col), resultSet.getObject(col));
			}
			
			list.add(rowMap);

		}
	
		//print all employee ids from a list of maps
		for(Map<String, Object> map:list)
			System.out.println(map.get("EMPLOYEE_ID"));
		
		

		statement.close();
		resultSet.close();
		connection.close();
	}
		
		
		
		
		
	}


