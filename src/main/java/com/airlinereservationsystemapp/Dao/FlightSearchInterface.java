package com.airlinereservationsystemapp.Dao;

import java.util.List;

import com.airlinereservationsystemapp.Models.Flight_list;

public interface FlightSearchInterface 
{
	public List<Flight_list> FlightList();
	
	public Flight_list getRecordById(int flightId) ;
	



}
