<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
-->

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

	<!-- check how many flights have been selected. If one flight has been selected
		 allow the passanger the option to add another flight. Otherwise, redirect the passager
		 to pay for the flights selected.
	 -->
	<c:out value="${param.firstFlight}" />
	<c:if test="${param.firstFlight == 'true' }">
		<c:redirect url = "SearchServlet"/>
    </c:if>

	
	
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
	    				<form action='flightResults.jsp' method='GET'>
	    				<input type='hidden' name='flightId' value='${flightList.flightId}'>
	    				<input type="hidden" name="from" value=<c:out value="${to}"/>> 
				        <input type="hidden" name="to" value=<c:out value="${from}"/>> 
				        <input type="hidden" name="departureDate" value=<c:out value="${returningDate}"/>> 
				        <input type="hidden" name="returningDate" value="null"> 
				        <input type="hidden" name="firstFlight" value="true">
				        <input type="hidden" name="secondFlight" value="false">
						<input type='submit' value='buy!'>

			           </form></td>
	    			</tr>
				</c:forEach>
				</table> <!-- End of table -->
	     </div>
	</div>
</body>
</html>