package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airlinereservationsystemapp.Models.FlightSeatAvailability;

/**
 * Servlet implementation class Addpassenger
 */
@WebServlet("/Addpassenger")
public class Addpassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Addpassenger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session  = request.getSession();
		try
		{
	    String flight_id = request.getParameter("flightId");
		int flightId = Integer.parseInt(flight_id);
    	String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String DepartureDate = request.getParameter("Departure_Date");
		Date  Departure_Date = java.sql.Date.valueOf(DepartureDate) ;
		String Economyclass = request.getParameter("Economyrate");
        Double Economyrate  = Double.parseDouble(Economyclass);
		String PremiumEconomyclass = request.getParameter("Premiumrate");
		Double Premiumrate = Double.parseDouble(PremiumEconomyclass);
		String Bussinessclass = request.getParameter("Business");
		double Business = Double.parseDouble(Bussinessclass);
		String Economyclass1 = request.getParameter("Economy_class");
		int Economy_class = Integer.parseInt(Economyclass1);
		String Premiumrate1 = request.getParameter("Premium_Economy_class");
		int Premium_Economy_class = Integer.parseInt(Premiumrate1);
		String Businesseat = request.getParameter("Bussiness_class");
		int Bussiness_class =  Integer.parseInt(Businesseat);
		FlightSeatAvailability flight  = new 	FlightSeatAvailability(flightId, source, destination,  Departure_Date, Economy_class, Premium_Economy_class, Bussiness_class, Economyrate, Premiumrate, Business);
		//session.setAttribute("Addlist", flight);
		request.setAttribute("Addlist", flight);
        RequestDispatcher req = request.getRequestDispatcher("addPassenger.jsp");
		req.forward(request, response);
      //response.sendRedirect("addPassenger.jsp");
		}
		catch(Exception e)
		{
			e.getMessage();
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
