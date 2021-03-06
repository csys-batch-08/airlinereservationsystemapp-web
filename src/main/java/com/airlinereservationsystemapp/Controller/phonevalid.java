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

import com.util.Connectutil;

/**
 * Servlet implementation class phonevalid
 */
@WebServlet("/phonevalid")
public class phonevalid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public phonevalid() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String phone = request.getParameter("phoneno");
			long mobileno = Long.parseLong(phone);
			con = Connectutil.getdbconnect();
			ps = con.prepareStatement("select * from register where Phone_number=? ");
			ps.setLong(1, mobileno);
			rs = ps.executeQuery();
			if (rs.next()) {
				PrintWriter Write = response.getWriter();
				Write.println("Mobile Number Already Present");
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			Connectutil.close(con, ps, rs);
		}
	}
}
