package com.airlinereservationsystemapp.DaoImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

import com.airlinereservationsystemapp.Dao.SourceInterface;
import com.airlinereservationsystemapp.Models.Flight_Seat_Availability;
import com.airlinereservationsystemapp.Models.Flight_list;
import com.airlinereservationsystemapp.Models.Source;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.*;
import java.time.LocalDate;

public class SourceDao implements SourceInterface
{
	public List<Flight_Seat_Availability> ListSeat(String source,String destination) throws ClassNotFoundException, SQLException  

	{
		List<Flight_Seat_Availability> Seatavailabilitylist = new ArrayList<>();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			
			String sql = " SELECT b.flight_id,b.flight_name,b.source,b.destination,a.flight_departure_date,a.ecomomy_seats,a.premium_economy_Seats,a.business_seats, b.Economy_class, b.Premium_Economy_class, b.Bussiness_class, b.ArrivalTime , a.DepartureTime FROM Flight_Seats_availabilty a join Flight_details b on a.flight_id = b.flight_id WHERE b.source = ? AND b.destination  = ? and a.flight_departure_date >= ?";
			
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, source);
			pst.setString(2, destination);
			pst.setDate(3,getcurrentdate() );;
		    System.out.println(source);
		    System.out.println(destination);
			ResultSet rs1 = pst.executeQuery();
			
				System.out.println("Valid");
				while (rs1!=null && rs1.next()) {
				{
					System.out.println("hello1");
					int Flight_id = rs1.getInt("flight_id");
					
					String Flight_name = rs1.getString("flight_name");
					String Source = rs1.getString("Source");
					String flight_destination = rs1.getString("Destination");
				   Date Departure_Time = rs1.getDate("Flight_Departure_date");
					int economyClass = rs1.getInt("Ecomomy_seats");
					int premiumeconomyclass = rs1.getInt("Premium_Economy_Seats");
					int businessClass = rs1.getInt("Business_Seats");
					double Economy_rate = rs1.getDouble("Economy_class");
					double premium_economy_rate = rs1.getDouble("Premium_Economy_class");
					double Bussiness_rate = rs1.getDouble("Bussiness_class");
					java.sql.Timestamp  time = rs1.getTimestamp("ArrivalTime");
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					sdf.setTimeZone(TimeZone.getTimeZone("IST"));
					String arrived = sdf.format(time); 	
					java.sql.Timestamp  Time = rs1.getTimestamp("DepartureTime");
					sdf.setTimeZone(TimeZone.getTimeZone("IST"));
					String Departed = sdf.format(Time); 	



					
					
					
					
					Flight_Seat_Availability objFlightseat = new Flight_Seat_Availability(Flight_id,Flight_name,Source, flight_destination, Departure_Time, economyClass,  premiumeconomyclass, businessClass,Economy_rate,premium_economy_rate,Bussiness_rate,arrived,Departed);
					
					Seatavailabilitylist.add(objFlightseat);
					
					Sorting object = new Sorting();
					
					Collections.sort(Seatavailabilitylist , object);

					
					
				
			       
			}
		
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
return Seatavailabilitylist;
	}
	private static Date getcurrentdate()
	{
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}
	public List<Flight_Seat_Availability> Seatvalue(String source,String destination,LocalDate date) throws ClassNotFoundException, SQLException  

	{
		List<Flight_Seat_Availability> Seatavailabilitylist = new ArrayList<>();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			
			String query = " SELECT b.flight_id,b.flight_name,b.source,b.destination,a.flight_departure_date,a.ecomomy_seats,a.premium_economy_Seats,a.business_seats, b.Economy_class, b.Premium_Economy_class, b.Bussiness_class, b.ArrivalTime , a.DepartureTime FROM Flight_Seats_availabilty a join Flight_details b on a.flight_id = b.flight_id WHERE  a.flight_departure_date >= ?";
			
			int i=1;

			if(source != null)
			{
			   System.out.println("SOuedgvcsvcdgjvcvgjcxv enterttefd");
			    query += "and b.source = ?";
			    
			}
			if(destination != null)
			{
				   System.out.println("Destination  enterttefd");
   
			    query += "and b.destination = ?";
			   
			}
			if(date != null)
			{
				   System.out.println("Datetet enterttefd");

			
			   query += "and a.flight_departure_date = ?";
			
			}
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setDate(1,getcurrentdate() );
			if(source != null && source != "")
			{
			    i++;
			    System.out.println("dskhjfgdvfhdfhfdhvalue of    i   "+i);
			    pst.setString(i,source);
			}
			if(destination != null && destination!= "")
			{
			    i++;
			    System.out.println("dskhjfgdvfhdfhfdhvalue of    i   "+i);

			    pst.setString(i,destination);
			}
			if(date != null)
			{
			i++;
		    System.out.println("dskhjfgdvfhdfhfdhvalue of    i   "+i);

			pst.setDate(i,java.sql.Date.valueOf(date));
			}
			
			
		    System.out.println(source);
		    System.out.println(destination);
			ResultSet rs1 = pst.executeQuery();
			
				System.out.println("Valid");
				while (rs1!=null && rs1.next()) {
				{
					System.out.println("hello1");
					int Flight_id = rs1.getInt("flight_id");
					
					String Flight_name = rs1.getString("flight_name");
					String Source = rs1.getString("Source");
					String flight_destination = rs1.getString("Destination");
				   Date Departure_Time = rs1.getDate("Flight_Departure_date");
					int economyClass = rs1.getInt("Ecomomy_seats");
					int premiumeconomyclass = rs1.getInt("Premium_Economy_Seats");
					int businessClass = rs1.getInt("Business_Seats");
					double Economy_rate = rs1.getDouble("Economy_class");
					double premium_economy_rate = rs1.getDouble("Premium_Economy_class");
					double Bussiness_rate = rs1.getDouble("Bussiness_class");
					java.sql.Timestamp  time = rs1.getTimestamp("ArrivalTime");
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					sdf.setTimeZone(TimeZone.getTimeZone("IST"));
					String arrived = sdf.format(time); 	
					java.sql.Timestamp  Time = rs1.getTimestamp("DepartureTime");
					sdf.setTimeZone(TimeZone.getTimeZone("IST"));
					String Departed = sdf.format(Time); 	



					
					
					
					
					Flight_Seat_Availability objFlightseat = new Flight_Seat_Availability(Flight_id,Flight_name,Source, flight_destination, Departure_Time, economyClass,  premiumeconomyclass, businessClass,Economy_rate,premium_economy_rate,Bussiness_rate,arrived,Departed);
					
					Seatavailabilitylist.add(objFlightseat);
					
					Sorting object = new Sorting();
					
					Collections.sort(Seatavailabilitylist , object);

					
					
				
			       
			}
		
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
return Seatavailabilitylist;
	}



	public List<Source> ListSource() throws ClassNotFoundException, SQLException  

	{
		List<Source> SourceList = new ArrayList<>();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			System.out.println("connection established"+con);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from flight_details");
			//out.println("123");
			while(rs.next())
			{
				
				String Source = rs.getString("Source");
				String destination = rs.getString("Destination");
				
				
				Source objFlight = new Source(Source, destination);
				
				SourceList.add(objFlight);
				
				
			}
		       
		}
		catch(Exception e)
		{
			//out.println("connection established qqww");
		}
return SourceList;
	}

}
















