package com.airlinereservationsystemapp.DaoImpl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.airlinereservationsystemapp.Dao.LoginDaoInterface;
import com.airlinereservationsystemapp.Models.Flight;
import com.airlinereservationsystemapp.Models.Flight_Seat_Availability;
import com.airlinereservationsystemapp.Models.Flight_list;

public class LoginDao implements LoginDaoInterface
{
	 
	public  Boolean Loginfile( String username, String password) throws Exception
	{
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		
		String sql = "SELECT * FROM register WHERE user_name = ? AND password =?";
		
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, username);
		pst.setString(2, password);
	
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			return true;
		}
	       
	       return false;
			
	}
	
	public  String CheckAdmin( String username, String password) throws Exception
	{
		
		String admin = "";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		System.out.println("Weleocme to add flight ");
		String sql = "SELECT * FROM register WHERE user_name = ? AND password =?";
		
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, username);
		pst.setString(2, password);
	    System.out.println(username);
	    System.out.println(password);
		ResultSet rs = pst.executeQuery();
		if(rs != null)
		{
			System.out.println("Valid");
			while (rs.next()) {
				 admin =  rs.getString("Is_Admin");
				 System.out.println(admin);
				 if(admin.equalsIgnoreCase("yes"))
				 {
					 System.out.println(admin);
					 return admin = "yes";
				 }
				 else
				 {
					 return admin = "No";
				 }
				
			}
		       
		}
		
	      return admin;
			
	}
	
	public  void updatepassword( String username,String password) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		System.out.println("Weleocme to add flight ");
		 String sql = "update register set password = ?   where user_name = ?";
		

		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, password);
		pst.setString(2, username);
	    System.out.println(username);
	   
	    pst.executeUpdate();
		
	      
	}

	@Override
	public List<Flight_Seat_Availability> GetflightDetails(String source, String destination) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}