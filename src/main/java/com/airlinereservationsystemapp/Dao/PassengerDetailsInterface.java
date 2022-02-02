package com.airlinereservationsystemapp.Dao;

import java.util.List;

import com.airlinereservationsystemapp.Models.Passenger_details;

public interface PassengerDetailsInterface 
{
	public int PassengerDetails(Passenger_details obj,int ticketno,String username);
	
	public List<Passenger_details> Bookinglist();
	
	
	public  void Updatepassenger(int economyseats , int premiumseats, int businessseats,String Coach, int Flightid);


	public List<Passenger_details> CancelTicket(String Username);
	
	public  void Updatecancelstatus(int seatno);
	


}
