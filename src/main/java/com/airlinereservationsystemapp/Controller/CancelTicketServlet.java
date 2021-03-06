package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airlinereservationsystemapp.DaoImpl.Passenger_detailsDao;
import com.airlinereservationsystemapp.Models.PassengerDetails;

/**
 * Servlet implementation class CancelTicket
 */
@WebServlet("/CancelTicket")
public class CancelTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CancelTicketServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalDate getdate() {
		LocalDate lt = LocalDate.now();
		return lt;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		LocalDate today = getdate();
		session.setAttribute("Currentdatetime", today);
		Passenger_detailsDao cancellist = new Passenger_detailsDao();
		try {
			String loggedInAsUser = (String) session.getAttribute("LOGGED_IN_USER");
			List<PassengerDetails> cancelinfo = cancellist.CancelTicket(loggedInAsUser);
			request.setAttribute("CancelList", cancelinfo);
			RequestDispatcher req = request.getRequestDispatcher("cancelticket.jsp");
			req.forward(request, response);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
