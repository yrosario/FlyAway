package com.flyaway.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BuyFlightServlet")
public class BuyFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Enumeration<String> paramsName = request.getParameterNames();
		
		PrintWriter out = response.getWriter();
		
		while(paramsName.hasMoreElements())
			out.println("Flight ID: " + paramsName.nextElement());
	}

}
