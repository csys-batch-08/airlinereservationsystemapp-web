package com.airlinereservationsystemapp.DaoImpl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.airlinereservationsystemapp.Dao.FlightRegisterInterface;
import com.airlinereservationsystemapp.Models.AddFlight;
import com.airlinereservationsystemapp.Models.Flight;
import com.airlinereservationsystemapp.Models.Passenger_details;


public class FlightRegisterDao implements FlightRegisterInterface
{
	public void Registration( Flight objFlightRegister) throws ClassNotFoundException 
	{
		try
		{
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			
			String sql = "insert into register (Names,Email_id,User_name,Password,gender,Phone_number,Registered_date) values(?,?,?,?,?,?,?)";
			//System.out.println(objFlightRegister.getName());
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, objFlightRegister.getName());
			stmt.setString(2, objFlightRegister.getEmailid());
			stmt.setString(3, objFlightRegister.getUsername());
			stmt.setString(4, objFlightRegister.getPassword());
			stmt.setString(5, objFlightRegister.getGender());
			stmt.setLong(6, objFlightRegister.getPhonenumber());
			stmt.setDate(7, getcurrentdate());
			int str = stmt.executeUpdate();
			System.out.println("Completed :" +str);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println(e);

		}
	}
		private static Date getcurrentdate()
		{
			java.util.Date today = new java.util.Date();
			return new java.sql.Date(today.getTime());
		}
			
	

	

	
     public String  guestcheck(long phone, String mail) throws ClassNotFoundException, SQLException
     {
		 String  roles = null ;
		 String returnCols[] = { "ROLES" };
		 
		 

    	 System.out.println("Method COme Inisdedssdds");
    	 Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			
			String sql = "select * from Guestvalid where Phone_Number = ? and Email_id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, phone);
			stmt.setString(2, mail);
			ResultSet rs = stmt.executeQuery();
			System.out.println("Ready For Login Vlaidation");
			if(rs.next())
			{
				System.out.println("Error Checking and Login checking");
//		         java.sql.ResultSet rs1 = stmt.getResultSet();
//		         if (rs1.next()) 
//		        		System.out.println("Genretatetednbba ndandvdhahvahda");
		          roles =  rs.getString("Roles"); 
		      }
			else
			{
				System.out.println("Error Checking and Login DFaodkekekekkdd");

		        //  roles =  rs.getString("Roles") ; 
				
				System.out.println(roles);
				
				return roles;

			}
			return roles;
     }
     public void insertguestvalid(long phone, String mail) throws ClassNotFoundException, SQLException
     {
    	 System.out.println("Method Inserguestdhsvhshhvdhvhdvhdhvdshvdshvdvhdhvdvhdhv Inisdedssdds");
    	 Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

			String query = "insert into Guestvalid (PHONE_NUMBER,EMAIL_ID) values(?,?)";
			PreparedStatement state = con.prepareStatement(query);
			state.setLong(1, phone);
			state.setString(2, mail);
			state.executeUpdate();
			System.out.println("Insert Checking");

     }
     
     public List<Passenger_details> CancelTicket(long mobile)
 	{
 		List<Passenger_details> canceldetails = new ArrayList<>();
 		try 
 		{
 			System.out.println("Cancel come inside");
 			System.out.println("sfkjnfbdbfdbnffdnfdb"+mobile);
 		Class.forName("oracle.jdbc.driver.OracleDriver");
 		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
 		System.out.println("Weleocme to add flight ");
 		String sql = "select a.Class , a.Mobile_number, a. Source , a.Destination, a.FLight_id,c.flight_departure_date ,a.ticket_no , a.Seat_no ,a.Status,a.Booked_date,b.TotalAmount , b.ModeofTransaction from passenger_details a inner join paymentdetails b on a.seat_no = b.seatno inner join flight_seats_availabilty c on a.FLight_id = c.flight_id  inner join Guestvalid e on e.PHONE_NUMBER = a.Mobile_number where Mobile_number = ?";

 		
 		PreparedStatement pst = connection.prepareStatement(sql);
 		pst.setLong(1, mobile);
 		ResultSet rs = pst.executeQuery();
 		if(rs != null)
 		{
 			System.out.println("Valid");
 			while (rs.next()) 
 			{
 				String  Class =  rs.getString(1);
 				System.out.println(Class);
 				long  mobno =  rs.getLong(2);
 				String  source =  rs.getString(3);
 				String  destination =  rs.getString(4);
 				Date  Departreddate =  rs.getDate(6);
 				  LocalDate localDate2 = Departreddate.toLocalDate();
 System.out.println(localDate2);
 				int  flightid =  rs.getInt(5);
 				System.out.println(flightid);

 				int  seatno =  rs.getInt(8);
 				int  ticketno =  rs.getInt(7);
 				String  status =  rs.getString(9);
 				Date  bookingdate =  rs.getDate(10);
 			  LocalDate bookdate = bookingdate.toLocalDate();
 			  String amountmode = rs.getString(12);
 			  int amount = rs.getInt(11);
 			  System.out.println("amount"+amount);
 			  

 				
 				System.out.println(bookingdate);
 				
 				
 				Passenger_details passenegr = new Passenger_details(Class, mobno, source, destination, localDate2, ticketno, seatno,status,bookdate,flightid,amountmode,amount);
 				canceldetails.add(passenegr);
 				}
 		
 	}
 	
 	
 	
 	}
 		catch(Exception e)
 		{
 			System.out.println(e.getMessage());
 			System.out.println(e);
 		}
 		return canceldetails;
 }


	
}
			
			
			
			


	

