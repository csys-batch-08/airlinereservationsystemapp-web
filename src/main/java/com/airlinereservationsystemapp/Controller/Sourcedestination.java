package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.ha.backend.Sender;

import com.airlinereservationsystemapp.Models.Source;

import Services.FlightService;

/**
 * Servlet implementation class Sourcedestination
 */
@WebServlet("/Sourcedestination")
public class Sourcedestination extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public  LocalDate getdate()
	{
        LocalDate lt = LocalDate.now();
		return lt;
	}
	
	public  Date getcurrentdate()
	{
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}


    public Sourcedestination() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session  =  request.getSession();

		FlightService flightService = new FlightService();
		try {
			List<Source> Sourceinfo = flightService.getsource();
			
			session.setAttribute("Sourcelist", Sourceinfo);
			
			System.out.println("Welcome to Source listsjbfj");
			
			LocalDate arrivaldte  = getdate();
			
			Date arrives =  getcurrentdate();
			
			session.setAttribute("Arrives",arrives );

			
			session.setAttribute("Arrivaldate",arrivaldte );
			
			System.out.println("jdfbjfdbfdjbjjxcbjbjjbbjvbjvbjbjvxbj"+arrivaldte);
			
			System.out.println("cureebdhhdahdhghgshsdhghgdhghds"+arrives);

			

			
			response.sendRedirect("FlightSearch.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	
}
