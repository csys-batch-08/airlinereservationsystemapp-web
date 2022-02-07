package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airlinereservationsystemapp.Models.Source;

import Services.FlightService;

/**
 * Servlet implementation class Sourcedestination
 */
@WebServlet("/Sourcedestination")
public class Sourcedestination extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public LocalDate getdate() {
		LocalDate lt = LocalDate.now();
		return lt;
	}

	public Date getcurrentdate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	public Sourcedestination() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		FlightService flightService = new FlightService();
		try {
			List<Source> Sourceinfo = flightService.getsource();
//			session.setAttribute("Sourcelist", Sourceinfo);
			session.setAttribute("Sourcelist", Sourceinfo);
			LocalDate arrivaldte = getdate();
			Date arrives = getcurrentdate();
			session.setAttribute("Arrives", arrives);
			session.setAttribute("Arrivaldate", arrivaldte);
//			response.sendRedirect("flightSearch.jsp");
	        RequestDispatcher req = request.getRequestDispatcher("flightSearch.jsp");
			req.forward(request, response);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
