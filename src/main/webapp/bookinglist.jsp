<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="com.airlinereservationsystemapp.Models.Passenger_details"%>
    <%@page import="java.util.List"%>
            <%@page import="com.airlinereservationsystemapp.DaoImpl.Passenger_detailsDao"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
            
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
    
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Booking Details</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<style>

a:link, a:visited {
  background-color: #f44336;
  color: white;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: buttonface;
}


</style>
<body>

<!-- <a href="flightSearch.jsp"class="btn btn-primary" style="font-style: italic;"> Back </a> <br > <br /> -->

<a href="Sourcedestination"class="btn btn-primary" style="font-style: italic;"> Back </a> <br > <br />



<%-- <%  
		List<Passenger_details> objbookinglist = (List<Passenger_details>)request.getAttribute("Bookinglist");
 
		%>
 --%>		
		   		<table border="2" class="table">
			<h1 align="centre"><b>Booking  List</b></h1>
			<thead>
				<tr class="table-secondary">
				   <th >S.no</th>
					<th>Passenger Name</th>
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
					
					
					
					</tr>
			</thead>
<br>
			<tbody>

			
				     <c:forEach items="${Bookinglist}" var="booking" >
				     
							<c:set var="i" value="${i+1}"/>
				
				<tr>
				
					
 <td>${i}</td>		
 
					<td class="table-success">${booking.getPassenger_name()}</td>
					<td>${booking.getClass_details()}</td>
					<td>${booking.getMobile_number()}</td>
					<td>${booking.getSource()}</td>
					<td>${booking.getDestination()}</td>
					<td class="table-danger">${booking.getFlight_id()}</td>
					<td>${booking.getArrival_date()}</td>
					<td>${booking.getTicketNo()}</td>
					<td class="table-active" >${booking.getSeatno()}</td>
					<td>${booking.getStatus()}</td>					
					<td>${booking.getBookingdate()}</td>
					
					
			</tr>
					</c:forEach>
					
					</tbody>
		           </table>
			
			
		


</body>
</html>