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

import com.airlinereservationsystemapp.DaoImpl.LoginDao;

import Services.FlightService;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class LoginservletServlet extends HttpServlet {
	
	protected void doget(HttpServletRequest request, HttpServletResponse response) throws Exception 	{
	
		} 
		 
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			

        
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username);
		HttpSession session = request.getSession();
		LoginDao login = new LoginDao();
		 Boolean  loginvalidation ;
		 try {
			 System.out.println(username);
			loginvalidation = login.Loginfile( username, password);
			System.out.println(username);
			if(loginvalidation)
			{
				String Check_Admin = login.CheckAdmin(username, password);
				if(Check_Admin == "yes")
				{
					System.out.println("Weleocme to add flight ");
					session.getAttribute("Sourcelist");

					session.setAttribute("LOGGED_IN_ADMIN", username);
					response.sendRedirect("FlightSearch");  
					System.out.println("User Details");
RequestDispatcher requestDispatcher = request.getRequestDispatcher("FlightList.jsp");
System.out.println("Userlist1");
requestDispatcher.forward(request, response);

				}
				else 
				{
					System.out.println("Weleocme to add1 flight ");

					session.setAttribute("LOGGED_IN_USER", username);
					
					 String loggedInAsUser = (String) session.getAttribute("LOGGED_IN_USER");
					 
						FlightService flightService = new FlightService();
						int Closingbalance = flightService.getclosingbalance(loggedInAsUser);

						System.out.println("The closing Balance is " +Closingbalance);
						
						session.setAttribute("Closingbalance", Closingbalance);

						session.getAttribute("Sourcelist");
						
						System.out.println("sourceliost of value printed"+session.getAttribute("Sourcelist"));

					RequestDispatcher requestDispatcher = request.getRequestDispatcher("flightSearch.jsp");
					requestDispatcher.forward(request, response);

				}
				
				
			}
			else
			{
				session.setAttribute("Error", "Invalid Crediantals");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(request, response);


				//response.getWriter().print("Data failed");

				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
		}
		 

			

	}

}
