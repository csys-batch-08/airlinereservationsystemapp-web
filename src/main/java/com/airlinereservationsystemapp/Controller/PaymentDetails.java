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
		System.out.println("Welcome to details servlet");
		HttpSession session = request.getSession();
		try
		{
			
			String flightid = request.getParameter("flightid");
			System.out.println("Before parsing the valuesssss"+flightid);
			String ticketno = request.getParameter("ticketno");
			System.out.println("Before parsing the valuesssss"+ticketno);
			String Amount = request.getParameter("amount");
			System.out.println("Before parsing the valuesssss"+Amount);
			

	         
			
			System.out.println("dhnhdhdhhhdfhhhdfhfhbamounttttt"+Amount);
			

		     
			int pass = (int)session.getAttribute("logpass");

			  ArrayList<Integer> list=new ArrayList<Integer>();    

ArrayList<Integer> value = (ArrayList<Integer>)session.getAttribute("SeatValue");

System.out.println("dkjcxhhccxggcxvcvcxvvcxvgsgdffghdsfgfgdfgdsfgdsgfsd"+value);

session.setAttribute("Seatfield",value);

String seatvaluefield =  value.toString();

System.out.println("seatvaluefield     :"+seatvaluefield);


String str = seatvaluefield.replaceAll("\\[", "").replaceAll("\\]", "");

str=str.replaceAll("\\s", "");

System.out.println("Converted seat typr valuesssaasasa"+str); 

session.setAttribute("Seatfield",str);



			
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
		     
		    //session.setAttribute("Amount", Price);



		     //RequestDispatcher requestDispatcher = request.getRequestDispatcher("payment.jsp");
				//requestDispatcher.forward(request, response);
		     
		    response.sendRedirect("payment.jsp");


		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
