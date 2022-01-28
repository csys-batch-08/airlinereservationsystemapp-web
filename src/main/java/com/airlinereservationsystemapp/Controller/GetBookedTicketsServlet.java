package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import Services.FlightService;

/**
 * Servlet implementation class GetBookedTickets
 */
@WebServlet("/GetBookedTickets")
public class GetBookedTicketsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBookedTicketsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
	        PrintWriter out=response.getWriter();
	        out.println("hello");
	}
//		try {
//			String flightId = request.getParameter("flightId");
//			out.println(flightId);
//			String bookingDate = request.getParameter("bookingDate");
//			out.println(bookingDate);
//			
//			String coach=request.getParameter("coach");
//			out.println(coach);
//			String name=request.getParameter("username");
//			FlightService flightBookingService=new FlightService();
			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
//			System.out.println("connection established"+con);
//			
//			//out.println("connection established"+con);
//			//Statement stmt = con.createStatement();
//			
//		
//			
//				String sql = "SELECT * FROM flight_seats_availabilty WHERE flight_id=? and FLIGHT_DEPARTURE_DATE= ? ";
//				
//					
//				int Seat_Available = 0;
//			PreparedStatement pst = con.prepareStatement(sql);
//			
//		
//			
//			int flight_id = Integer.parseInt(flightId);
//			pst.setInt(1, flight_id);
//			pst.setString(2, bookingDate);
//			
//			ResultSet rs = pst.executeQuery();
//			
//			out.println("helloquery");
//			while(rs.next())
//			{
//				Seat_Available= rs.getInt("ecomomy_seats");
//				out.println(Seat_Available);
//				out.println("hello");
//				out.println(coach);
//				if(coach=="Economy"){
//					Seat_Available= rs.getInt("ecomomy_seats");
//					out.println(Seat_Available);
//					}else if(coach=="premium"){
//						Seat_Available = rs.getInt("premium_economy_seats");
//						out.println("hello2");
//					}else if(coach=="Bussiness"){
//						Seat_Available = rs.getInt("bussiness_seats");
//						out.println("hello3");
//					}
//			     
//				
//				
//			}
//
//			
//			int numberOfTickets = flightBookingService.getBookedTickets(bookingDate, Integer.parseInt(flightId), coach);
//		     out.println(numberOfTickets);
//			HttpSession session = request.getSession();
//			session.setAttribute("name",name);
//			Gson gson =new Gson();
//			
//			String json = gson.toJson(numberOfTickets);
//			PrintWriter writer = response.getWriter();
//			writer.print(json);
//			writer.flush();
//
//		}
//		catch (Exception e) {
//			
//			 out.println(e.getMessage());
//		}
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
