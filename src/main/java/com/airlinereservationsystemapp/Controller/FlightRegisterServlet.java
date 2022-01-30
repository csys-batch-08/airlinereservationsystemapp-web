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
import com.airlinereservationsystemapp.Models.Flight;



/**
 * Servlet implementation class FlightRegister
 */
@WebServlet("/FlightRegister")
public class FlightRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 response.setContentType("text/html");
	       HttpSession session = request.getSession();

		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");

			String username = request.getParameter("username");
			//int age = Integer.parseInt(request.getParameter("age"));
			String password = request.getParameter("password");
			//String phoneNumber = request.getParameter("phoneNumber");

			String gender = request.getParameter("Gender");
			String  Phonenum =request.getParameter("phoneNumber");
			
			
          long Phonenumber = Long.parseLong(Phonenum);
			
			Flight objFlightRegister = new Flight(name,email,username,password,gender,Phonenumber);
			FlightRegisterDao RegDao = new FlightRegisterDao();
//			RegDao.Registration(objFlightRegister);
			   
           int i =  RegDao.Fileregistration(objFlightRegister);
           
           System.out.println("Flight Registration nnnn"+" "+" "+i);
           
           if(i!=0)
           {
        	   session.setAttribute("Valid", "Successfully Registered");
				//RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
				//requestDispatcher.forward(request, response);
        	   response.sendRedirect("login.jsp?success=1");
                
           }
           else if(i==0)
           {
        	   session.setAttribute("invalid", "Data Not Registered");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
				requestDispatcher.forward(request, response);

           }
			
			
			
				
				
		} catch (Exception e) {
		}

			
		
			}

}
