<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search for Flight</title>
</head>
<body>

	<!-- Main Div -->
	<div>
		<!-- Header div -->
		<div>
			<h1>Search for Flights</h1>
		</div>

		<!-- Search div -->
		<div>
			<form action="flightServlet" method="get">
				<input type="text" name="from" value="Leaving From"> 
				<input type="text" name="to" value="Going to"> 
				<input type="date" name="departureDate"> 
				<input type="date"name="returningDate">
				 <br>
				<input type="submit" value="Search">
			</form>
		</div>
	</div>

</body>
</html>