package com.airlinereservationsystemapp.DaoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.airlinereservationsystemapp.Controller.UpdateFlightServlet;
import com.airlinereservationsystemapp.Dao.AddFlightInterface;
import com.airlinereservationsystemapp.Models.AddFlight;
import com.airlinereservationsystemapp.Models.Flight;
import com.airlinereservationsystemapp.Models.Flight_list;





public class AddFlightDao implements AddFlightInterface
{
	public int    AddFlightDetails(AddFlight fly ) throws ClassNotFoundException
	{
		 Integer FlightId = 0;
		 String returnCols[] = { "Flight_Id" };
	
	try
	{
		 
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
	String sql = "insert into flight_details (Flight_name,Source,Destination,Economy_class,Premium_Economy_class,Bussiness_class,Arrival_Date,Departure_Date,ArrivalTime) values(?,?,?,?,?,?,?,?,?)";
	PreparedStatement stmt = con.prepareStatement(sql , returnCols);
	System.out.println(fly.getFlight_name());
	System.out.println("Pravenn Kumar");
	 
	stmt.setString(1,fly.getFlight_name() );
	System.out.println("Name ");
	stmt.setString(2,fly.getSource());
	stmt.setString(3,fly.getDestination());
	System.out.println("Destination");
	stmt.setInt(4,fly.getEconomy_class());
	stmt.setInt(5,fly.getPremium_Economy_class());
	stmt.setInt(6,fly.getBussiness_class());
	stmt.setDate(7, java.sql.Date.valueOf(fly.getArrival_Date()));
	stmt.setDate(8, java.sql.Date.valueOf(fly.getDeparture_Date()));

	stmt.setTime(9,java.sql.Time.valueOf( fly.getArrivalTime()));
	System.out.println("Time ");

	 stmt.executeUpdate();
	 
	 
	 
    // if (stmt.executeUpdate() > 0) { 
    		System.out.println(returnCols);
    		
         java.sql.ResultSet generatedKeys = stmt.getGeneratedKeys();
         if (generatedKeys.next()) 
        		System.out.println(generatedKeys);
          FlightId =  generatedKeys.getInt(1); 
        //}

	
	
}
catch(SQLException e)
{
	e.printStackTrace();
	System.out.println(e);

}	
    return FlightId;

}
	public void Addseats(int flightid , String Source, String Destination, int economyseats, int premiumseats , int bussinessseats, LocalDate Departure_Date,LocalTime DepartureTime ) throws ClassNotFoundException, SQLException
	{
		System.out.println("Method Inside");
		
		
		System.out.println(flightid);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		
	String query =  "insert into flight_seats_availabilty (Source,Destination,Flight_id,Ecomomy_seats,premium_economy_seats,business_seats,flight_departure_date,DepartureTime)values(?,?,?,?,?,?,?,?)";
		
		PreparedStatement stmt1 =  con.prepareStatement(query);
		
		stmt1.setString(1, Source);
		stmt1.setString(2, Destination);
		stmt1.setInt(3,flightid);
		stmt1.setInt(4,economyseats);
		stmt1.setInt(5,premiumseats);
		stmt1.setInt(6,bussinessseats);
		stmt1.setDate(7, java.sql.Date.valueOf(Departure_Date));
		stmt1.setTime(8,java.sql.Time.valueOf(DepartureTime ));


		int str = stmt1.executeUpdate();
		//con.commit();
		System.out.println("Finished");

		
	}
	
	
	
	
	
	
	
	
	
	public void  DeleteFlight(int Flight_id) throws Exception
	{
		
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
    CallableStatement cstmt = con.prepareCall("{call DeleteFlight(? )}");
    System.out.println("Delete  Details");
    cstmt.setInt(1, Flight_id);
    System.out.println("Delete Method ");
    cstmt.executeUpdate();

    
    

	}
	
	
	public void updateFlight(int flightid , String flightname, String Source, String Destination , int Economy_class, int premium_Economy_class , int Bussiness_class, LocalDate Arrival_Date, LocalDate Departure_Date,String Status,String loggedinadmin) throws Exception
	{
		System.out.println("Method update ");
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
	
    CallableStatement cstmt = con.prepareCall("{call UpdateFlight(?,?,?,?,?,?,?,?,?,?,? )}");

    System.out.println("Class Details");
    cstmt.setInt(1, flightid);
    cstmt.setString(2, flightname);
    cstmt.setString(3, Source);
    cstmt.setString(4, Destination);
    cstmt.setInt(5, Economy_class);
    cstmt.setInt(6, premium_Economy_class);
    cstmt.setInt(7, Bussiness_class);
    cstmt.setDate(8, java.sql.Date.valueOf(Arrival_Date));
    cstmt.setDate(9, java.sql.Date.valueOf(Departure_Date));
    cstmt.setString(10, Status);
    cstmt.setString(11, loggedinadmin);



    

    System.out.println("Method update3 ");
    cstmt.executeUpdate();
	}
	
	
	public List<Flight> register()
	{
		List<Flight> registerlist = new ArrayList<>();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			System.out.println("connection established"+con);
			//out.println("connection established"+con);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from register where is_admin != 'yes'");
			System.out.println("connection established"+con);
			while(rs.next())
			{
				String Name   = rs.getString("Names");
				System.out.println(Name);
				String emailid = rs.getString("Email_id");
				String username = rs.getString("User_name");
				String password = rs.getString("Password");
				String Gender = rs.getString("Gender");
			long phonenumber = rs.getLong("Phone_Number");
				Date Registereddate = rs.getDate("Registered_Date");


				
				Flight objregister =  new Flight(Name, emailid, username, password, Gender, phonenumber,Registereddate );
						
						registerlist.add(objregister);
				
				
			}
		}
		catch(Exception e)
		{
			//out.println("connection established qqww");
		}
return registerlist;
				   
	}
	@Override
	public void updateFlight(int flightid, String flightname, String Source, String Destination, int Economy_class,
			int premium_Economy_class, int Bussiness_class) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Addseats(int flightid, String Source, String Destination, int economyseats, int premiumseats,
			int bussinessseats, LocalDate Departure_Date) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}




}








