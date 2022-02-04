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
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.airlinereservationsystemapp.Controller.UpdateFlightServlet;
import com.airlinereservationsystemapp.Dao.AddFlightInterface;
import com.airlinereservationsystemapp.Models.AddFlight;
import com.airlinereservationsystemapp.Models.Flight;
import com.airlinereservationsystemapp.Models.Flight_list;
import com.util.Connectutil;





public class AddFlightDao implements AddFlightInterface
{
	public int    AddFlightDetails(AddFlight fly ) throws ClassNotFoundException
	{
		 Integer FlightId = 0;
		 String returnCols[] = { "Flight_Id" };
		 Connection con = null;
	     PreparedStatement stmt = null;

	
	try
	{
		 
	//Class.forName("oracle.jdbc.driver.OracleDriver");
	//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
	 con = Connectutil.getdbconnect();
	String sql = "insert into flight_details (Flight_name,Source,Destination,Economy_class,Premium_Economy_class,Bussiness_class,Arrival_Date,Departure_Date,ArrivalTime) values(?,?,?,?,?,?,?,?,?)";
	 stmt = con.prepareStatement(sql , returnCols);
	 
	stmt.setString(1,fly.getFlight_name() );
	stmt.setString(2,fly.getSource());
	stmt.setString(3,fly.getDestination());
	stmt.setInt(4,fly.getEconomy_class());
	stmt.setInt(5,fly.getPremium_Economy_class());
	stmt.setInt(6,fly.getBussiness_class());
	stmt.setDate(7, java.sql.Date.valueOf(fly.getArrival_Date()));
	stmt.setDate(8, java.sql.Date.valueOf(fly.getDeparture_Date()));

	stmt.setTime(9,java.sql.Time.valueOf( fly.getArrivalTime()));

	 stmt.executeUpdate();
	 
	 
	 
    // if (stmt.executeUpdate() > 0) { 
    		
         java.sql.ResultSet generatedKeys = stmt.getGeneratedKeys();
         if (generatedKeys.next()) 
          FlightId =  generatedKeys.getInt(1); 
        //}

	
	
}
catch(SQLException e)
{
	e.printStackTrace();

}	
	finally
	{
		Connectutil.close(con,stmt);
	}
    return FlightId;

}
	public void Addseats(int flightid , String Source, String Destination, int economyseats, int premiumseats , int bussinessseats, LocalDate Departure_Date,LocalTime DepartureTime ) 
	{
		 Connection con = null;
	     PreparedStatement stmt = null;

		try {
		
		 con = Connectutil.getdbconnect();		
	String query =  "insert into flight_seats_availabilty (Source,Destination,Flight_id,Ecomomy_seats,premium_economy_seats,business_seats,flight_departure_date,DepartureTime)values(?,?,?,?,?,?,?,?)";
		
	stmt =  con.prepareStatement(query);
		
	stmt.setString(1, Source);
	stmt.setString(2, Destination);
	stmt.setInt(3,flightid);
		stmt.setInt(4,economyseats);
		stmt.setInt(5,premiumseats);
		stmt.setInt(6,bussinessseats);
		stmt.setDate(7, java.sql.Date.valueOf(Departure_Date));
		stmt.setTime(8,java.sql.Time.valueOf(DepartureTime ));


		int str = stmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			Connectutil.close(con,stmt);	
		}
		
	}
	
	
	
	
	
	
	
	
	
	public void  DeleteFlight(int Flight_id) 
	{
		 Connection con = null;
		 CallableStatement cstmt = null;
  
	     try {
    	
	 con = Connectutil.getdbconnect();
     cstmt = con.prepareCall("{call DeleteFlight(? )}");
    cstmt.setInt(1, Flight_id);
    cstmt.executeUpdate();
	     }
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	     }
	     finally
	     {
	    	 Connectutil.close(con,cstmt);
	     }
    
    

	}
	
	
	public String updateFlight(int flightid , String flightname, String Source, String Destination , int Economy_class, int premium_Economy_class , int Bussiness_class, LocalDate Arrival_Date, LocalDate Departure_Date,String Status,String loggedinadmin) 
	{
		 Connection con = null;
		 CallableStatement cstmt = null;
		 String rres = null;
   try
   {
	
	 con = Connectutil.getdbconnect();
	
     cstmt = con.prepareCall("{call UpdateFlight(?,?,?,?,?,?,?,?,?,?,?,?)}");


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

    cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);

    cstmt.executeUpdate();

     rres =  cstmt.getNString(12);
   }
   
   catch(Exception e)
   {
	   e.printStackTrace();
   }
   
   finally
   {
  	 Connectutil.close(con,cstmt);
   }

     return rres;
     
	}
	
	
	public List<Flight> register()
	{
		List<Flight> registerlist = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try
		{
			 con = Connectutil.getdbconnect();
		//	Statement stmt = con.createStatement();
			 stmt = con.prepareStatement("select * from register where is_admin != 'yes'");
			 rs = stmt.executeQuery();
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
			e.printStackTrace();
		}
		finally
		{
			Connectutil.close(con,stmt,rs);
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








