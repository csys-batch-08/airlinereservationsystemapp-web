package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try
		{
			String flightid = request.getParameter("flightId");
			int FlightId = Integer.parseInt(flightid);
			String ticketno = request.getParameter("ticketno");
			int TicketNo = Integer.parseInt(ticketno);
			String Amount = request.getParameter("amount");
			int Price = Integer.parseInt(Amount);
		     
			HttpSession session = request.getSession();
			int pass = (int)session.getAttribute("logpass");

			  ArrayList<Integer> list=new ArrayList<Integer>();    

ArrayList<Integer> value = (ArrayList<Integer>)request.getAttribute("SeatValue");

System.out.println("dkjcxhhccxggcxvcvcxvvcxvgsgdffghdsfgfgdfgdsfgdsgfsd"+value);

session.setAttribute("Seatfield",value);


			
//			for(int i = 0; i<pass;i++)
//			{
//				System.out.println("hi payment Details");
//				list.addAll(value);
//				
//				System.out.println("For Lopp value"+request.getAttribute("SeatValue"));
//
//			}
//
System.out.println(value);

System.out.println("cdmnbhvdgdcgcdgcdc"+request.getAttribute("SeatValue"));
		     
		     System.out.println("Seftgddfghdcghdcagfhcdafhdafhdcgfadcghdac");

		     request.setAttribute("Flight_ID", flightid);
		     session.setAttribute("Flight_id", flightid);
		     
		     System.out.println(flightid);
		     request.setAttribute("Ticket_no", ticketno);
		     session.setAttribute("Ticket_no", ticketno);

		     request.setAttribute("Amount", Amount);
		     session.setAttribute("Amont", Amount);
		     request.setAttribute("Seatnovalue", value);
		     
		     session.setAttribute("Amount", Price);



		     RequestDispatcher requestDispatcher = request.getRequestDispatcher("payment.jsp");
				requestDispatcher.forward(request, response);


		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
