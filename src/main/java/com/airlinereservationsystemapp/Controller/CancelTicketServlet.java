package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Passenger_detailsDao cancellist = new Passenger_detailsDao();
	       HttpSession session = request.getSession();
	       String loggedInAsUser = (String) session.getAttribute("LOGGED_IN_USER");

		List<Passenger_details> cancelinfo = cancellist.CancelTicket(loggedInAsUser);
		System.out.println(cancelinfo);
		
		
		
		request.setAttribute("CancelList", cancelinfo);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("CancelTicket.jsp");
		requestDispatcher.forward(request, response);

		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
