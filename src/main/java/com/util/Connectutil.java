package com.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Connectutil 
{
	public static Connection getdbconnect()
	{
	
	Connection con = null;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
     }
	catch(Exception e)
	{
		e.getMessage();
	}
	return con;

	}
	
	public static void close(Connection connection, PreparedStatement pst, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (connection != null) {
				connection.close();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
		public static void close(Connection connection, PreparedStatement pst) {
			try {
				if (pst != null) {
					pst.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) 
			{
				e.getMessage();
			}
	}
		public static void close(Connection connection, CallableStatement pst) {
			try {
				if (pst != null) {
					pst.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) 
			{
				e.getMessage();
			}
	}

}

	
