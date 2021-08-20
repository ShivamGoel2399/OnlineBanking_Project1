package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.service.Customerservice;
import com.app.service.impl.Customerserviceimpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class CustomerRegistration
 */
public class CustomerRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		Customer customer = gson.fromJson(request.getReader(), Customer.class);
		try {
			Customerservice customerservice = new Customerserviceimpl();
			customer = customerservice.registercustomer(customer);
			String s=String.valueOf(customer.getCustomerid());
			Cookie c1 = new Cookie("customerid",s);
			response.addCookie(c1);

			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print(gson.toJson(customer)); //POJO TO JSON
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
			response.sendRedirect("Invalidemployee.html");
		}
	}

}
