package com.airlinereservationsystemapp.Dao;

import java.util.List;

import com.airlinereservationsystemapp.Models.Flight_Seat_Availability;

public interface LoginDaoInterface 
{
	public  Boolean Loginfile( String username, String password) throws Exception;

	
	public  String CheckAdmin( String username, String password) throws Exception ;
	
	public  List<Flight_Seat_Availability> GetflightDetails( String source, String destination) throws Exception ;
	
	public  void updatepassword( String username,String password) throws Exception ;




}
