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


		</div>

	</div>
</body>
</html>