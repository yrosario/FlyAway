<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Staff Registration Form</title>
</head>
<body>

	<!-- Main div -->
	<div>
		<!-- Header div -->
		<div><h1>Staff Registration</h1></div>
		
		<!-- Body div -->
		<div>
			<!-- Form div -->
			<div>
				<form action="StaffRegistrationServlet" method="POST">
					<p>First Name<input type="text" name="fname"></p>
					<p>Last Name<input type="text" name="lname"></p>
					<p>Phone No.<input type="text" name="phoneNo"></p>
					<p>Address<input type="text" name="address"></p>
					<p>email<input type="email" name="email"></p>
					<br>
					<input type="submit" value="submit">
				
				</form>
			
			
			
			</div><!-- end of form -->
		
		
		</div><!-- End of body div -->
		
	</div><!-- End of main div -->

</body>
</html>