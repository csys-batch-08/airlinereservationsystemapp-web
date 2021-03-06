package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.Connectutil;

/**
 * Servlet implementation class Guestcheck
 */
@WebServlet("/Guestcheck")
public class Guestcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Guestcheck() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("mail");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String mobile = request.getParameter("phone");
			long phone = Long.parseLong(mobile);
			con = Connectutil.getdbconnect();
			if (phone != 0) {
				ps = con.prepareStatement("select * from register where  Phone_number = ?");
				ps.setLong(1, phone);
				rs = ps.executeQuery();
				if (rs.next()) {
					PrintWriter Write = response.getWriter();
					Write.println("Phone Number Already Registered");
				} else {
				}
			}
		} catch (NumberFormatException e) {
			e.getMessage();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			Connectutil.close(con, ps, rs);
		}
	}
}
