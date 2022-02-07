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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("uname");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = Connectutil.getdbconnect();
			ps = con.prepareStatement("select * from register where User_name=? ");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
			} else {
				PrintWriter Write = response.getWriter();
				Write.println("User Name Not Valid");
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			Connectutil.close(con, ps, rs);
		}
	}

}
