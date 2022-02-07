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

	public DeleteFlightServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // doGet(request, response);
		AddFlightDao delete = new AddFlightDao();
		try {
			String Flight_id = request.getParameter("Flight_id");
			int Flightid = Integer.parseInt(Flight_id);
			delete.DeleteFlight(Flightid);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("flightSearch.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.getMessage();
			}
	}

}
