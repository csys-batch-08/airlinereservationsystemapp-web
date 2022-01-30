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

import com.airlinereservationsystemapp.DaoImpl.Passenger_detailsDao;
import com.airlinereservationsystemapp.DaoImpl.WalletDao;

/**
 * Servlet implementation class FlightCancellation
 */
@WebServlet("/FlightCancellation")
public class FlightCancellationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightCancellationServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String  seat_no  = request.getParameter("seatno");
		int seatno = Integer.parseInt(seat_no);
		System.out.println(seatno);
		
	String Flight_id  = request.getParameter("Flightid");
		int flight = Integer.parseInt(Flight_id);
		System.out.println(flight);
	
	String class_details = request.getParameter("Class");
	System.out.println(class_details);
	String departuredate   = request.getParameter("DepartureDate");
	System.out.println(departuredate);
	 LocalDate date = LocalDate.parse(departuredate);
	 System.out.println(date);
	 
	 String amountpaid  = request.getParameter("amount");
	 int amount = Integer.parseInt(amountpaid);
	 System.out.println(amount);

	 HttpSession session = request.getSession();
	 String User = (String) session.getAttribute("LOGGED_IN_USER");
		       WalletDao wallet = new WalletDao();
		       
		       
		       
		       
				Passenger_detailsDao cancelflight = new Passenger_detailsDao();
				try {
					cancelflight.Updatecancelstatus(seatno);
				int ticketcount = 	cancelflight.getticketcount(class_details,flight,date);
				System.out.println("Ticket COunttvalue"+ticketcount);
				cancelflight.Updateticketcount(flight,date,class_details,ticketcount);
				
			       int refundbalance = wallet.getclosingbalance(class_details);
			       
			       System.out.println(refundbalance);

				     wallet.refundbalance(User, amount);
				     
				
//					cancelflight.Updatepassenger(economy, premium, business,class_details,flight);
					
					
					response.getWriter().print("Flight Cancelled");
					   
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("flightSearch.jsp");
					requestDispatcher.forward(request, response);

				} catch (Exception e) {
					response.getWriter().print("Flight not  Cancelled");

					e.printStackTrace();
				}
	}

}
