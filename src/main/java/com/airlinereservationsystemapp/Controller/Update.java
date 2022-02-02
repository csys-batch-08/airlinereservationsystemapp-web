package com.airlinereservationsystemapp.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airlinereservationsystemapp.DaoImpl.FlightSearchDao;
import com.airlinereservationsystemapp.Models.Flight_list;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session  = request.getSession();
		System.out.println("Methodd come inside");
		String flightid =  request.getParameter("flightId");
		System.out.println("flightidddddd"+flightid);
		int Flight_Id = Integer.parseInt(flightid);
		
		FlightSearchDao flightDao = new FlightSearchDao();
		Flight_list flight = flightDao.getRecordById(Flight_Id);
		
		session.setAttribute("Flight_id", flight);

		response.sendRedirect("updateflight.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}