package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
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
 * Servlet implementation class checkusername
 */
@WebServlet("/checkusername")
public class checkusername extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public checkusername() {
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
		String username = request.getParameter("username");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = Connectutil.getdbconnect();
			String sql = "SELECT NAMES,EMAIL_ID,USER_NAME,PASSWORD,GENDER,PHONE_NUMBER,REGISTERED_DATE,IS_ADMIN FROM register WHERE user_name = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				response.getWriter().println("User Name already Registered");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Connectutil.close(con, ps, rs);
		}
	}
}
