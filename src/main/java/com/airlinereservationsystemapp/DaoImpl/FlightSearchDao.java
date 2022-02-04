
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
import com.airlinereservationsystemapp.Models.Flight_list; 

public class FlightSearchDao implements FlightSearchInterface
{
	public List<Flight_list> FlightList()
	{
		List<Flight_list> flightList = new ArrayList<>();

		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		
		Statement stmt = con.createStatement();
		String sql = "SELECT b.flight_id,b.flight_name,b.arrival_date,b.arrivaltime,a.DepartureTime,b.source,b.destination,a.flight_departure_date,a.ecomomy_seats,a.premium_economy_Seats,a.business_seats, b.Economy_class, b.Premium_Economy_class, b.Bussiness_class,a.Flight_Status FROM Flight_Seats_availabilty a inner join Flight_details b on a.flight_id = b.flight_id  ";
		ResultSet rs = stmt.executeQuery(sql);
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


			Flight_list objFlight = new Flight_list(flightId, airlines, Source, destination, economyClass, premiumeconomyclass, businessClass, Arrival_Time, Departure_Time, economyseats, premiumseats, bussiness, dateStr,departured,flightstatus);

			flightList.add(objFlight);
			
			
		}
	}
	catch(Exception e)
	{
	}
return flightList;
			   
				   
	}
				   
	

		public Flight_list getRecordById(int flightId) {
		Flight_list flight = null;
	
		try {
			

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			
				String sql = "SELECT * FROM flight_details WHERE flight_Id = ? ";
			
			
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, flightId);
			ResultSet rs = pst.executeQuery();	
			if(rs != null)
			{
				while(rs.next())
				{
					System.out.println("Time");
					int id = rs.getInt("flight_Id");
					String airlines = rs.getString("flight_name");
					String source = rs.getString("source");
					String destination = rs.getString("destination");
//					Date Arrival_Time = rs.getDate("Arrival_Date");
//					Date Departure_Time = rs.getDate("Departure_Date");				
					int firstClass= rs.getInt("economy_class");
					int economyClass = rs.getInt("premium_economy_class");
					System.out.println("Class file ");
					int businessClass = rs.getInt("bussiness_class");
					System.out.println("Bssiness class");
					Date Arrival_Time = rs.getDate("Arrival_Date");
					Date Departure_Time = rs.getDate("Departure_Date");				


					flight = new Flight_list(id, airlines,Arrival_Time,Departure_Time,source,destination,firstClass,economyClass,businessClass);

					
					
				}
			}
			

			
		} 
		catch (SQLException | ClassNotFoundException e) {
			
		} 
		return flight;
	}
		
		
		

}
