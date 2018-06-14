package com.company.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCTools {
	static DataSource dataSource = null;
	 static{
		dataSource = new ComboPooledDataSource("hello");
	 }
	 
	 public static Connection getConnection(){
		 Connection conn = null;
		 try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return conn;
	 }
	 	 
	 public static void closeConnection(Connection conn){
		 if(conn != null){
			 try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	 }
	  
	 public static void main(String[] args) {
		System.out.println(getConnection());
	}
	
}
