<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>

	<!-- main div -->
	]
	<div>
		<div>
			<h1>New Passager Registration</h1>
		</div>

		<div>
			<form action="LoginServlet" method="post">
				<p>First name</p>
				<input type="text" name="firstname">
				<p>Last name</p>
				<input type="text" name="lastname">
				<p>Address</p>
				<input type="text" name="address">
				<p>Birthday</p>
				<input type="text" name="birthday">
				<p>Phone Number</p>
				<input type="text" name="phone">
				<p>email</p>
				<input type="text" name="email">
				<p>password</p>
				<input type="password" name="password"> 
				<input type="submit" value="submit">
			</form>


		</div>

	</div>
</body>
</html>