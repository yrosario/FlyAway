<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FlyAway Login</title>
</head>
<body>

	<!-- main div -->
	<div>
		<div>
			<H1>FlyAway</H1>
		</div>

	   <div>
	   		<p><a href="register.jsp">Register a new user</a></p>
	   </div>
		<!-- Login form -->
		<div>
			<form action="LoginServlet" method="get">
				<h2>Sing in</h2>
				<p>Email Address</p>
				<input type="email" name="username">
				<p>Password</p>
				<input type="password" name="password">
				<br>
				<input type="submit" value="Sign In">
			</form>

		Authenticate userInfo = new Authenticate();

		</div>
		
		<!-- Check if user has already logged in. If the user has logged in also check if the user -->
		<!-- has select a flight to purchased -->
		<%
			Object passengerId = session.getAttribute("id");
		    Object flightId = session.getAttribute("flightId");
		    
		    if(passengerId != null && flightId != null)
		    	response.sendRedirect(request.getContextPath() + "/BuyFlightServlet.java");
		    else if(passengerId != null)
		    	response.sendRedirect("FlightSearchPage.jsp");
		    
		%>

	</div>
</body>
</html>