package com.airlinereservationsystemapp.Dao;

import java.util.List;

import com.airlinereservationsystemapp.Models.PassengerDetails;

public interface PassengerDetailsInterface 
{
	public int PassengerDetails(PassengerDetails obj,int ticketno,String username);
	
	public List<PassengerDetails> Bookinglist();
	
	
	public  void Updatepassenger(int economyseats , int premiumseats, int businessseats,String Coach, int Flightid);


	public List<PassengerDetails> CancelTicket(String Username);
	
	public  void Updatecancelstatus(int seatno);
	


}
