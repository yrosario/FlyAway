package com.flyaway.controllers;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.helpclasses.Authenticate;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get user name and password from request
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		
		PrintWriter out = response.getWriter();
		
		Authenticate userInfo = new Authenticate();
		if(userInfo.hasAccess(username, password)) {
			out.println("Success");
		}else {
			out.println("Incorrect username or password");
		}
				
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String address = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		PrintWriter out = response.getWriter();

		Authenticate userInfo = new Authenticate();
		if(userInfo.createUser(fname, lname, birthday, address, phone, password, email)) {
			out.println("User creation was Successful");
		}else {
			out.println("User creation failed");
		}
		
		
		
		
	}

}
