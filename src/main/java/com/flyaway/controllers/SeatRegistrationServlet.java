package com.flyaway.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.helpclasses.SeatManager;

@WebServlet("/SeatRegistrationServlet")
public class SeatRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int flightNo = Integer.parseInt(request.getParameter("flightNo"));
			int seatNo = Integer.parseInt(request.getParameter("seatNo"));
			float price = Float.parseFloat(request.getParameter("price"));
			
			PrintWriter out = response.getWriter();
			
			SeatManager seatMgr = new SeatManager();
			if(seatMgr.setSeat(flightNo, seatNo, price)) {
				out.println("Seat Creation was Successful");
				out.println("Flight No: " + flightNo + " Seat No: " + seatNo + " price " + price);
			}else {
				out.println("Seat Creation failed");
			}
		}catch(Exception e) {
			e.printStackTrace();

		}
		

	}

}
