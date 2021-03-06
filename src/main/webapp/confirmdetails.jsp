<%@page
	import="com.airlinereservationsystemapp.Models.PassengerDetails"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Confirm Details</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<style>
body {
	background-image: url(image/flih.jpg);
	background-repeat: no-repeat;
	background-size: contain;
	overflow-y: hidden
}

form {
	border: 3px solid #f1f1f1;
	width: 35%;
	height: 50%;
	align: "center";
}
</style>
	<c:set var="passengers" value="${Passenger_Deatils}" />
	<main class="container-fluid">
		<h3 align="center">Confirm Details</h3>
		<div align="center"
			style="position: relative; height: 1200px; margin: 0px;">
			<form action="AddPassenger" method="post">
				<label for="username"
					style="font-family: serif; font-size: 18px; position: relative; width: 250px; top: 33px; left: -117px; height: 20px;">PassengerName
				</label> <input type="text" class="form-control" name="username"
					id="username" value="${passengers.getPassenger_name()}" readonly
					style="position: relative; width: 214px; top: 7px; left: 73px; height: 32px;">
				<br /> <br> <br> <label for="coach"
					style="font-family: serif; font-size: 18px; position: relative; width: 250px; top: -29px; left: -117px; height: 20px;">CoachDetails
				</label> <input type="text" class="form-control" name="coach" id="coach"
					value="${passengers.getClass_details()}" readonly
					style="position: relative; width: 214px; top: -60px; left: 73px; height: 32px;">
				<br /> <br /> <label for="MobileNumber"
					style="font-family: serif; font-size: 18px; position: relative; width: 250px; top: -74px; left: -117px; height: 20px;">MobileNumber
				</label> <input type="text" class="form-control" name="MobileNumber"
					id="MobileNumber" value="${passengers.getMobile_number()}" readonly
					style="position: relative; width: 214px; top: -99px; left: 73px; height: 32px;">
				<br /> <br /> <label for="source"
					style="font-family: serif; font-size: 18px; position: relative; width: 250px; top: -110px; left: -117px; height: 20px;">Source
				</label> <input type="text" class="form-control" name="source" id="source"
					value="${passengers.getSource()}" readonly
					style="position: relative; width: 214px; top: -138px; left: 73px; height: 32px;">
				<br /> <br /> <label for="destination"
					style="font-family: serif; font-size: 18px; position: relative; width: 250px; top: -146px; left: -117px; height: 20px;">Destination
				</label> <input type="text" class="form-control" name="destination"
					id="destination" value="${passengers.getDestination()}" readonly
					style="position: relative; width: 214px; top: -177px; left: 73px; height: 32px;">
				<br /> <br /> <label for="bookingDate"
					style="font-family: serif; font-size: 18px; position: relative; width: 250px; top: -189px; left: -117px; height: 20px;">Departed
					Date </label> <input type="text" class="form-control" name="bookingDate"
					id="bookingDate" value="${passengers.getArrival_date()}" readonly
					style="position: relative; width: 214px; top: -216px; left: 73px; height: 32px;">
				<br /> <br /> <label for="numberOfPassengers"
					style="font-family: serif; font-size: 18px; position: relative; width: 250px; top: -228px; left: -117px; height: 20px;">NoOfPassengers
				</label> <input type="text" class="form-control" name="numberOfPassengers"
					id="numberOfPassengers" value="${passengers.getNoOfPassengers()}"
					readonly
					style="position: relative; width: 214px; top: -255px; left: 73px; height: 32px;">
				<br /> <br /> <label for="flightId"
					style="font-family: serif; font-size: 18px; position: relative; width: 250px; top: -264px; left: -117px; height: 20px;">Flight
					Id</label> <input type="text" class="form-control" name="flightId"
					id="flightId" value="${passengers.getFlight_id()}" readonly
					style="position: relative; width: 214px; top: -294px; left: 73px; height: 32px;">
				<br /> <br /> <input type="hidden" name="Economyclass"
					id="Economyclass" value="${passengers.getEconomyseat()}" readonly />
				<input type="hidden" name="PremiumEconomyclass"
					id="PremiumEconomyclass"
					value="${passengers.getPremiumeconomyseats()}" readonly /> <input
					type="hidden" name="Bussinessclass" id="Bussinessclass"
					value="${passengers.getBusinessseats()}" readonly /> <input
					type="hidden" name="ticketno" id="ticketno"
					value="${passengers.getTicketNo()}" readonly /> <input
					type="hidden" name="amount" id="amount"
					value="${passengers.getAmount()}" readonly /> <br /> <br /> <input
					type="hidden" name="seatno" id="amount"
					value="${passengers.getSeatno()}" readonly /> <br /> <label
					class="visually-hidden" for="button">Name</label>
				<button type="submit" class="btn btn-outline-primary" id="button"
					style="position: relative; top: -397px; left: -6px; width: 99px; height: 35px;">Submit</button>
			</form>
		</div>
	</main>
</body>
</html>