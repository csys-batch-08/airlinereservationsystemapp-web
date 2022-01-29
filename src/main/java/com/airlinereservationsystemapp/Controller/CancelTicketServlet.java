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
import com.airlinereservationsystemapp.Models.Passenger_details;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	public  LocalDate getdate()
	{
        LocalDate lt = LocalDate.now();
		return lt;
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	       HttpSession session = request.getSession();

		System.out.println("Metghdpapapdapidaipadi va;dlkajdhhgdghdaghghdaghdaghgahdhgad");
		
		LocalDate today = getdate();
		System.out.println("The current date and and time is"+today);
		
		session.setAttribute("Currentdatetime", today);
		
		Passenger_detailsDao cancellist = new Passenger_detailsDao();
	       String loggedInAsUser = (String) session.getAttribute("LOGGED_IN_USER");
	       

		List<Passenger_details> cancelinfo = cancellist.CancelTicket(loggedInAsUser);
		System.out.println(cancelinfo);
		
		
		session.setAttribute("CancelList", cancelinfo);
		
		
		
		
		
		
		
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("CancelTicket.jsp");
//		requestDispatcher.forward(request, response);
		
		response.sendRedirect("CancelTicket.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	

	
	
	
    

}
