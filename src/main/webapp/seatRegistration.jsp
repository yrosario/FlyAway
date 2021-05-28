<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Seat Registration Form</title>
</head>
<body>

	<!-- Main div -->
	<div>
		<!-- Header div -->
		<div><h1>Seat Registration</h1></div>
		
		<!-- Body div -->
		<div>
			<!-- Form div -->
			<div>
				<form action="SeatRegistrationServlet" method="POST">
					<p>Flight Number <input type="text" name="flightNo"></p>
					<p>Seat Number <input type="text" name="seatNo"></p>
					<p>price <input type="text" name="price"></p>
					<br>
					<input type="submit" value="submit">
				
				</form>
			
			
			
			</div><!-- end of form -->
		
		
		</div><!-- End of body div -->
		
	</div><!-- End of main div -->

</body>
</html>