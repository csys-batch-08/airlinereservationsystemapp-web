<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="com.airlinereservationsystemapp.Models.Passenger_details"%>
    <%@page import="java.util.List"%>
            <%@page import="com.airlinereservationsystemapp.DaoImpl.Passenger_detailsDao"%>
    
    
<!DOCTYPE html>
<html>
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

<a href="FlightSearch.jsp"class="btn btn-primary" style="font-style: italic;"> Back </a> <br > <br />


<%  
		List<Passenger_details> objbookinglist = (List<Passenger_details>)request.getAttribute("Bookinglist");
 
		%>
		
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
			<br>
			
			<tbody>
				<%
					int i = 0;
					for (Passenger_details objbook : objbookinglist) {
						i++;
				%>
				<tr>
				
					
					<td><%=i%></td>
					<td class="table-success"><%=objbook.getPassenger_name()%></td>
					<td><%=objbook.getClass_details()%></td>
			  	<td><%=objbook.getMobile_number()%></td> 
					
					<td><%=objbook.getSource()%></td>
					
					<td> <%=objbook.getDestination()%></td>
										<td class="table-danger"> <%=objbook.getFlight_id()%></td>
															<td> <%=objbook.getArrival_date()%></td>
					
					<td> <%=objbook.getTicketNo()%></td>
										
					
					<td class="table-active"> <%=objbook.getSeatno()%></td>
										<td> <%=objbook.getStatus()%></td>
					
					<td> <%=objbook.getBookingdate()%></td>
					
					
					
			</tr>
					
					<%
				}
				%>
					</tbody>
		           </table>
			
			
		


</body>
</html>