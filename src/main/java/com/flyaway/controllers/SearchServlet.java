package com.flyaway.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.helpclasses.FlightQuery;
import com.flyaway.models.Flight;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String from = request.getParameter("from");
		String destination = request.getParameter("to");
		String departureDate = request.getParameter("departureDate");
		String returningDate = request.getParameter("returningDate");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	
		//Gets list of dates from date spcified by user
		List<Flight> flightList = new FlightQuery().getFlights(from, destination, departureDate, returningDate);
		request.setAttribute("flightList", flightList);
		
		//Get a reuest dispatcher
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("flightResults.jsp");
		
		//forwarding flight list to flightResults jsp page
		dispatcher.forward(request, response);
		/*
		out.println("<html><head><title>Flight Search Page</title></head><body>");
		out.println("<div> <div><h1>Flight Results</h1></div>");
		out.println("<div>");
		
		for(Flight fl : flightList) {

			out.print("Flight Details: ");
			out.print(" flight Id: " + fl.getFlightId());
			out.print(" Airport Arrival ID: " + fl.getAirportArrId());
			out.print(" Airport Departure ID: " + fl.getAirportDepatureId());
			out.print(" Arrival Time: " + fl.getArrivalTime());
			out.print(" Available Seats: " + fl.getAvailableSeats());
			out.print(" Seat NO: " + fl.getSeatNo());
			out.print(" Staff ID: " + fl.getStaffId());
			out.print("<form action='BuyFlightServlet' method='POST'>");
			out.print("<input type='hidden' name='flightId' value='"+fl.getFlightId() +"'>");
			out.print("<input type='submit' value='buy!'>");
			out.print("</form>");
			out.println("<br>");
			
	
		}
		
		out.print("</div></div></body></html>");*/
	}

}
