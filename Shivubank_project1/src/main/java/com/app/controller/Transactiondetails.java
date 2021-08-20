package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.exception.BusinessException;
import com.app.service.Customerservice;
import com.app.service.impl.Customerserviceimpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class Transactiondetails
 */
public class Transactiondetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transactiondetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    Customerservice customerservice=new Customerserviceimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		response.setContentType("application/json;charset=UTF-8");
		Gson gson=new Gson();
		PrintWriter out=response.getWriter();
		if (session == null) {

			out.print("<center><h1>Please Login First</h1></center>");
			out.print("<h4><a href='/Shivubank_project1'>Click here to Login </a> ");
		} else {
		String S=request.getParameter("b1");
		long accountno=Long.parseLong(request.getParameter("accountno"));

			try {
			
			out.print(gson.toJson(customerservice.getAllTransaction(accountno)));
		} catch (BusinessException e) {
			System.out.println(e);
		}
	}

}}

