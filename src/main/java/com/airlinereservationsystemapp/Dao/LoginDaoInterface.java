package com.airlinereservationsystemapp.Dao;

import java.util.List;

import com.airlinereservationsystemapp.Models.FlightSeatAvailability;

public interface LoginDaoInterface 
{
	public  Boolean Loginfile( String username, String password) throws Exception;

	
	public  String CheckAdmin( String username, String password) throws Exception ;
	
	
	public  void updatepassword( String username,String password) throws Exception ;




}
