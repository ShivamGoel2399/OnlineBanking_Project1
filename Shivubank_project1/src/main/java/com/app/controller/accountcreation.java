package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.exception.BusinessException;
import com.app.model.Account;
import com.app.model.Customer;
import com.app.service.Customerservice;
import com.app.service.impl.Customerserviceimpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class accountcreation
 */
public class accountcreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public accountcreation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		Gson gson=new Gson();
		response.setContentType("text/html");
		
		if (session == null) {

			out.print("<center><h1>Please Login First</h1></center>");
			out.print("<h4><a href='/Shivubank_project1'>Click here to Login </a> ");
		} else {
		Cookie[] cookies=request.getCookies();
		String s = "";
		for (Cookie cookie : cookies) {
			s=cookie.getValue();
		}
		long id=Long.parseLong(s);
		System.out.println(s);
		System.out.println(id);

		Account account = gson.fromJson(request.getReader(), Account.class);
		account.setCustomerid(id);
		try {
			Customerservice customerservice = new Customerserviceimpl();
			account = customerservice.createAccount(account);
			float a=0;
			customerservice.deposit(a,account.getAccountbalance() , account.getCustomeraccountno());
			response.setContentType("application/json;charset=UTF-8");
			
			System.out.println(account);
			out.print(gson.toJson(account)); //POJO TO JSON
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
			response.sendRedirect("Invalidemployee.html");
		}
		}
	
	}

}
