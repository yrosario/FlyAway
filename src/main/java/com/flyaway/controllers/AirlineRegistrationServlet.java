package com.flyaway.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.helpclasses.AirlineManager;

@WebServlet("/AirlineRegistrationServlet")
public class AirlineRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String name = request.getParameter("name");
			int flightNo = Integer.parseInt(request.getParameter("flightNo"));
			
			PrintWriter out = response.getWriter();
			AirlineManager airMngr = new AirlineManager();
			
			if(airMngr.addAirline(name, flightNo)) {
				out.println("Airline creation was successful");
			    out.println("Name: " + name + " FlightNo: " + flightNo);
			}else {
				out.println("Airline creation failed");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
