package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.model.Employee;
import com.app.service.Employeeservice;
import com.app.service.impl.Employeeserviceimpl;

import com.google.gson.Gson;

/**
 * Servlet implementation class EmployeeLogin
 */
public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee=new Employee();
		Employeeservice employeeservice = new Employeeserviceimpl();
		PrintWriter out=response.getWriter();
		employee.setEmployeename(request.getParameter("username"));
		employee.setEmployeepassword(request.getParameter("password"));
		//HttpSession session=request.getSession();
		RequestDispatcher requestDispatcher = null;
		try {
			if(employeeservice.isValid(employee)) {
				HttpSession session=request.getSession();
				//session.setAttribute("employee", employee.getEmployeename());
				response.sendRedirect("customerdetails.html");
		}else {
			requestDispatcher=request.getRequestDispatcher("loginE.html");
			requestDispatcher.include(request, response);
			out.print("<center><span style='color:red;'>Invalid Credentials</span></center>");
			
		}
	} catch (com.app.exception.BusinessException e) {
		
		requestDispatcher=request.getRequestDispatcher("loginE.html");
		requestDispatcher.include(request, response);
		out.print("<center><span style='color:red;'>Invalid Credentials</span></center>");
	}
		
		}

}
