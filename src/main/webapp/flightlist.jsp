<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.airlinereservationsystemapp.Models.FlightList"%>
<%@page import="java.util.List"%>
<%@page
	import="com.airlinereservationsystemapp.Models.FlightSeatAvailability"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>


<meta charset="ISO-8859-1">
<title>Flight List</title>

<style type="text/css">
table, td, th {
	text-align: center;
}

a:link, a:visited {
	background-color: white;
	color: black;
	padding: 14px 25px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
}

a:hover, a:active {
	background-color: green;
	color: white;
}

a:link, a:visited {
	background-color: white;
	color: black;
	border: 2px solid green;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
}

a:hover, a:active {
	background-color: green;
	color: white;
}

.passive {
	background-color: white;
	color: black;
	border: 2px solid green;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
}

.phover {
	background-color: red;
	color: white;
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<c:set var="loggedinadmin" value="${LOGGED_IN_ADMIN}" />
	<c:set var="loggedinuser" value="${LOGGED_IN_USER}" />
	<c:if test="${loggedinadmin!=null}">
		<a href="UserServlet" class="btn btn-primary">List all User
			Details</a>
		<a href="addflight.jsp" class="btn btn-primary">Add Flight</a>
		<a href="Bookingdetails" class="btn btn-primary">Booking Details</a>
		<a href="Sourcedestination" class="btn btn-outline-danger"> Back </a>
		<br>
		<br />
	</c:if>
	<c:set var="flights" value="${Flight_List }" />
	<c:if test="${flights!=null}">
		<table class="table" id="myTable">
			<h1 align="center">
				<strong>Flight List</strong>
			</h1>
			<thead class="table-warning">
				<tr>
					<th>S.no</th>
					<th>Flight Id</th>
					<th>Flight name</th>
					<th>Departing From</th>
					<th>Departing To</th>
					<th>Economy Class</th>
					<th>Premium Class</th>
					<th>Business Class</th>
					<th>Departure_Date</th>
					<th>Arrival_Date</th>
					<th>Economy Seats</th>
					<th>Premium Seats</th>
					<th>Business Seats</th>
					<th>Departured Time</th>
					<th>Arrival Time</th>
					<th>Flight Status</th>
					<c:if test="${loggedinadmin!=null}">
						<th scope="col">UpdateFlight</th>
					</c:if>
					<c:if test="${loggedinadmin!=null}">
						<th scope="col">DeleteFlight</th>
					</c:if>
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
				<c:forEach items="${Flight_List}" var="flight">
					<c:set var="i" value="${i+1 }" />
					<tr>
						<td>${i}</td>
						<td>${flight.getFlight_id()}</td>
						<td>${flight.getFlight_name()}</td>
						<td>${flight.getSource()}</td>
						<td>${flight.getDestination()}</td>
						<td>${flight.getEconomy_class()}</td>
						<td>${flight.getPremium_Economy_class()}</td>
						<td>${flight.getBussiness_class()}</td>
						<td><fmt:formatDate value="${flight.getDeparture_time()}"
								pattern="dd-MM-yyyy" /></td>
						<td><fmt:formatDate value="${flight.getArrival_Time()}"
								pattern="dd-MM-yyyy" /></td>
						<td>${flight.getEconomyseats()}</td>
						<td>${flight.getPremiumseats()}</td>
						<td>${flight.getBusinessseats()}</td>
						<td>${flight.getDepartureTime()}</td>
						<td>${flight.getArrivaltime()}</td>
						<td>${flight.getFlightstatus()}</td>
						<c:if test="${loggedinadmin!=null}">
							<td><a href="Update?flightId=${flight.getFlight_id()}"
								class="btn btn-danger">UpdateFlight</a></td>
						</c:if>
						<c:if test="${loggedinadmin!=null}">
							<td><a href="Delete?flightId=${flight.getFlight_id()}"
								class="btn btn-danger">DeleteFlight</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<script>
		$(document).ready(function() {
			$('#myTable').DataTable();
		});
	</script>
</body>
</html>