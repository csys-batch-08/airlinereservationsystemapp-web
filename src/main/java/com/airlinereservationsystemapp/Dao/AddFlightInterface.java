package com.airlinereservationsystemapp.Dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.airlinereservationsystemapp.Models.AddFlight;
import com.airlinereservationsystemapp.Models.Flight;

public interface AddFlightInterface 
{
	public int    AddFlightDetails(AddFlight fly ) throws ClassNotFoundException;
	
	public void Addseats(int flightid , String Source, String Destination, int economyseats, int premiumseats , int bussinessseats, LocalDate Departure_Date ) throws ClassNotFoundException, SQLException;
	
	public void  DeleteFlight(int Flight_id) throws Exception;
	
	public void updateFlight(int flightid , String flightname, String Source, String Destination , int Economy_class, int premium_Economy_class , int Bussiness_class) throws Exception;
	
	public List<Flight> register();
	
}
