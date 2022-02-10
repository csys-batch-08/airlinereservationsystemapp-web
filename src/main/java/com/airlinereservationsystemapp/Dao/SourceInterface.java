package com.airlinereservationsystemapp.Dao;

import java.sql.SQLException;
import java.util.List;

import com.airlinereservationsystemapp.Models.FlightSeatAvailability;
import com.airlinereservationsystemapp.Models.Source;

public interface SourceInterface 
{
	public List<FlightSeatAvailability> ListSeat(String source,String destination) throws ClassNotFoundException, SQLException ;
	
	public List<Source> ListSource() throws ClassNotFoundException, SQLException ;  



}
