<%@page import="com.airlinereservationsystemapp.Models.Source"%>
<%@page import="Services.FlightService"%>
<%@page import="java.util.List.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<!DOCTYPE html>
<html lang="en">
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Payment Page</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
 <body>

 	<style>
body {
	background-image: url(image/bg9.jpg);
	background-repeat: no-repeat;
	height: 100%;
	width: 100%;
	background-size: cover;
	top: 0;
	right: 0;
	left: 0;
	bottom: 0;
	z-index: -1;
	position: absolute;
	font-family: Arial, Helvetica, sans-serif;
}

form {
	width: 50%;
	align: "center";
}

input[type=text] {
	width: 50%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

input[type=radio] {
	width: 8%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #04AA6D;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 32%;
}

button:hover {
	opacity: 0.8;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

img.avatar {
	width: 23%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}

a:link, a:visited {
	background-color: blue;
	color: white;
	padding: 14px 25px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
}

a:hover, a:active {
	background-color: red;
}

.container {
	position: absolute;
	text-align: center;
	margin-left: 10%;
	margin-top: 5%;
}

#master {
	visibility: hidden;
}

#groups {
	visibility: hidden;
}

#master {
	position: fixed;
	width: 40%;
}

#fun {
	position: fixed;
	width: 100%;
}

#groups {
	position: fixed;
	width: 40%
}
</style>
	<c:set value="${LOGGED_IN_USER}" var="loguser" />
	<c:set value="${ROLE}" var="role" />
	<c:set value="${Flight_id}" var="flightid" />
	<c:set value="${Ticket_no}" var="ticketno" />
	<c:set value="${Amont}" var="amount" />
	<c:set value="${Seatfield}" var="seatnumeric" />
<!-- 	<main class="container-fluid"> -->
		<h3 align="center">Payment Details</h3>
		<div align="center">
			<div class="Files" id="fun">
				<form action="Payment" method="post">
					<label for="flightid"><strong>Flight Id</strong></label> <input
						type="text" id="flightid" name="flightid" value="${flightid}"
						readonly> <br></br> <label for="ticketno"><strong>Ticket
							No</strong></label> <input type="text" name="ticketno" id="ticketno"
						value="${ticketno}" readonly> <br></br> <label
						for="Amount"><strong>Amount</strong>></label> <input type="text"
						name="Amount" id="Amount" value="${Amont}" readonly> <br></br>
					<label for="seatno"><strong>SEATNO</strong>></label> <input
						type="text" name="seatno" id="seatno" value="${seatnumeric}"
						readonly> <br></br>
					<c:choose>
						<c:when test="${loguser.equals('Guest')}">
							<label for="wallet""><b>Mode *</b></label>
							<input type="radio" name="yesCheck" value="Creditcard" required>
							<label for="card">Credit Card</label>
							<input type="radio" name="yesCheck" value="Debitcard" required>
							<label for="card">Debit card</label>
							<br>
							<br>
							<button type="Submit" required>SUBMIT</button>
						</c:when>
						<c:otherwise>
							<label for="wallet"><b>Mode *</b></label>
							<input type="radio" name="yesCheck" value="Creditcard" required>
							<label for="card">Credit Card</label>
							<input type="radio" name="yesCheck" value="Debitcard" required>
							<label for="card">Debit card</label>
							<input type="radio" name="yesCheck" value="Wallet" required>
							<label for="Wallet">Wallet</label>
							<br>
							<br>
							<button type="Submit">SUBMIT</button>
						</c:otherwise>
					</c:choose>
				</form>
			</div>
		</div>
</body>
</html>