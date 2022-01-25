package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airlinereservationsystemapp.DaoImpl.AddFlightDao;
import com.airlinereservationsystemapp.DaoImpl.Passenger_detailsDao;
import com.airlinereservationsystemapp.Models.Flight;
import com.airlinereservationsystemapp.Models.Passenger_details;

/**
 * Servlet implementation class Bookingdetails
 */
@WebServlet("/Bookingdetails")
public class BookingdetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingdetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Passenger_detailsDao booklist = new Passenger_detailsDao();
		
		
		List<Passenger_details> bookinfo = booklist.Bookinglist();
		System.out.println(bookinfo);
		//request.getRequestDispatcher("DisplaySearchFlight.jsp?").forward(request, response);
		request.setAttribute("Bookinglist", bookinfo);
		System.out.println("Run File ");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("bookinglist.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
