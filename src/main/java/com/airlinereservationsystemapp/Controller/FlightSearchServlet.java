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

import com.airlinereservationsystemapp.DaoImpl.FlightSearchDao;
import com.airlinereservationsystemapp.Models.Flight_list;

/**
 * Servlet implementation class FlightSearch
 */
@WebServlet("/FlightSearch")
public class FlightSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 String page="FlightList.jsp";
	    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param departureTime 
	 * @param res 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        response.setContentType("text/html");
       // List<Flight_list> flightList = new ArrayList<>();
try
{
	HttpSession session = request.getSession();
	FlightSearchDao flightDao = new FlightSearchDao();
	System.out.println("hello flight list");
	
	List<Flight_list> flightInfo = flightDao.FlightList();
	session.setAttribute("Flight_List", flightInfo);
	System.out.println("Inside 1");
	System.out.println("hello flight list"+session.getAttribute("Flight_List"));

//	RequestDispatcher requestDispatcher = request.getRequestDispatcher("flightlist.jsp");
//	requestDispatcher.forward(request, response);
	
	response.sendRedirect("flightlist.jsp");
}
catch(Exception e)
{
	
}

		
	}	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
