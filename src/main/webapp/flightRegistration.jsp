<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Flight Registration</title>
</head>
<body>

	<!-- Main Div -->
	<div>
		<!-- Header div -->
		<div>
			<h1>New Flight Registration</h1>
		</div>

		<!-- Search div -->
		<div>
			<form action="/FlyAway/flightregistration" method="POST">
				<p>Airport Departure ID <input type="text" name="airportDepatureId"></p>
				<p>Airport Arrival ID <input type="text" name="airportArrivalId"></p>
				<p>Available Seats <input type="text" name="availableSeats"></p>
				<p>Departure Time <input type="date" name="departureTime"></p>
				<p>Arrival Time <input type="date" name="arrivalTime"></p>
				<p><input type="submit" value="Submit"></p>
			</form>
		</div>
	</div>
</body>
</html>