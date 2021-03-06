package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airlinereservationsystemapp.DaoImpl.SourceDao;
import com.airlinereservationsystemapp.Models.FlightSeatAvailability;

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
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SourceDao objsearchflight = new SourceDao();
		try {
			LocalDate local = null;
			String Source = "";
			String Destination = "";
			Source = request.getParameter("source");
			Destination = request.getParameter("destination");
			String date = request.getParameter("date");
			// if(date!=null && date != "")
			if (date != null && !date.isEmpty()) {
				local = LocalDate.parse(date);
			}
			HttpSession session = request.getSession();
			List<FlightSeatAvailability> objavailability = objsearchflight.Seatvalue(Source, Destination, local);
			request.setAttribute("Flight_List", objavailability);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("flightsearchlist.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.getMessage();
		}

	}

}
