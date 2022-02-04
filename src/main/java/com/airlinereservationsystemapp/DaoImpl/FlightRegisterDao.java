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
import com.airlinereservationsystemapp.Models.Flight;
import com.airlinereservationsystemapp.Models.Passenger_details;


public class FlightRegisterDao implements FlightRegisterInterface
{
		private static Date getcurrentdate()
		{
			java.util.Date today = new java.util.Date();
			return new java.sql.Date(today.getTime());
		}
			
		public int Fileregistration( Flight objFlightRegister) throws ClassNotFoundException 
		{
			int str = 0;

			try
			{
			
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
				
				String sql = "insert into register (Names,Email_id,User_name,Password,gender,Phone_number,Registered_date) values(?,?,?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, objFlightRegister.getName());
				stmt.setString(2, objFlightRegister.getEmailid());
				stmt.setString(3, objFlightRegister.getUsername());
				stmt.setString(4, objFlightRegister.getPassword());
				stmt.setString(5, objFlightRegister.getGender());
				stmt.setLong(6, objFlightRegister.getPhonenumber());
				stmt.setDate(7, getcurrentdate());
				 str = stmt.executeUpdate();
				insertwalletFlight(objFlightRegister);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				System.out.println(e);

			}
			return str;
		}

  
		public void insertwalletFlight (Flight objFlightRegister)throws ClassNotFoundException, SQLException
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			String query = "insert into wallet_details (User_name,Wallet_amount) values(?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, objFlightRegister.getUsername());
			stmt.setInt(2, 0);
			 int fdgdgstr = stmt.executeUpdate();
			 System.out.println(fdgdgstr);

			
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
		          roles =  rs.getString("Roles"); 
		      }
			else
			{
				System.out.println("Error Checking and Login DFaodkekekekkdd");

				
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
 				int  flightid =  rs.getInt(5);
 				System.out.println(flightid);

 				int  seatno =  rs.getInt(8);
 				int  ticketno =  rs.getInt(7);
 				String  status =  rs.getString(9);
 				Date  bookingdate =  rs.getDate(10);
 			  LocalDate bookdate = bookingdate.toLocalDate();
 			  String amountmode = rs.getString(12);
 			  int amount = rs.getInt(11);
 			  

 				
 				
 				
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

	@Override
	public String Registration(Flight objFlightRegister) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
			
			
			
			


	


