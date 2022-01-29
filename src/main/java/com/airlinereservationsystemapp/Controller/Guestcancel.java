package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airlinereservationsystemapp.DaoImpl.FlightRegisterDao;
import com.airlinereservationsystemapp.Models.Passenger_details;

/**
 * Servlet implementation class Guestcancel
 */
@WebServlet("/Guestcancel")
public class Guestcancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Guestcancel() {
        super();
        // TODO Auto-generated constructor stub
    }
	public  LocalDate getdate()
	{
        LocalDate lt = LocalDate.now();
		return lt;
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		HttpSession session = request.getSession();
		
		LocalDate local =  getdate();
		
		System.out.println("localdate "+local);
		
		session.setAttribute("Guestcurentdate", local);
		
	Long phone = (Long)	session.getAttribute("Mobile");
	
	System.out.println("Phone number valiwehudshhdhdshghgdg"+phone);

		FlightRegisterDao listvalue = new FlightRegisterDao();
		List<Passenger_details> Guestcancel = listvalue.CancelTicket(phone);
		System.out.println(Guestcancel);
		
		request.setAttribute("GuestList", Guestcancel);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("GuestCancelTicket.jsp");
		requestDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
