<%@page import="com.airlinereservationsystemapp.Models.Flight_list"%>
<%@page import="com.airlinereservationsystemapp.DaoImpl.FlightSearchDao"%>
<%@page import="Services.FlightService"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>FlightApp - Add Passengers details</title>

</head>
<body>

	<style>
body {
	background-image:
		url(https://images.unsplash.com/photo-1604484384465-fbc304d466ec?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzJ8fGpldHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60);
	background-repeat: no-repeat;
	background-size: cover;
}

form {
	border: 3px solid #f1f1f1;
	width: 41%;
	align: "center";
}
</style>

	<c:set var="loggedinadmin" value="${LOGGED_IN_ADMIN}" />

	<c:set var="loggedinuser" value="${LOGGED_IN_USER}" />

	<c:set var="flight" value="${Addlist}" />



	<main class="container-fluid">
		<div align="center">

			<a href="Sourcedestination" class="btn btn-warning"
				style="font-style: italic"> Back </a> <br> <br />




			<form action="ConfirmDetails" method="post">
				<h2>Booking Details</h2>

				<label for="flightId"
					style="font-family: serif; font-size: 18px; position: relative; width: 250px; top: 6px; left: -113px; height: 20px;">Flight
					Id:</label> <input type="text" class="form-control" name="flightId"
					id="flightId" value="${flight.getFlightId()}" readonly
					style="position: relative; width: 238px; top: -26px; left: 99px; height: 32px;">

				<label for="source"
					style="font-family: serif; font-size: 18px; position: relative; width: 250px; top: 3px; left: -111px; height: 20px;">Source:</label>
				<input type="text" class="form-control" name="source" id="source"
					value="${flight.getSource()}" readonly
					style="position: relative; width: 238px; top: -26px; left: 99px; height: 32px;">

				<label for="destination"
					style="font-family: serif; font-size: 18px; position: relative; width: 250px; top: 3px; left: -120px; height: 20px;">Destination:</label>
				<input type="text" class="form-control" name="destination"
					id="destination" value="${flight.getDestination()}" readonly
					style="position: relative; width: 238px; top: -26px; left: 99px; height: 32px;">

				<label for="departuredate"
					style="font-family: serif; font-size: 18px; position: relative; width: 250px; top: 4px; left: -113px; height: 20px;">Departure
					Date:</label> <input type="text" class="form-control" name="departuredate"
					id="departuredate" value="${flight.getDeparture_Date()}" readonly
					style="position: relative; width: 238px; top: -26px; left: 99px; height: 32px;">






				<input type="hidden" name="Economy_class" id="Economy" readonly />



				<input type="hidden" name="PremiumEconomyclass" id="PremiumEconomy"
					readonly /> <input type="hidden" name="Bussinessclass"
					id="Bussiness" readonly /> <input type="hidden"
					name="Economyclass" id="Economyclass"
					value="${flight.getEconomy_class()}" readonly /> <input
					type="hidden" name="PremiumEconomyclass" id="PremiumEconomyclass"
					value="${flight.getPremium_Economy_class()}" readonly /> <input
					type="hidden" name="Bussinessclass" id="Bussinessclass"
					value="${flight.getBussiness_class() }" readonly /> <label
					for="username"
					style="font-family: serif; font-size: 18px; position: relative; width: 250px; top: 5px; left: -113px; height: 20px;">Passenger
					Name:</label> <input type="text" class="form-control" name="username"
					id="username" required autofocus pattern="[A-Z  a-z]{3,20}"
					placeholder="Enter PassengerName"
					style="position: relative; width: 238px; top: -26px; left: 99px; height: 32px;">

				<label for="MobileNumber"
					style="font-family: serif; font-size: 18px; position: relative; width: 250px; top: 6px; left: -113px; height: 20px;">Mobile
					No:</label> <input type="tel" class="form-control" name="MobileNumber"
					id="MobileNumber" required pattern="[6-9][0-9]{9}"
					placeholder="Enter mobileno"
					style="position: relative; width: 238px; top: -26px; left: 99px; height: 32px;">

				<label for="coach"
					style="position: relative; left: -4px; height: 25px; top: 0px; width: 230px">Coach:</label>

				<c:set var="ecoseats" value="${flight.getEconomy_class()}" />

				<fmt:parseNumber var="economy" type="number" integerOnly="true"
					value="${ecoseats}" />

				<c:set var="preseats" value="${flight.getPremium_Economy_class()}" />

				<fmt:parseNumber var="premium" type="number" integerOnly="true"
					value="${preseats}" />

				<c:set var="busseats" value="${flight.getBussiness_class()}" />


				<fmt:parseNumber var="bussiness" type="number" integerOnly="true"
					value="${busseats}" />

				<c:choose>

					<c:when test="${economy==0}">

						<select name="coach" id="coach"
							style="position: relative; left: 66px; height: 26px; top: -6px; width: 230px">

							<option value="Bussiness">Business Class</option>
							<option value="premium">Premium Economy</option>
						</select>
					</c:when>
					<c:when test="${premium==0}">
					<label class="visually-hidden" for="coach"></label>
						<select name="coach" id="coach"
							style="position: relative; left: 66px; height: 26px; top: -6px; width: 230px">

							<option value="Bussiness">Business Class</option>
							<option value="Economy">economy</option>
						</select>
					</c:when>

					<c:when test="${bussiness==0}">
					<label class="visually-hidden" for="coach"></label>
						<select name="coach" id="coach"
							style="position: relative; left: 66px; height: 26px; top: -6px; width: 230px">
							<option value="Economy">economy</option>
							<option value="premium">Premium Economy</option>
						</select>
					</c:when>

					<c:otherwise>
						<label class="visually-hidden" for="coach"></label>
						<select class="form-select" name="coach" id="coach"
							style="position: relative; width: 238px; top: -3px; left: -17px; height: 32px;">

							<option value="Bussiness">Business Class</option>
							<option value="Economy">economy</option>
							<option value="premium">Premium Economy</option>
						</select>
					</c:otherwise>
				</c:choose>
				<br>
				<c:choose>


					<c:when test="${fn:containsIgnoreCase(loggedinuser,'Guest')}">

						<label for="numberOfPassengers" 
							style="font-family: serif; font-size: 18px; position: relative; width: 250px; top: 11px; left: -140px; height: 20px;">Number
							of passengers:</label>
						<input type="number" class="form-control"
							name="numberOfPassengers" id="numberOfPassengers" min="1" max="8"
							pattern="[1-8]" placeholder="Enter passengers count"
							oninput="calculation()" required
							style="position: relative; width: 238px; top: -15px; left: 99px; height: 32px;">


					</c:when>
					<c:otherwise>

						<label for="numberOfPassengers"
							style="font-family: serif; font-size: 18px; position: relative; width: 250px; top: 11px; left: -140px; height: 20px;">Number
							of passengers:</label>
						<input type="number" class="form-control"
							name="numberOfPassengers" id="numberOfPassengers" min="1" max="8"
							pattern="[1-8]" placeholder="Enter passengers count"
							oninput="calc()" required
							style="position: relative; width: 238px; top: -15px; left: 99px; height: 32px;">

					</c:otherwise>
				</c:choose>


				<c:set var="eco" value="${flight.getEconomy_rate()}"></c:set>


				<fmt:parseNumber var="economy" value="${eco}" />

				<c:set var="pre" value="${flight.getPremium_Economy_rate()}"></c:set>

				<fmt:parseNumber var="premium" value="${pre}" />

				<c:set var="bus" value="${flight.getBussiness_rate()}"></c:set>

				<fmt:parseNumber var="business" value="${bus}" />


				<label for="firstClassPrice"
					style="font-family: serif; font-size: 18px; position: relative; width: 250px; top: 9px; left: -126px; height: 20px;">Economy
					Price :</label> <input type="text" class="form-control"
					name="firstClassPrice" id="firstClassPrice" value="${economy}"
					readonly
					style="position: relative; width: 238px; top: -19px; left: 99px; height: 32px;">


				<label for="economyClassPrice"
					style="font-family: serif; font-size: 18px; position: relative; width: 250px; top: 9px; left: -140px; height: 20px;">
					Premium Economy Price :</label> <input type="text" class="form-control"
					name="economyClassPrice" id="economyClassPrice" value="${premium}"
					readonly
					style="position: relative; width: 238px; top: -19px; left: 99px; height: 32px;">


				<label for="businessClassPrice"
					style="font-family: serif; font-size: 18px; position: relative; width: 250px; top: 9px; left: -126px; height: 20px;">Business
					Class Price:</label> <input type="text" class="form-control"
					name="businessClassPrice" id="businessClassPrice"
					value="${business}" readonly
					style="position: relative; width: 238px; top: -19px; left: 99px; height: 32px;">


				<label for="price"
					style="font-family: serif; font-size: 18px; position: relative; width: 250px; top: 9px; left: -126px; height: 20px;">Price:</label>
				<input type="number" class="form-control" name="price" id="price"
					readonly
					style="position: relative; width: 238px; top: -19px; left: 99px; height: 32px;">


				<div style="text-align: center">

                    <label class="visually-hidden" for="button"></label>
					<button type="submit" class="btn btn-primary" id="button"
						style="position: relative; left: 11px; height: 39px; top: -6px; width: 214px">ConfirmDetails</button>

				</div>

			</form>
		</div>
	</main>
	<script>
		function calc() {
			event.preventDefault();

			let coach = document.getElementById("coach").value;
			console.log(coach);

			let numberOfPassengers = document
					.getElementById("numberOfPassengers").value;
			let economyClassPrice = document
					.getElementById("economyClassPrice").value;
			let businessClassPrice = document
					.getElementById("businessClassPrice").value;
			let firstClassPrice = document.getElementById("firstClassPrice").value;
			let premiumseats = document.getElementById("PremiumEconomyclass").value;
			let Businesseats = document.getElementById("Bussinessclass").value;
			let economyseats = document.getElementById("Economyclass").value;

			let price = 0;
			let seats = 0;
			let totalprice = 0;

			switch (coach) {
			case "premium": {
				totalprice = numberOfPassengers * economyClassPrice;
				price = totalprice - (totalprice * 5 / 100)

				console.log(totalprice);

				document.getElementById("price").value = price;
				seats = premiumseats - numberOfPassengers;
				document.getElementById("PremiumEconomy").value = seats;
				console.log(seats);

				break;
			}
			case "Economy": {
				totalprice = numberOfPassengers * firstClassPrice;
				price = totalprice - (totalprice * 8 / 100)

				document.getElementById("price").value = price;

				seats = economyseats - numberOfPassengers;
				console.log(seats);
				document.getElementById("Economy").value = seats;

				break;
			}
			case "Bussiness": {
				totalprice = numberOfPassengers * businessClassPrice;
				price = totalprice - (totalprice * 10 / 100)

				document.getElementById("price").value = price;
				seats = Businesseats - numberOfPassengers;
				document.getElementById("Bussiness").value = seats;

				break;
			}
			}
		}

		function calculation() {
			event.preventDefault();

			let coach = document.getElementById("coach").value;
			console.log(coach);

			let numberOfPassengers = document
					.getElementById("numberOfPassengers").value;
			let economyClassPrice = document
					.getElementById("economyClassPrice").value;
			let businessClassPrice = document
					.getElementById("businessClassPrice").value;
			let firstClassPrice = document.getElementById("firstClassPrice").value;
			let premiumseats = document.getElementById("PremiumEconomyclass").value;
			let Businesseats = document.getElementById("Bussinessclass").value;
			let economyseats = document.getElementById("Economyclass").value;

			let price = 0;
			let seats = 0;
			let pricevalue = 0;
			let totalprice = 0;
			switch (coach) {
			case "premium": {
				totalprice = numberOfPassengers * economyClassPrice;
				price = totalprice + (totalprice * 5 / 100);

				console.log(totalprice);
				console.log(price);

				document.getElementById("price").value = price;
				seats = premiumseats - numberOfPassengers;
				document.getElementById("PremiumEconomy").value = seats;
				console.log(seats);

				break;
			}
			case "Economy": {
				totalprice = numberOfPassengers * firstClassPrice;
				price = totalprice + (totalprice * 8 / 100);

				document.getElementById("price").value = price;

				seats = economyseats - numberOfPassengers;
				console.log(seats);
				// }
				document.getElementById("Economy").value = seats;

				break;
			}
			case "Bussiness": {
				totalprice = numberOfPassengers * businessClassPrice;
				price = totalprice + (totalprice * 10 / 100);

				document.getElementById("price").value = price;
				seats = Businesseats - numberOfPassengers;
				document.getElementById("Bussiness").value = seats;

				break;
			}
			}

		}
	</script>
</body>
</html>