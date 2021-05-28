package com.flyaway.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.helpclasses.StaffManager;

@WebServlet("/StaffRegistrationServlet")
public class StaffRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String phoneNo = request.getParameter("phoneNo");
		String address = request.getParameter("address");
		
		PrintWriter out = response.getWriter();
		StaffManager staffMngr = new StaffManager();
		if(staffMngr.addStaff(fname, lname, phoneNo, address, address)) {
			out.println("Staff creation was successful");
			out.println("First Name: "+ fname + "Last Name: " + lname + " Phone No: " + phoneNo + " Address: " + address);
		}else {
			out.println("Failed to create staff member");
		}
		

	}

}
