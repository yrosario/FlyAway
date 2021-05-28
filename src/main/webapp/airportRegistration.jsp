<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Airport Registration Form</title>
</head>
<body>

	<!-- Main div -->
	<div>
		<!-- Header div -->
		<div><h1>Airport Registration</h1></div>
		
		<!-- Body div -->
		<div>
			<!-- Form div -->
			<div>
				<form action="AiportRegistrationServlet" method="POST">
					<p>Airport name <input type="text" name="name"></p>
					<p>Country<input type="text" name="country"></p>
					<p>State<input type="text" name="state"></p>
					<p>City<input type="text" name="city"></p>
					<br>
					<input type="submit" value="submit">
				
				</form>
			
			
			
			</div><!-- end of form -->
		
		
		</div><!-- End of body div -->
		
	</div><!-- End of main div -->

</body>
</html>