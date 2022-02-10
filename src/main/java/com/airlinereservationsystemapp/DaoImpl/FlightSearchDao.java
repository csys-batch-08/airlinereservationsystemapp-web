
package com.airlinereservationsystemapp.DaoImpl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import com.airlinereservationsystemapp.Dao.FlightSearchInterface;
import com.airlinereservationsystemapp.Models.FlightList;
import com.util.Connectutil; 

public class FlightSearchDao implements FlightSearchInterface
{
	public List<FlightList> FlightList()
	{
		List<FlightList> flightList = new ArrayList<>();
		Connection con =null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = Connectutil.getdbconnect();
		String sql = "SELECT b.flight_id,b.flight_name,b.arrival_date,b.arrivaltime,a.DepartureTime,b.source,b.destination,"
				+ "a.flight_departure_date,a.ecomomy_seats,a.premium_economy_Seats,a.business_seats, b.Economy_class, "
				+ "b.Premium_Economy_class, b.Bussiness_class,a.Flight_Status FROM Flight_Seats_availabilty a inner join Flight_details b "
				+ "on a.flight_id = b.flight_id  ";
		 stmt = con.prepareStatement(sql);
		 rs = stmt.executeQuery();
		while(rs.next())
		{
			int  flightId = rs.getInt("flight_id");
			String airlines = rs.getString("flight_name");
			String Source = rs.getString("source");
			String destination = rs.getString("destination");
			int economyClass = rs.getInt("Economy_Class");
			int premiumeconomyclass = rs.getInt("premium_Economy_class");
			int businessClass = rs.getInt("Bussiness_class");
			Date Arrival_Time = rs.getDate("arrival_date");
			Date Departure_Time = rs.getDate("flight_departure_date");
			int economyseats = rs.getInt("ecomomy_seats");
			int premiumseats = rs.getInt("premium_economy_Seats");
			int bussiness = rs.getInt("business_seats");
			java.sql.Timestamp time  = rs.getTimestamp("arrivaltime");
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			sdf.setTimeZone(TimeZone.getTimeZone("IST"));
			String dateStr = sdf.format(time); 	
			java.sql.Timestamp Time  = rs.getTimestamp("DepartureTime");
			sdf.setTimeZone(TimeZone.getTimeZone("IST"));
			String departured = sdf.format(Time); 	
			String flightstatus = rs.getString("Flight_Status");
			FlightList objFlight = new FlightList(flightId, airlines, Source, destination, economyClass, premiumeconomyclass, businessClass, Arrival_Time, Departure_Time, economyseats, premiumseats, bussiness, dateStr,departured,flightstatus);
			flightList.add(objFlight);
		}
	}
	catch(Exception e)
	{
		e.getMessage();
	}
		finally
		{
			Connectutil.close(con,stmt,rs);
		}
return flightList;
	}
		public FlightList getRecordById(int flightId) 
		{
		FlightList flight = null;
		Connection con = null;
	     PreparedStatement pst = null;
          ResultSet rs = null;
		try {
			con = Connectutil.getdbconnect();
					String sql = "SELECT FLIGHT_ID,FLIGHT_NAME,SOURCE,DESTINATION,ECONOMY_CLASS,PREMIUM_ECONOMY_CLASS,BUSSINESS_CLASS,"
							+ "ARRIVAL_DATE,DEPARTURE_DATE FROM flight_details WHERE flight_Id = ? ";
			 pst = con.prepareStatement(sql);
			pst.setInt(1, flightId);
			 rs = pst.executeQuery();	
			if(rs != null)
			{
				while(rs.next())
				{
					int id = rs.getInt("flight_Id");
					String airlines = rs.getString("flight_name");
					String source = rs.getString("source");
					String destination = rs.getString("destination");
//					Date Arrival_Time = rs.getDate("Arrival_Date");
//					Date Departure_Time = rs.getDate("Departure_Date");				
					int firstClass= rs.getInt("economy_class");
					int economyClass = rs.getInt("premium_economy_class");
					int businessClass = rs.getInt("bussiness_class");
					Date Arrival_Time = rs.getDate("Arrival_Date");
					Date Departure_Time = rs.getDate("Departure_Date");				
					flight = new FlightList(id, airlines,Arrival_Time,Departure_Time,source,destination,firstClass,economyClass,businessClass);
				}
			}
		} 
		catch (Exception e) 
		{
			e.getMessage();
		} 
		finally
		{
			Connectutil.close(con,pst,rs);
		}
		return flight;
	}
}
