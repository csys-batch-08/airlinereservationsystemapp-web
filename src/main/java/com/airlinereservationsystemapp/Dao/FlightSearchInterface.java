package com.airlinereservationsystemapp.Dao;

import java.util.List;

import com.airlinereservationsystemapp.Models.FlightList;

public interface FlightSearchInterface 
{
	public List<FlightList> FlightList();
	
	public FlightList getRecordById(int flightId) ;
	



}
