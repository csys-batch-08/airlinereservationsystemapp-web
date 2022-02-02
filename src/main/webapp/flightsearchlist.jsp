<%@page import="com.airlinereservationsystemapp.Models.Flight_Seat_Availability"%>
<%@page import="java.util.List"%>
                     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                     <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Flight List</title>
<style type="text/css">
table, td, th {
	text-align: center;
}

</style>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>

<body>


<%-- <%
String loggedInAsAdmin = (String) session.getAttribute("LOGGED_IN_ADMIN");
String loggedInAsUser = (String) session.getAttribute("LOGGED_IN_USER");

%> --%>

<c:set var="loggedinuser"    value="${LOGGED_IN_USER}"/>  

<c:set var="loggedinadmin"    value="${LOGGED_IN_ADMIN}"/>  

<c:set var="flights" value="${Flight_List}" />
		
		 <c:if test="${flights!= null}">
		 
		<a href="Sourcedestination" style="position: relative;left:339px;top:70px;width: 140px;height: 29px; font-style: italic;  " class="btn btn-primary"> Back </a> <br > <br />


 
		<table class="table table-hover">
			<h1><b>Flight List</b></h1>
			<thead>
				<tr>
				   <th >S.no</th>
					<th>Flight Id</th>
					<th>Flight name</th>
					<th>DepartingFrom</th>
					<th>Departing To</th>
					<th>DepartureDate</th>
					<th>Arrival_Date</th>
					<th>Economy Class</th>
					<th>PremiumEconomyClass</th>
					<th>Business Class</th>
				    <th>Economy Rate</th>
					<th>Premium Rate</th>
					<th>Business Rate</th> 					
 				    <th>Departure Time</th>
 				    <th>Arrival Time</th>
					
					
			<c:if test="${loggedinuser != null}">
					
						<th scope= "col">Book Ticket </th>
					</c:if>
					
					
				</tr>
			</thead>
</br>			
			<tbody>
			
     <c:forEach items="${Flight_List}" var="plane" varStatus="status">
				
				<tr>
				
 
   		<td>${status.count}</td>		
 
  	<td>${plane.getFlightId()}</td>
 					 <td>${plane.getFlightname()}</td>
 					  					 <td>${plane.getSource()}</td>
 					  					 <td>${plane.getDestination()}</td>
 					  					 <fmt:parseDate value="${plane.getDeparture_Date()}" pattern="yyyy-MM-dd" var="departured" type="date"/>
 					  					 
 					  					 <td><fmt:formatDate value="${departured}" pattern="dd-MM-yyyy"   />    </td>
 					  					  <fmt:parseDate value="${plane.getArrival_Date()}" pattern="yyyy-MM-dd" var="arrivied" type="date"/>
 					  					 
 					  					 <td><fmt:formatDate value="${arrivied}" pattern="dd-MM-yyyy"   />    </td>
 					  					 
 					  					 <td>${plane.getEconomy_class()}</td>
 					  					 <td>${plane.getPremium_Economy_class()}</td>
 					  					 <td>${plane.getBussiness_class()}</td>
 					  					 <td>${plane.getEconomy_rate()}</td>
 					  					 <td>${plane.getPremium_Economy_rate()}</td>
 					  					 <td>${plane.getBussiness_rate()}</td>
 					  					 <td>${plane.getDepartureTime()}</td>
 					  			         <td>${plane.getArrivalTime()}</td>
 					  					 
 
 
 
 
 
 							
            <c:if test="${loggedinuser != null}">
            
            <c:if test="${plane.getEconomy_class()==0 && plane.getPremium_Economy_class()== 0 && plane.getBussiness_class()==0 }">
            
            			    <td> NO TICKETS AVAILABLE </td>
             </c:if>
            

         <c:if test="${plane.getEconomy_class()!=0 && plane.getPremium_Economy_class()!= 0 && plane.getBussiness_class()!=0}">
         
                  <%--    <td><a href="addPassenger.jsp?flightId=${plane.getFlightId()}&source=${plane.getSource()}&destination=${plane.getDestination()}
					&Departure_Date=${plane.getDeparture_Date()}&Economy_class=${plane.getEconomy_class()}&Premium_Economy_class=${plane.getPremium_Economy_class()}
&Bussiness_class=${plane.getBussiness_class()}&Economyrate=${plane.getEconomy_rate()}&Premiumrate=${plane.getPremium_Economy_rate()}
&Business=${plane.getBussiness_rate()}" 
					class="btn btn-primary">BOOK NOW</a></td> --%>
				 <td><a href="Addpassenger?flightId=${plane.getFlightId()}&source=${plane.getSource()}&destination=${plane.getDestination()}
					&Departure_Date=${plane.getDeparture_Date()}&Economy_class=${plane.getEconomy_class()}&Premium_Economy_class=${plane.getPremium_Economy_class()}
&Bussiness_class=${plane.getBussiness_class()}&Economyrate=${plane.getEconomy_rate()}&Premiumrate=${plane.getPremium_Economy_rate()}
&Business=${plane.getBussiness_rate()}" 
					class="btn btn-primary">BOOK NOW</a></td>
					
       
        </c:if>
           
</c:if>


</tr>
</c:forEach>
 </tbody>
</table>	
		
			
		</c:if>
		
</body>
</html>