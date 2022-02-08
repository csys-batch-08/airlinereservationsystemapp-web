<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="com.airlinereservationsystemapp.Models.Passenger_details"%>
<%@page import="java.util.List"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.sql.Date"%>
<%@page
	import="com.airlinereservationsystemapp.DaoImpl.Passenger_detailsDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>GUEST CANCEL LIST</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<a href="Sourcedestination" class="btn btn-primary"
		style="font-style: italic"> Back </a>
	<br>
	<br />
	<table border="2" class="table">
		<h1 align="center">
			<strong>Flight List</strong>
		</h1>
		<thead>
			<tr class="info">
				<th>S.no</th>
				<th>Class Details</th>
				<th>MobileNumber</th>
				<th>Source</th>
				<th>Destination</th>
				<th>FlightID</th>
				<th>DeparturedDate</th>
				<th>TicketNo</th>
				<th>SeatNo</th>
				<th>Status</th>
				<th>BookingDate</th>
				<th>ModeStatus</th>
				<th>TotalAmount</th>
				<th>CancelFlight</th>
			</tr>
		</thead>
		<br>
		<br>
		<c:forEach items="${GuestList}" var="guestcancel" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${guestcancel.getClass_details().toUpperCase()}</td>
				<td>${guestcancel.getMobile_number()}</td>
				<td>${guestcancel.getSource()}</td>
				<td>${guestcancel.getDestination()}</td>
				<td>${guestcancel.getFlight_id()}</td>
				<fmt:parseDate value="${guestcancel.getArrival_date()}"
					pattern="yyyy-MM-dd" var="guestarrivaldate" type="date" />
				<td><fmt:formatDate value="${guestarrivaldate}"
						pattern="dd-MM-yyyy" /></td>
				<td>${guestcancel.getTicketNo()}</td>
				<td class="success">${guestcancel.getSeatno()}</td>
				<td class="danger">${guestcancel.getStatus()}</td>
				<fmt:parseDate value="${guestcancel.getBookingdate()}"
					pattern="yyyy-MM-dd" var="bookeddate" type="date" />
				<td><fmt:formatDate value="${bookeddate}" pattern="dd-MM-yyyy" />
				</td>
				<td>${guestcancel.getMode()}</td>
				<td class="warning">${guestcancel.getAmount()}</td>
				<c:set var="datevalue" value="${Arrivaldate}" />
				<c:set var="guestcan" value="${Guestcurentdate}" />
				<c:set var="status" value="${guestcancel.getStatus() }" />
				<c:choose>
					<c:when test="${guestcan<guestcancel.getArrival_date()}">
						<c:choose>
							<c:when test="${guestcancel.getStatus().equals('Cancelled')}">
								<td>CANCELLED</td>
							</c:when>
							<c:otherwise>
								<td><a
									href="flightcancellation.jsp?seatno=${guestcancel.getSeatno()}&Flightid=${guestcancel.getFlight_id()}&Departuredate=${guestcancel.getArrival_date()}
	&Class=${guestcancel.getClass_details()}&Amount=${guestcancel.getAmount()}&Mode=${guestcancel.getMode()}"
									class="btn btn-primary">CancelTicket</a></td>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<td>DEPARTED</td>
					</c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>