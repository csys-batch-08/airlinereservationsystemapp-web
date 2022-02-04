package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airlinereservationsystemapp.DaoImpl.AddFlightDao;

/**
 * Servlet implementation class UpdateFlight
 */
@WebServlet("/UpdateFlight")
public class UpdateFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFlightServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

			try {
				String Flight_id  = request.getParameter("Flightid");

				String flight_name = request.getParameter("Flightname");
				String source = request.getParameter("source");
				String Destination = request.getParameter("Destination");
				String   Economy_class = request.getParameter("Economyclass");
				String   premium_Economy_class =request.getParameter("PremiumEconomyclass");
				String   Bussiness_class = request.getParameter("Bussinessclass");
				
//	        java.util.Date date = new java.util.Date();
         String  Arrival_date  = request.getParameter("ArrivalDate"); 
 LocalDate local = LocalDate.parse(Arrival_date);
	String Departure_Date  =  request.getParameter("DepartureDate");
	 LocalDate loca1 = LocalDate.parse(Departure_Date);
	 String status  =request.getParameter("Status");
				int Flightid = Integer.parseInt(Flight_id);
				int Economyclass = Integer.parseInt(Economy_class);
				int premiumclass = Integer.parseInt(premium_Economy_class);
				int Bussinessclass = Integer.parseInt(Bussiness_class);
				
				HttpSession session = request.getSession();
				String loggedinadmin = (String) session.getAttribute("LOGGED_IN_ADMIN");

					AddFlightDao update = new AddFlightDao();
					String Details =  update.updateFlight(Flightid,flight_name,source,Destination,Economyclass,premiumclass,Bussinessclass,local,loca1,status,loggedinadmin);
					

				 
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("flightSearch.jsp");
				requestDispatcher.forward(request, response);

			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			
		}


	


	}

