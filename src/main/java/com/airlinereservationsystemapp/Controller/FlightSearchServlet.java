package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class FlightSearch
 */
@WebServlet("/FlightSearch")
public class FlightSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String page = "FlightList.jsp";

	public FlightSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			FlightSearchDao flightDao = new FlightSearchDao();
			List<Flight_list> flightInfo = flightDao.FlightList();
			request.setAttribute("Flight_List", flightInfo);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("flightlist.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {

			e.getMessage();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
