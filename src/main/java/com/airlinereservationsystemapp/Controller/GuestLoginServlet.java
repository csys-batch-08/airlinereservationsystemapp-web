package com.airlinereservationsystemapp.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airlinereservationsystemapp.DaoImpl.FlightRegisterDao;

/**
 * Servlet implementation class GuestLogin
 */
@WebServlet("/GuestLogin")
public class GuestLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestLoginServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println("sourcelist enteered");
		session.getAttribute("Sourcelist");

		System.out.println("sourcelist finished"+session.getAttribute("Sourcelist"));

		String guest = "Guest";
		String role = "guest";
		session.setAttribute("LOGGED_IN_USER", guest);
		session.setAttribute("Guest", role);
		//request.setAttribute("ROLE", role);

		System.out.println(guest);
		
		String mobile = request.getParameter("phoneNumber");
		Long phone = Long.parseLong(mobile);
		
		session.setAttribute("Mobile", phone);
		
		String mail = request.getParameter("email");
		


		
		FlightRegisterDao object = new FlightRegisterDao();
		 String  valid ;

		try {
			
			valid  =  object.guestcheck(phone, mail);
			System.out.println("Welcome Checkjdbjsdbbd"+valid);

			
			if(valid!=null)
		{
				System.out.println("Welcome Login Ckddjsbjjsjgsdjgdjbjbdsbjjbds");
				

		}	

       if(valid==null)
       {
    	   object.insertguestvalid(phone, mail);
    	   System.out.println("Registered");
       }


		
			 
		
		}
		catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
		}
		
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("FlightSearch.jsp");
//		requestDispatcher.forward(request, response);
		
		response.sendRedirect("FlightSearch.jsp");
	}
	
	
}
