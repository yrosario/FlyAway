package com.flyaway.flightservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.flightmanager.FlightManager;

@WebServlet("/flightregistration")
public class FlightRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * <p>Airport Departure ID <input type="text" name="airportDepatureId"></p>
		 * <p>Airport Arrival ID <input type="text" name="airportArrId"></p>
		 * <p>Available Seats <input type="text" name="availableSeats"></p> <p>Departure
		 * Time <input type="date" name="departureTime"></p> <p>Arrival Time <input
		 * type="date" name="arrivalTime"></p> <p><input type="submit"
		 * value="Submit"></p>
		 */

		try {
			int airportDepatureId = (int)Integer.parseInt(request.getParameter("airportDepatureId"));
			int airportArrId = (int)Integer.parseInt(request.getParameter("airportArrivalId"));
			int availableSeats = (int)Integer.parseInt(request.getParameter("availableSeats"));
			
			String departureTime = request.getParameter("departureTime");
			String arrivalTime = request.getParameter("arrivalTime");
			
			boolean createFlightSuccess = new FlightManager().addFlight(airportDepatureId, airportArrId, availableSeats, departureTime, arrivalTime);
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			if(createFlightSuccess) {
				out.println("<h1>Flight creation was successful</h1>");
			}else {
				out.println("<h1>Flight creation failed</h1>");
			}
		} catch (Exception e) {
			System.out.println("Please enter a number" + e);
			
			return;
		}


		


	}

}
