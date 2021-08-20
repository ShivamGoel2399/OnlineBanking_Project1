package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.service.Customerservice;
import com.app.service.impl.Customerserviceimpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class Deposit
 */
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher requestDispatcher = null;

		
		Customerservice customerservice = new Customerserviceimpl();
		//HttpSession session = request.getSession(false);
		//int cid = (Integer) session.getAttribute("cid");
		if (session == null) {

			out.print("<center><h1>Please Login First</h1></center>");
			out.print("<h4><a href='/Shivubank_project1'>Click here to Login </a> ");
		} else {
		float amount = Float.parseFloat(request.getParameter("amount"));
		long accountno = Long.parseLong(request.getParameter("accountno"));
		System.out.println(amount);
		System.out.println(accountno);

		if (amount > 0 && accountno!= 0) {
			try {
				float bal=customerservice.checkbalancebyaccountno(accountno);
				
				customerservice.deposit(bal, amount, accountno);
				
				System.out.println(amount);
				System.out.println(accountno);
			
				response.sendRedirect("welcomecustomer.html");
			
} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			out.print("<center><span><b><i>Deposit Failed</center></span></b></i>");
			requestDispatcher = request.getRequestDispatcher("welcomecustomer.html");

	}

	}}}
