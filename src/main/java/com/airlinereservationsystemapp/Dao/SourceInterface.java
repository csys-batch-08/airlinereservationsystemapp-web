package com.airlinereservationsystemapp.Dao;

import java.sql.SQLException;
import java.util.List;

import com.airlinereservationsystemapp.Models.Flight_Seat_Availability;
import com.airlinereservationsystemapp.Models.Source;

public interface SourceInterface 
{
	public List<Flight_Seat_Availability> ListSeat(String source,String destination) throws ClassNotFoundException, SQLException ;
	
	public List<Source> ListSource() throws ClassNotFoundException, SQLException ;  



}
