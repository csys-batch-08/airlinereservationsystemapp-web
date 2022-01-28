package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

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
 * Servlet implementation class AddPassenger
 */
@WebServlet("/AddPassenger")
public class AddPassengerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPassengerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	        HttpSession session = request.getSession();
	    try {
			  String Flight_Id =request.getParameter("flightId");
			  int flightid = Integer.parseInt(Flight_Id);
			  System.out.println(flightid);
			String name = request.getParameter("username");
			System.out.println(name);
			String date = request.getParameter("bookingDate");
			LocalDate local = LocalDate.parse(date);

			System.out.println("hdsghsdghghdsghhhhhhhhhsghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"+local);
			session.setAttribute("Date", local);

			String Source = request.getParameter("source");
			String Destination = request.getParameter("destination");
	      String mobno = request.getParameter("MobileNumber");
	      
	      String economyseats = request.getParameter("Economyclass");
	      System.out.println("Economy  String  seat valeue"+economyseats);

	      int econ = Integer.parseInt(economyseats);
	      System.out.println("Economy seat valeue"+econ);
			String premiumeconomyseats = request.getParameter("PremiumEconomyclass");
			System.out.println(premiumeconomyseats);
	      String businesseats = request.getParameter("Bussinessclass");
	      
	      
	      

	      
	      
	      
	      long mobileno = Long.parseLong(mobno);
	      System.out.println(mobno);
			String class_details = request.getParameter("coach");
			System.out.println(class_details);
			
	       String noofpassengers = request.getParameter("numberOfPassengers");
	       System.out.println("String No of passengers" +noofpassengers);
	       int noofpass = Integer.parseInt(noofpassengers);
	       System.out.println("int No of passengers" +noofpass);

	       System.out.println(noofpass);
	       String ticket_no = request.getParameter("ticketno");
	     int ticketno = Integer.parseInt(ticket_no);
	     
	     String seat_no  =  request.getParameter("seatno");
	     System.out.println(seat_no);
	     
	     int seatno = Integer.parseInt(seat_no);
	     
	     System.out.println(seatno);

	     session.setAttribute("logpass",noofpass);
	     
	     session.setAttribute("Economy", economyseats);
	      session.setAttribute("Premium", premiumeconomyseats);
	      session.setAttribute("Bussiness", businesseats);
			session.setAttribute("ClassDetails", class_details);


	     
System.out.println("mbhfvddno fpo a[apasssenddhgdtad");	 



	       System.out.println(ticketno);
//	       HttpSession session = request.getSession();
	       String loggedInAsUser = (String) session.getAttribute("LOGGED_IN_USER");
     System.out.println(loggedInAsUser);
	     Passenger_details passenger = new Passenger_details(name, class_details, mobileno, Source, Destination, ticketno,flightid,local);
			Passenger_detailsDao pass = new Passenger_detailsDao();
			
			ArrayList<Integer> list=new ArrayList<Integer>(); 

			for(int i=0;i<noofpass;i++)
			{
				System.out.println("hi");
				 int seatnumber = pass.Setnogenerated(passenger,ticketno,loggedInAsUser);
				 list.add(seatnumber);
				 System.out.println("Seatnumbehfsfdy" +seatnumber);
//				  request.setAttribute("SeatValue", value);

			}
			request.setAttribute("SeatValue", list);
			System.out.println(list);
			
			//pass.Updatepassenger(Integer.parseInt(economyseats), Integer.parseInt(premiumeconomyseats), Integer.parseInt(businesseats),class_details,flightid);
				
			
			   
			 
			     RequestDispatcher requestDispatcher = request.getRequestDispatcher("PaymentDetails");
					requestDispatcher.forward(request, response);

				SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
					request.setAttribute("localDateTimeFormat", sdf);

			//response.sendRedirect("Login.jsp");
		} catch (Exception e) {
			System.out.println("Hello error");
			e.printStackTrace();
		}

			
		
			}
	public int generator()
	{
		Random r = new Random(System.currentTimeMillis());
		return 100 + r.nextInt(1200);
	}

	}


