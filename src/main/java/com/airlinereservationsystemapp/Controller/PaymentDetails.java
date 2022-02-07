package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PaymentDetails
 */
@WebServlet("/PaymentDetails")
public class PaymentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaymentDetails() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			String flightid = request.getParameter("flightid");
			String ticketno = request.getParameter("ticketno");
			String Amount = request.getParameter("amount");
			ArrayList<Integer> value = (ArrayList<Integer>) session.getAttribute("SeatValue");
			session.setAttribute("Seatfield", value);
			String seatvaluefield = value.toString();
			String str = seatvaluefield.replaceAll("\\[", "").replaceAll("\\]", "");
			str = str.replaceAll("\\s", "");
			session.setAttribute("Seatfield", str);
			request.setAttribute("Flight_ID", flightid);
			session.setAttribute("Flight_id", flightid);
			request.setAttribute("Ticket_no", ticketno);
			session.setAttribute("Ticket_no", ticketno);
			request.setAttribute("Amount", Amount);
			session.setAttribute("Amont", Amount);
			request.setAttribute("Seatnovalue", value);
			response.sendRedirect("payment.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
