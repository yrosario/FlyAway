<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Airline Registration Form</title>
</head>
<body>

	<!-- Main div -->
	<div>
		<!-- Header div -->
		<div><h1>Airline Registration</h1></div>
		
		<!-- Body div -->
		<div>
			<!-- Form div -->
			<div>
				<form action="AirlineRegistrationServlet" method="POST">
					<p>Name <input type="text" name="name"></p>
					<p>flightNo<input type="text" name="flightNo"></p>
					<br>
					<input type="submit" value="submit">
				
				</form>
			
			
			
			</div><!-- end of form -->
		
		
		</div><!-- End of body div -->
		
	</div><!-- End of main div -->

</body>
</html>