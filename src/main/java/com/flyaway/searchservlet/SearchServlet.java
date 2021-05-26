package com.flyaway.searchservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.FlightQuery.FlightQuery;
import com.flyaway.flight.Flight;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 				<input type="text" name="from" value="Leaving From"> 
				<input type="text" name="to" value="Going to"> 
				<input type="date" name="departureDate"> 
				<input type="date"name="returningDate">
		 */
		
		String from = request.getParameter("from");
		String destination = request.getParameter("to");
		String departureDate = request.getParameter("departureDate");
		String returningDate = request.getParameter("returningDate");
		
		PrintWriter out = response.getWriter();
		
	
		List<Flight> flightList = new FlightQuery().getFlights(from, destination, departureDate, returningDate);
		
		for(Flight fl : flightList) {
			out.println("Flight Details");
			out.println("flight Id: " + fl.getFlightId());
			out.println("Airport Arrival ID: " + fl.getAirportArrId());
			out.println("Airport Departure ID: " + fl.getAirportDepatureId());
			out.println("Arrival Time: " + fl.getArrivalTime());
			out.println("Available Seats: " + fl.getAvailableSeats());
			out.println("Customer ID: " + fl.getCustomerId());
			out.println("Seat NO: " + fl.getSeatNo());
			out.println("Staff ID: " + fl.getStaffId());
			
			out.println("\n");
		}
		
		//out.println(from + " " + destination + " " + departureDate + " " + returningDate);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
