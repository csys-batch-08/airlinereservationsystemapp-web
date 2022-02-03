package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Uservalid
 */
@WebServlet("/Uservalid")
public class Uservalid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Uservalid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("Method get hitted");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username =request.getParameter("uname");  
		
		System.out.println("mnsfmnfbnfbnfbnnbdfnbdfbnfnbdfnbdf+"+username);
		try
		{  
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		PreparedStatement ps=con.prepareStatement("select * from register where User_name=? ");  
		ps.setString(1,username);  
		ResultSet rs=ps.executeQuery();  
		if(rs.next())
		{

		}  
		else
		{
			System.out.println("nvfhfh");
			PrintWriter Write = response.getWriter();
		   Write.println("User Name Not Valid");
			System.out.println("catch");

		}

		}
		catch(Exception e)
		{
			e.printStackTrace(); 
			System.out.println(e);


		}
		 


		

	}

}
