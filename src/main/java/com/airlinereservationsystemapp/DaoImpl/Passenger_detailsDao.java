package com.airlinereservationsystemapp.DaoImpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

import com.airlinereservationsystemapp.Dao.PassengerDetailsInterface;
import com.airlinereservationsystemapp.Models.Flight_list;
import com.airlinereservationsystemapp.Models.Passenger_details;

public class Passenger_detailsDao implements PassengerDetailsInterface
{
	public int Setnogenerated(Passenger_details obj,int ticketno,String username)
	{
		 int seatno = 0;
		 String returnCols[] = { "Seat_no" };

		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		System.out.println("inside 11");
		String sql = "insert into passenger_details (PASSENGER_NAME,CLASS,MOBILE_NUMBER,SOURCE,DESTINATION,FLIGHT_ID,Departured_Date,Ticket_no,Status,User_name,Booked_Date) values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql,returnCols);
		stmt.setString(1,obj.getPassenger_name());
		System.out.println("inside 1");
		stmt.setString(2,obj.getClass_details());
		stmt.setLong(3,obj.getMobile_number());
		stmt.setString(4, obj.getSource());
		System.out.println("Inside2 ");
		stmt.setString(5, obj.getDestination());
		stmt.setInt(6,obj.getFlight_id());
		System.out.println("inside foldr");
		stmt.setDate(7,java.sql.Date.valueOf( obj.getArrival_date()));
		stmt.setInt(8,ticketno);
		stmt.setString(9, "Booked");
		stmt.setString(10, username);
		stmt.setDate(11, getcurrentdate());


		int str2 = stmt.executeUpdate();
		
		System.out.println(returnCols);
		
        java.sql.ResultSet generatedKeys = stmt.getGeneratedKeys();
        if (generatedKeys.next()) 
       		System.out.println(generatedKeys);
         seatno =  generatedKeys.getInt(1); 
        System.out.println(seatno);

	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		System.out.println(e);
		
	}
		return seatno;
}

	
	
	
	
	private static java.sql.Date getcurrentdate()
	{
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}
	
	public List<Passenger_details> Bookinglist()
	{
		List<Passenger_details> booklist = new ArrayList<>();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			System.out.println("connection established"+con);
			
			//out.println("connection established"+con);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from passenger_details");
			//out.println("123");
			while(rs.next())
			{
				String  name = rs.getString(1);
				String classdetails = rs.getString(2);
				System.out.println("Coming method inside");
				long mobno  = rs.getLong(3);
				String Source = rs.getString(4);
				String destination = rs.getString(5);
                LocalDate Bookingdate = rs.getDate(6).toLocalDate();
				System.out.println(Bookingdate);
				int flightid = rs.getInt(7);
				int seatno = rs.getInt(8);
				int ticketno = rs.getInt(9);
				String status = rs.getString(10);
				LocalDate Registereddate  = rs.getDate(12).toLocalDate();
				System.out.println(Registereddate);

				
				



				
				
				Passenger_details passenegr = new Passenger_details(name, classdetails, mobno, Source, destination,Bookingdate,ticketno,seatno,status,Registereddate,flightid);
				booklist.add(passenegr);

				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
return booklist;
				   
	}
	
	public  void Updatepassenger(int economyseats , int premiumseats, int businessseats,String Coach, int Flightid) 
	{
		System.out.println("Update Passenger Method");
		 try
		 {
			 System.out.println("hi");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			System.out.println("inside 11");
			String sql = "";

			if(Coach.equalsIgnoreCase("Economy"))
					{
				System.out.println(economyseats);
				 sql = "update flight_seats_availabilty set ECOMOMY_SEATS = ?   where FLIGHT_ID = ?";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setInt(1,economyseats);
					stmt.setInt(2,Flightid);
					stmt.executeUpdate();





					}
			else if(Coach.equalsIgnoreCase("premium"))
			{
				 sql = "update flight_seats_availabilty set PREMIUM_ECONOMY_SEATS = ?   where FLIGHT_ID = ?";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setInt(1,premiumseats);
					stmt.setInt(2,Flightid);
					 stmt.executeUpdate();




			}
			else if(Coach.equalsIgnoreCase("Bussiness"))
			{
				 sql = "update flight_seats_availabilty set BUSINESS_SEATS = ?   where FLIGHT_ID = ?";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setInt(1,businessseats);
					stmt.setInt(2,Flightid);
					 stmt.executeUpdate();



			}
		 }
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }

			
			



			
			

		
	}
	
	public List<Passenger_details> CancelTicket(String Username)
	{
		List<Passenger_details> canceldetails = new ArrayList<>();
		try 
		{
			System.out.println("Cancel come inside");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		System.out.println("Weleocme to add flight ");
		String sql = "select a.Class , a.Mobile_number, a. Source , a.Destination, a.FLight_id,c.flight_departure_date ,a.ticket_no , a.Seat_no , a.Status,a.Booked_date,"
				+ "b.TotalAmount , b.ModeofTransaction from passenger_details a inner join paymentdetails b "
				+ "on a.seat_no = b.seatno inner join flight_seats_availabilty c on a.FLight_id = c.flight_id  where user_name = ?";

		
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, Username);
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
		}
		return canceldetails;
}
	
	
	public  void Updatecancelstatus(int seatno) 
	{
		 try
		 {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			System.out.println("inside 343 11");
			String sql = "";

			System.out.println("Function 1");

				 sql = "update passenger_details set status = ?   where Seat_no = ?";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1,"Cancelled");
					stmt.setInt(2,seatno);
					stmt.executeUpdate();




					System.out.println("Function 2");

					
		
		 }
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }
	}
	
	
	
	public  void Updateticketcount(int flightid , LocalDate DepartureDate , String classdetails,int seats) 
	{
		 try
		 {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			System.out.println("inside 11");
			String sql = "";
          
			System.out.println("Function 3");

            if(classdetails.equalsIgnoreCase("Economy"))
            {
				 sql = "update flight_seats_availabilty set Ecomomy_seats =  ?   where flight_id = ? and Flight_Departure_Date = ?";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setInt(1, seats +1);
					stmt.setInt(2, flightid);
					stmt.setDate(3, java.sql.Date.valueOf(DepartureDate));
					
                 stmt.executeUpdate();
     			System.out.println("Function 4");

            }  
            if(classdetails.equalsIgnoreCase("premium"))
            {
				 sql = "update flight_seats_availabilty set Premium_Economy_Seats =  ?   where flight_id = ? and Flight_Departure_Date = ?";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setInt(1, seats +1);
					stmt.setInt(2, flightid);
					stmt.setDate(3, java.sql.Date.valueOf(DepartureDate));
					
                 stmt.executeUpdate();
     			System.out.println("Function PE4");

            }  
            if(classdetails.equalsIgnoreCase("Bussiness"))
            {
				 sql = "update flight_seats_availabilty set Business_Seats =  ?   where flight_id = ? and Flight_Departure_Date = ?";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setInt(1, seats +1);
					stmt.setInt(2, flightid);
					stmt.setDate(3, java.sql.Date.valueOf(DepartureDate));
					
                 stmt.executeUpdate();
     			System.out.println("Function pe4");

            }     


}
		 
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	}
	
	public  int getticketcount(String classdetails,int flightid, LocalDate DepartureDate) 
	{
		int seats = 0;
		 try
		 {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			//Statement stmt = con.createStatement();
			String sql = "select * from flight_seats_availabilty where Flight_Departure_Date = ? and flight_id =?";
			System.out.println("connection established"+con);
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDate(1, java.sql.Date.valueOf(DepartureDate));
			stmt.setInt(2, flightid);
			
			 ResultSet rs  = stmt.executeQuery();
			while(rs.next())
			{
			
				if(classdetails.equalsIgnoreCase("Economy"))
				{
					

					  seats   = rs.getInt("Ecomomy_Seats");
					System.out.println(seats);
					return seats;

				}
				else if(classdetails.equalsIgnoreCase("premium"))

				{
					  seats   = rs.getInt("Premium_Economy_Seats");
					return seats;
				}
				//else if(classdetails.equalsIgnoreCase("business"))
				else
				{
					  seats   = rs.getInt("Business_Seats");
					return seats;
				}

				
		 }
		 }
		 catch(Exception e)
		 {
			 
		 }
		return seats;
	}





	@Override
	public int PassengerDetails(Passenger_details obj, int ticketno, String username) {
		return ticketno;
		// TODO Auto-generated method stub
		
	}


	
	public  LocalDate getdate()
	{
        LocalDate lt = LocalDate.now();
		return lt;
	}
	

}

	
				   
	





