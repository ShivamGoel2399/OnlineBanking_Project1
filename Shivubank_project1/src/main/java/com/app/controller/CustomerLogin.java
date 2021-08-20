package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.model.Customer;
import com.app.model.Employee;
import com.app.service.Customerservice;
import com.app.service.Employeeservice;
import com.app.service.impl.Customerserviceimpl;
import com.app.service.impl.Employeeserviceimpl;

/**
 * Servlet implementation class CustomerLogin
 */
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer=new Customer();
		Customerservice customerservice = new Customerserviceimpl();
		PrintWriter out=response.getWriter();
		customer.setCustomername(request.getParameter("username"));
		customer.setCustomerpassword(request.getParameter("password"));
		//HttpSession session=request.getSession();
		RequestDispatcher requestDispatcher = null;
		try {
			if(customerservice.isValidcustomer(customer)) {
				
				//session.setAttribute("employee", employee.getEmployeename());
				HttpSession session=request.getSession();
				response.sendRedirect("welcomecustomer.html");
		}else {
			requestDispatcher=request.getRequestDispatcher("first.html");
			requestDispatcher.include(request, response);
			out.print("<h1><center><span style='color:red;'>Invalid Credentials</span></center></h1>");
			
		}
	} catch (com.app.exception.BusinessException e) {
		
		requestDispatcher=request.getRequestDispatcher("first.html");
		requestDispatcher.include(request, response);
		out.print("<center><span style='color:red;'>Invalid Credentials</span></center>");
	}
	}

}
