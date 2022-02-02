package com.airlinereservationsystemapp.Dao;

import java.sql.SQLException;

public interface WalletInterface 
{
	public  int getclosingbalance( String username) throws Exception;
	
	public  int checkusername( String username) throws Exception;
	
	public  void insetbalance( String username,int Amount) throws Exception;
	
	public  void updatebalance( String username,int Amount) throws Exception;

	
	public void InserPaymentdetails(int Flightid, int Ticketno , int totalamount , String modeoftransaction,String username) throws ClassNotFoundException, SQLException;




}
