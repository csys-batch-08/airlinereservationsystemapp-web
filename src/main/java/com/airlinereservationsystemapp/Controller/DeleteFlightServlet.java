package com.airlinereservationsystemapp.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airlinereservationsystemapp.DaoImpl.AddFlightDao;

/**
 * Servlet implementation class DeleteFlight
 */
@WebServlet("/DeleteFlight")
public class DeleteFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFlightServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		//doGet(request, response);
		String  Flight_id  = request.getParameter("Flight_id");
int Flightid = Integer.parseInt(Flight_id);
		AddFlightDao delete = new AddFlightDao();
		try {
			 delete.DeleteFlight(Flightid);
			response.getWriter().print("Data Deleted");
			   
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("FlightSearch.jsp");
			requestDispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
