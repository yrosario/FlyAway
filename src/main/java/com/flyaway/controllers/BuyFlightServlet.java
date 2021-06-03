package com.flyaway.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.helpclasses.BuyFlightManager;


@WebServlet("/BuyFlightServlet")
public class BuyFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("FLIGHT ID" + request.getParameter("flightId"));
		//Get flight id
		int flightId = Integer.parseInt(request.getParameter("flightId"));
		//Enumeration<String> paramsName = request.getParameterNames();
		
		//Keeps track of session
		HttpSession session = request.getSession(true);
		
		//Manages the operations of buying flights
		BuyFlightManager flightMngr = new BuyFlightManager();

		//Get logged in user id if user has logged in. Otherwise stored the flightId in the session
		//Object and redirect the user to log in.
		if((String) session.getAttribute("id") != null) {
			System.out.println("SESSION SHOULD BE NULL");
			int id = Integer.parseInt((String) session.getAttribute("id"));
			
			PrintWriter out = response.getWriter();
			
			out.println("Flight ID: " + flightId);
			if(flightMngr.buy(flightId, id))
				out.println("Successful");
		}else {
			//Stored the flight information
			session.setAttribute("flightId", flightId);
			response.sendRedirect("login.jsp");
		}

	}

}
