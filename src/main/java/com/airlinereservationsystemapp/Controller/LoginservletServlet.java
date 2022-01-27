package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airlinereservationsystemapp.DaoImpl.FlightRegisterDao;
import com.airlinereservationsystemapp.DaoImpl.LoginDao;
import com.airlinereservationsystemapp.DaoImpl.Passenger_detailsDao;
import com.airlinereservationsystemapp.Models.Flight;
import com.airlinereservationsystemapp.Models.Passenger_details;

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
		
			

		//response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
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
					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("FlightSearch.jsp");
					requestDispatcher.forward(request, response);

				}
				
				
				response.getWriter().print("Data success");
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
