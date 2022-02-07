package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airlinereservationsystemapp.DaoImpl.Passenger_detailsDao;
import com.airlinereservationsystemapp.Models.Passenger_details;

/**
 * Servlet implementation class AddPassenger
 */
@WebServlet("/AddPassenger")
public class AddPassengerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPassengerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			String Flight_Id = request.getParameter("flightId");
			int flightid = Integer.parseInt(Flight_Id);
			String name = request.getParameter("username");
			String date = request.getParameter("bookingDate");
			LocalDate local = LocalDate.parse(date);
			session.setAttribute("Date", local);
			String Source = request.getParameter("source");
			String Destination = request.getParameter("destination");
			String mobno = request.getParameter("MobileNumber");
			String economyseats = request.getParameter("Economyclass");
			int econ = Integer.parseInt(economyseats);
			String premiumeconomyseats = request.getParameter("PremiumEconomyclass");
			String businesseats = request.getParameter("Bussinessclass");
			long mobileno = Long.parseLong(mobno);
			String class_details = request.getParameter("coach");
			String noofpassengers = request.getParameter("numberOfPassengers");
			int noofpass = Integer.parseInt(noofpassengers);
			String ticket_no = request.getParameter("ticketno");
			int ticketno = Integer.parseInt(ticket_no);
			String seat_no = request.getParameter("seatno");
			int seatno = Integer.parseInt(seat_no);
			String amount = request.getParameter("amount");
			session.setAttribute("logpass", noofpass);
			session.setAttribute("Economy", economyseats);
			session.setAttribute("Premium", premiumeconomyseats);
			session.setAttribute("Bussiness", businesseats);
			session.setAttribute("ClassDetails", class_details);
			String loggedInAsUser = (String) session.getAttribute("LOGGED_IN_USER");
			Passenger_details passenger = new Passenger_details(name, class_details, mobileno, Source, Destination,
					ticketno, flightid, local);
			Passenger_detailsDao pass = new Passenger_detailsDao();
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < noofpass; i++) {
				int seatnumber = pass.Setnogenerated(passenger, ticketno, loggedInAsUser);
				list.add(seatnumber);
			}
			session.setAttribute("SeatValue", list);
			RequestDispatcher req = request.getRequestDispatcher(
					"PaymentDetails?flightid=" + Flight_Id + "&ticketno=" + ticket_no + "&amount=" + amount);
			req.forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public int generator() {
		Random r = new Random(System.currentTimeMillis());
		return 100 + r.nextInt(1200);
	}

}
