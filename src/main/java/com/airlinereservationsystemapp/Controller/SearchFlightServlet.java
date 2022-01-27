package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airlinereservationsystemapp.DaoImpl.FlightSearchDao;
import com.airlinereservationsystemapp.DaoImpl.LoginDao;
import com.airlinereservationsystemapp.DaoImpl.SourceDao;
import com.airlinereservationsystemapp.Models.Flight_Seat_Availability;
import com.airlinereservationsystemapp.Models.Flight_list;

/**
 * Servlet implementation class SearchFlight
 */
@WebServlet("/SearchFlight")
public class SearchFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFlightServlet() {
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
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        
       SourceDao objsearchflight = new SourceDao();
     
       	try
		{
		
	        out.println("hello");
	        LocalDate local = null;
	        String Source = "";
	        String Destination = "";
			 Source = request.getParameter("source");
			 System.out.println(Source);
			 Destination = request.getParameter("destination");
			 System.out.println(Destination);
			String date =  request.getParameter("date");
			System.out.println(date);
			if(date!=null && date != "")
			{
			 local = LocalDate.parse(date);
			System.out.println(local);
			}

			//System.out.println(Source);
			//System.out.println(Destination);
		
			
			HttpSession session =  request.getSession();
			
			//List<Flight_Seat_Availability> objavailability = objsearchflight.ListSeat(Source, Destination);
			List<Flight_Seat_Availability> objavailability = objsearchflight.Seatvalue(Source, Destination, local);

			System.out.println(objavailability);
			request.setAttribute("Flight_List", objavailability);
		
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("FlightSearchList.jsp");
			requestDispatcher.forward(request, response);
			
			
			




			
		}
		catch(Exception e)
		{
			out.println(e.getMessage());
			System.out.println(e);
		}
		
	}

}
