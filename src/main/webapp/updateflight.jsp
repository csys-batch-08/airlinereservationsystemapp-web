<%@page import="com.airlinereservationsystemapp.Models.Flight_list"%>
<%@page import="com.airlinereservationsystemapp.DaoImpl.FlightSearchDao"%>
<%@page import="Services.FlightService"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>UPDATE FLIGHT</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>


</head>
<style>
body {
	background-image: url(image/878641.jpg);
	background-repeat: no-repeat;
	background-size: cover;
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
</style>
<body>
	<a href="Sourcedestination" class="btn btn-primary"
		style="font-style: italic"> Back </a>
	<br>
	<br />


	<h1 style="text-align: center;">

		<c:set var="flight" value="${Flight_id}" />
		<strong>UPDATE FLIGHT DETAILS</strong>
	</h1>

	<form name="addflight" action="UpdateFlight" method="post">
             <label class="visually-hidden" for="Flightid"></label>
		<input type="number" class="form-control " id="Flightid"
			name="Flightid" value="${flight.getFlight_id()}" readonly
			style="position: relative; width: 250px; left: 38px; top: 0px;">
				<br> <br /> 
				<input type="text" class="form-control"
			value="${flight.getFlight_name()}" name="Flightname" id="Flightname"
			style="position: relative; width: 250px; left: 38px; top: -29px;">


		<br> <input type="text" class="form-control"
			value="${flight.getSource()}" name="source" id="source"
			style="position: relative; width: 250px; left: 38px; top: -25px;">


		<br> <input type="text" class="form-control"
			value="${flight.getDestination()}" name="Destination"
			id="Destination"
			style="position: relative; width: 250px; left: 38px; top: -21px;">

		<br> <input type="number" class="form-control"
			value="${flight.getEconomy_class()}" name="Economyclass"
			id="Economyclass"
			style="position: relative; width: 250px; left: 38px; top: -17px;">

		<br> <input type="number" class="form-control"
			value="${flight.getPremium_Economy_class()}"
			name="PremiumEconomyclass" id="PremiumEconomyclass"
			style="position: relative; width: 250px; left: 38px; top: -14px;">

		<br> <input type="number" class="form-control"
			value="${flight.getBussiness_class()}" name="Bussinessclass"
			id="Bussinessclass"
			style="position: relative; width: 250px; left: 38px; top: -10px;">
		<br> <input type="date" class="form-control"
			value="${flight.getDeparture_time()}" name="DepartureDate"
			id="DepartureDate"
			style="position: relative; width: 250px; left: 38px; top: -6px;">

		<br> <input type="date" class="form-control"
			value="${flight.getArrival_Time()}" name="ArrivalDate"
			id="ArrivalDate"
			style="position: relative; width: 250px; left: 38px; top: -2px;">


		<br> <input type="text" class="form-control"
			value="Yet To Arrived" name="Status" id="Status"
			style="position: relative; width: 250px; left: 38px; top: 2px;">


		<br>
		<div style="text-align: center">
			<button type="Submit" class="btn btn-primary"
				style="position: relative; left: 40px; height: 36px; top: -30px; width: 230px">
				SUBMIT</button>
		</div>
	</form>

	<script>
		today();
		function today() {
			var today = new Date();
			var dd = String(today.getDate()).padStart(2, '0');
			var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
			var yyyy = today.getFullYear();
			var yyyy1 = today.getFullYear() + 10;
			maxdate = yyyy1 + '-' + mm + '-' + dd;
			mindate = yyyy + '-' + mm + '-' + dd;
			document.getElementById("ArrivalDate").setAttribute("max", maxdate);
			document.getElementById("ArrivalDate").setAttribute("min", mindate);
		}
	</script>
	<script>
		today();
		function today() {
			var today = new Date();
			var dd = String(today.getDate()).padStart(2, '0');
			var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
			var yyyy = today.getFullYear();
			var yyyy1 = today.getFullYear() + 10;
			maxdate = yyyy1 + '-' + mm + '-' + dd;
			mindate = yyyy + '-' + mm + '-' + dd;
			document.getElementById("DepartureDate").setAttribute("max",
					maxdate);
			document.getElementById("DepartureDate").setAttribute("min",
					mindate);
		}
	</script>

</body>
</html>