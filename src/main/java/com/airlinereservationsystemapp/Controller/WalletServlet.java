package com.airlinereservationsystemapp.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airlinereservationsystemapp.DaoImpl.WalletDao;


/**
 * Servlet implementation class Wallet
 */
@WebServlet("/Wallet")
public class WalletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WalletServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try
		{
			HttpSession session = request.getSession();		
		String Username	= (String)session.getAttribute("LOGGED_IN_USER");
		System.out.println("dsjdsbbssdnbsddsdbndsnbdsndbsnbdswallet snbsdfbndsbsbnsbndsnbds"+Username);
	String classvalue = (String)session.getAttribute("ClassDetails");
	
	session.setAttribute("classfield", classvalue);

  System.out.println("sjfshsghfshgfhfsh"+classvalue);

		
		System.out.println(Username);
			String Walletamount = request.getParameter("depositamount");
			System.out.println(Walletamount);

			int wallet_amount = Integer.parseInt(Walletamount);
			System.out.println(wallet_amount);
			WalletDao wallet = new WalletDao();
			int Amount = wallet.checkusername(Username);
			System.out.println("hgsdhgshdgghdhgdsghghsdhgsdhgghdshgdshgsdhghgsdhgsdhghgd"+Amount);
			if(classvalue!=null)
			{
				System.out.println("Fjnsdsdnbdsnbbndsbndsbndsbnbndsbndsbndsbndnbsndbbnsbnnbd"+classvalue);
				int closingbalance = wallet_amount + Amount ; 
				System.out.println("shbhgdhgshgdghsdhghgdsghdshghgdhgdsclosing balanceeee"+closingbalance);
				wallet.updatebalance(Username, closingbalance);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("payment.jsp");
				requestDispatcher.forward(request, response);
				
			}

			
			else if(Amount>0)			
			{
//					if(Amount>0)
//					{
						int closingbalance = wallet_amount + Amount ; 
						wallet.updatebalance(Username, closingbalance);


						RequestDispatcher requestDispatcher = request.getRequestDispatcher("flightSearch.jsp");
						requestDispatcher.forward(request, response);
					//}
				}
			

	
			
		      

			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}


}
