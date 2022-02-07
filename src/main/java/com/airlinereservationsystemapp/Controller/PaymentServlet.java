package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airlinereservationsystemapp.DaoImpl.Passenger_detailsDao;
import com.airlinereservationsystemapp.DaoImpl.WalletDao;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/Payment")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaymentServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/**
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			WalletDao wallet = new WalletDao();
			String Username = (String) session.getAttribute("LOGGED_IN_USER");
			String flightid = request.getParameter("flightid");
			int FlightId = Integer.parseInt(flightid);
			String ticketno = request.getParameter("ticketno");
			int TicketNo = Integer.parseInt(ticketno);
			String Amount = request.getParameter("Amount");
			int Price = Integer.parseInt(Amount);
			int noofflightpassengers = (int) session.getAttribute("logpass");
			int splitprice = Price / noofflightpassengers;
			String mode = request.getParameter("yesCheck");
			String seat_no = request.getParameter("seatno");
			session.setAttribute("Seatvalue", seat_no);
			String str = seat_no.replaceAll("\\[", "").replaceAll("\\]", "");
			str = str.replaceAll("\\s", "");
			String[] res = str.split(",", 0);
			int passvalue = (int) session.getAttribute("logpass");
			int seatstatus = 0;
			String economy = (String) session.getAttribute("Economy");
			String pre = (String) session.getAttribute("Premium");
			String bus = (String) session.getAttribute("Bussiness");
			String coach = (String) session.getAttribute("ClassDetails");
			Passenger_detailsDao pass = new Passenger_detailsDao();
			if (mode.equalsIgnoreCase("Wallet")) {
				int walletamount = wallet.checkusername(Username);
				if (walletamount > 0 && walletamount > Price) {
					int Closingbalance = walletamount - Price;
					wallet.updatebalance(Username, Closingbalance);
					String noofpassengers = (String) request.getAttribute("noofpass");
					for (String mystr : res) {
						seatstatus = Integer.parseInt(mystr);
						wallet.InserPaymentdetails(FlightId, TicketNo, splitprice, mode, Username, seatstatus);
					}
					pass.Updatepassenger(Integer.parseInt(economy), Integer.parseInt(pre), Integer.parseInt(bus), coach,
							FlightId);
					session.removeAttribute("ClassDetails");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("flightSearch.jsp");
					requestDispatcher.forward(request, response);
				} else {
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("mywallet.jsp");
					requestDispatcher.forward(request, response);
				}
			} else {
				for (String mystr : res) {
					seatstatus = Integer.parseInt(mystr);
					wallet.InserPaymentdetails(FlightId, TicketNo, splitprice, mode, Username, seatstatus);
				}
				pass.Updatepassenger(Integer.parseInt(economy), Integer.parseInt(pre), Integer.parseInt(bus), coach,
						FlightId);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("flightSearch.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}
}