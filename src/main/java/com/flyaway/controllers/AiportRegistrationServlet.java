package com.flyaway.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.helpclasses.AirportManager;


@WebServlet("/AiportRegistrationServlet")
public class AiportRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get request parameters
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		
		PrintWriter out = response.getWriter();
		AirportManager airMng = new AirportManager();
		if(airMng.addAirport(name, country, state, city)) {
			out.println("Airport creation successful");
			out.println("Name: " + name + "country: " + country + " State: " + state + " City: " + city);
		}else {
			out.println("Airport creation failed");
		}
	}

}
