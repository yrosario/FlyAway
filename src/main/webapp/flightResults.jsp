<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
-->

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- Main div -->
	<div>

		<!-- Header div -->
		<div>
			<h1>
				Flight Results
			</h1>
		</div>

		<!-- Body div -->
		<div>
		    <!-- Flight table -->
		    <table>
			    <!-- Print flight list -->
				<c:forEach var="flightList" items="${flightList}">
                     
                    <tr>	    	
	    				<td>${flightList.departureTime}</td>
	    				<td>${flightList.arrivalTime}</td>
	    				<td>${flightList.airportDepatureId}</td>
	    				<td>${flightList.airportArrId}</td>
	    				<td>${flightList.availableSeats}</td>
	    				<td>
	    				<form action='BuyFlightServlet' method='POST'>
	    				<input type='hidden' name='flightId' value='${flightList.flightId}'>
						<input type='submit' value='buy!'>
			
			           </form></td>
	    			</tr>
				</c:forEach>
				</table> <!-- End of table -->
	     </div>
	</div>
</body>
</html>