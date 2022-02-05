package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airlinereservationsystemapp.DaoImpl.FlightSearchDao;
import com.airlinereservationsystemapp.Models.Flight_list;
import com.airlinereservationsystemapp.Models.Passenger_details;

/**
 * Servlet implementation class ConfirmDetails
 */
@WebServlet("/ConfirmDetails")
public class ConfirmDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		try
		{
		  String Flight_Id =request.getParameter("flightId");
		  int flightid = Integer.parseInt(Flight_Id);
		String name = request.getParameter("username");
		String date = request.getParameter("departuredate");
       LocalDate local = LocalDate.parse(date);
		String Source = request.getParameter("source");
		String Destination = request.getParameter("destination");
      String mobno = request.getParameter("MobileNumber");
      long mobileno = Long.parseLong(mobno);
		String class_details = request.getParameter("coach");
		//String seat  = request.getParameter("SEAT_NO");
		//int seat_no = Integer.parseInt(seat);
       String noofpassengers = request.getParameter("numberOfPassengers");
       int noofpass = Integer.parseInt(noofpassengers);
       String economyseats = request.getParameter("Economy_class");
       int ecoseats = 0;
//		if 	(economyseats != null && economyseats != "") 
		if 	(economyseats != null) 

		{
			ecoseats = Integer.parseInt(economyseats);
		}

	     
			String premiumeconomyseats = request.getParameter("PremiumEconomyclass");
			int premiumecoseats = 0;
//		if 	(premiumeconomyseats != null && premiumeconomyseats != "") 
		if 	(premiumeconomyseats != null) 

			{
			 premiumecoseats = Integer.parseInt(premiumeconomyseats);
			}
		
	      String businesseats = request.getParameter("Bussinessclass");
	      
			int bussseats = 0;
//		if 	(businesseats != null && businesseats != "") 
			if 	(businesseats != null ) 

			{
			bussseats = Integer.parseInt(businesseats);
			}

      String Price_details = request.getParameter("price");
      int price = Integer.parseInt(Price_details);
     //  Date Bookingdate =(Date) new SimpleDateFormat("yyyy-mm-dd").parse(date);
       
      // Date Bookingdate = (Date) sdf.parse(date);
     //int price = Integer.parseInt(Price_details);
       
		 int ticketno = generator();
     Passenger_details passenger = new Passenger_details(name, class_details, mobileno, Source, Destination,local,ecoseats,premiumecoseats,bussseats,flightid,noofpass,ticketno,price);
     
     request.setAttribute("Passenger_Deatils", passenger);
     
     RequestDispatcher requestDispatcher = request.getRequestDispatcher("confirmdetails.jsp");
		requestDispatcher.forward(request, response);
		
		
		FlightSearchDao flightDao = new FlightSearchDao();
		Flight_list flight = flightDao.getRecordById(flightid);
		int busrate =  flight.getBussiness_class();
		int prerate =  flight.getPremium_Economy_class();
        int ecorate =   flight.getEconomy_class();
		
		
		request.setAttribute("Economy", ecorate);
		request.setAttribute("Premium", prerate);
		request.setAttribute("Bussiness", busrate);



		
		}
		catch(Exception e)
		{
			
			 System.out.println(e.getMessage());
		}
	}

	public int generator()
	{
		Random r = new Random(System.currentTimeMillis());
		return 100 + r.nextInt(1200);
	}
	
}
