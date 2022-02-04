package com.airlinereservationsystemapp.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.airlinereservationsystemapp.Dao.WalletInterface;

public class WalletDao implements WalletInterface
{
	public  int getclosingbalance( String username) throws Exception
	{
		
//		int Closing_balance = 0;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		System.out.println("Weleocme to add flight ");
		String sql = "SELECT wallet_amount FROM wallet_details WHERE user_name = ?";
		
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, username);
		
	    System.out.println(username);
	   
		ResultSet rs = pst.executeQuery();
//		if(rs != null)
//		{
			int Closing_balance = 0;
			while (rs.next()) {
				 Closing_balance =  rs.getInt("wallet_amount");
				
				
			}
		      return Closing_balance;
  
		
		
	      
	      
			
	}
	
	public  int checkusername( String username) throws Exception
	{
		
		int Closing_balance = 0 ;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		
           String sql = "SELECT wallet_amount FROM wallet_details WHERE user_name = ?";
		
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, username);
		
	   
		ResultSet rs = pst.executeQuery();
//		if(rs != null)
//		{
			
			while (rs.next()) {
				 Closing_balance = rs.getInt("wallet_amount");
	
			}
		
			
		
		return Closing_balance;
	}
		
	public void refundbalance(String username,int refundamount)
	{
		
		try {
		int balance = 	checkusername(username);
		
		
		int discountamount = (int) (refundamount*0.05);
		
		
		
		refundamount = balance +refundamount - discountamount;
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		
           String sql = "update wallet_details set wallet_amount =?  WHERE user_name = ?";
		
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, refundamount);
		pst.setString(2, username);

		ResultSet rs = pst.executeQuery();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	public  void insetbalance( String username,int Amount) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		String query =  "insert into wallet_details (user_name,wallet_amount)values(?,?)";

		PreparedStatement pst = connection.prepareStatement(query);
		pst.setString(1, username);
		pst.setInt(2, Amount);
	   
	    pst.executeUpdate();
		
	      
	}
	
	public  void updatebalance( String username,int Amount) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		 String sql = "update wallet_details set wallet_amount = ?   where user_name = ?";
		

		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, Amount);
		pst.setString(2, username);

	    pst.executeUpdate();
		
	      
	}
	
	public void InserPaymentdetails(int Flightid, int Ticketno , int amount , String modeoftransaction,String username,int seatno) throws ClassNotFoundException, SQLException

	{
		System.out.println(username);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		String sql = "insert into PaymentDetails (FLIGHTID,TICKETNO,TOTALAMOUNT,MODEOFTRANSACTION,Username,Seatno) values(?,?,?,?,?,?)";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, Flightid);
		pst.setInt(2, Ticketno);
		pst.setInt(3, amount);
		pst.setString(4, modeoftransaction);
		pst.setString(5, username);
		pst.setInt(6, seatno);
	    pst.executeUpdate();

	    




		
	}

	@Override
	public void InserPaymentdetails(int Flightid, int Ticketno, int totalamount, String modeoftransaction,
			String username) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}
	
	

}
