package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airlinereservationsystemapp.DaoImpl.AddFlightDao;
import com.airlinereservationsystemapp.DaoImpl.FlightRegisterDao;
import com.airlinereservationsystemapp.Models.AddFlight;
import com.airlinereservationsystemapp.Models.Flight;

/**
 * Servlet implementation class AddFlightservlet
 */
@WebServlet("/AddFlightservlet")
public class AddFlightservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlightservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response,AddFlight flight) throws ServletException, IOException 
	{

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
        {
			String flightname = request.getParameter("Flightname");
			String source = request.getParameter("source");           
			String Destination = request.getParameter("Destination");			
			//int age = Integer.parseInt(request.getParameter("age"));
			int   Economyclass = Integer.parseInt(request.getParameter("Economyclass"));
			int   premiumEconomyclass = Integer.parseInt(request.getParameter("PremiumEconomyclass"));
			int   Bussinessclass = Integer.parseInt(request.getParameter("Bussinessclass"));
			System.out.println("Class Details");
	        String  Arrival_time  = request.getParameter("ArrivalDate"); 
            LocalDate local = LocalDate.parse(Arrival_time);
			String Departure_time  =  request.getParameter("DepartureDate");
			LocalDate loca1 = LocalDate.parse(Departure_time);
			DateFormat parseFormat = new SimpleDateFormat("HH:mm:SS");
            String   ArrivalTime  =  request.getParameter("Arrivaltime");
            LocalTime  time = LocalTime.parse(ArrivalTime,DateTimeFormatter.ofPattern("HH:mm"));
            String   Departuretime  =  request.getParameter("Departuretime");   
            LocalTime  time2 = LocalTime.parse(Departuretime,DateTimeFormatter.ofPattern("HH:mm"));
            String economyseats = request.getParameter("ecomomy_seats");
            int ecoseats = Integer.parseInt(economyseats);
            String premiumseats = request.getParameter("premium_economy_seats");
            int preseats = Integer.parseInt(premiumseats);
            String businessseats = request.getParameter("business_seats");
            int busseats = Integer.parseInt(businessseats);
            AddFlightDao adddao = new AddFlightDao();
            AddFlight flight = new AddFlight(flightname, source, Destination, Economyclass, premiumEconomyclass, Bussinessclass,local,loca1,time);             
            int Flight_Id  = adddao.AddFlightDetails(flight);
            System.out.println(Flight_Id);
            adddao.Addseats(Flight_Id, source, Destination,ecoseats,preseats,busseats,loca1,time2);
            response.getWriter().print("Data Registered");
			response.sendRedirect("flightSearch.jsp");				
		} catch (Exception e) {
			System.out.println(e);

		}

		
	}

	private void AddSeats() {
		// TODO Auto-generated method stub
		
	}

}
