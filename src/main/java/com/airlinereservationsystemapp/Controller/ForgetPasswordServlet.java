package com.airlinereservationsystemapp.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airlinereservationsystemapp.DaoImpl.LoginDao;

@WebServlet("/ForgetPassword")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ForgetPasswordServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String Username = request.getParameter("username");
		String Password = request.getParameter("password");
     LoginDao password = new  LoginDao();
     try {
			session.getAttribute("Sourcelist");
		password.updatepassword(Username, Password);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(request, response);
     }
     catch (Exception e) {
			e.getMessage();
 	}
	}
}
