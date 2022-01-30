<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@page import="com.airlinereservationsystemapp.Models.Passenger_details"%>
    <%@page import="java.util.List"%>
            <%@ page import="java.time.LocalDate"%> 
                <%@ page import="java.sql.Date"%>
                            <%@page import="com.airlinereservationsystemapp.DaoImpl.Passenger_detailsDao"%>
                     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                     <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
                 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CANCEL LIST</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
  background-color: navy;
}




</style>
<body>

<a href="flightSearch.jsp"class="btn btn-primary" style="font-style: italic"> Back </a> <br > <br />



		   		<table border="2" class="table">
			<h1 align="center"><b>Flight List</b></h1>
			<thead>
				<tr class="info">
				   <th  >S.no</th>
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
			
			<tbody>

      <c:forEach items="${CancelList}" var="cancel" varStatus="status">
 
				<tr>
				
					
					
  		<td>${status.count}</td>		
					<td>${cancel.getClass_details().toUpperCase()}</td>
					<td>${cancel.getMobile_number()}</td>
					
					<td>${cancel.getSource()}</td>
					
					<td>${cancel.getDestination()}</td>
					<td> ${cancel.getFlight_id()}</td>
					<fmt:parseDate value="${cancel.getArrival_date()}" pattern="yyyy-MM-dd" var="macthDate" type="date"/>
					<td><fmt:formatDate value="${macthDate}" pattern="dd-MM-yyyy"/>  </td>
					
					<td> ${cancel.getTicketNo()}</td>
										
					
					<td class="success"> ${cancel.getSeatno()}</td>
					<td class="danger"> ${cancel.getStatus()}</td>
					<fmt:parseDate value="${cancel.getBookingdate()}" pattern="yyyy-MM-dd" var="bookingdate" type="date"/>
					
					<td><fmt:formatDate value="${bookingdate}"  pattern="dd-MM-yyyy" />    </td>
					<td>${cancel.getMode()}</td>
					<td class="warning">${cancel.getAmount()}</td> 
					
					
					
					
					
					
					
 

             <c:set var="datevalue"  value="${Arrivaldate}"  />
             <c:set  var="cureendate"  value="${Currentdatetime}"   />
              <c:set var="curendd"  value="${Arrives}"  />
              
 					<c:set var="status" value="${cancel.getStatus() }" />  
 					
	 	<c:choose>
 	
 	<c:when test="${cureendate<cancel.getArrival_date()}">
 	 	<c:choose>
 	 	
 	 	 	<c:when test= "${cancel.getStatus().equals('Cancelled')}">
 	<td>CANCELLED</td>
 	
 	</c:when>
 	<c:otherwise>

	     		<td><a href="flightcancellation.jsp?seatno=${cancel.getSeatno()}&Flightid=${cancel.getFlight_id()}&Departuredate=${cancel.getArrival_date()}
	&Class=${cancel.getClass_details()}&Amount=${cancel.getAmount()}"
		class="btn btn-primary" >CancelTicket</a></td>
 	</c:otherwise>
 	 	
 	 	</c:choose>
 	
				
		</c:when>
<c:otherwise>	

<td>DEPARTED</td>


</c:otherwise>					
					</c:choose>
					
 					</tr>																	</c:forEach>
			
					</tbody>
		           </table>
		           
</body>

</html>