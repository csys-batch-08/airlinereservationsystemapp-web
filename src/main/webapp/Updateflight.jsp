
<%@page import="com.airlinereservationsystemapp.Models.Flight_list"%>
<%@page import="com.airlinereservationsystemapp.DaoImpl.FlightSearchDao"%>
<%@page import="Services.FlightService"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE FLIGHT DETAILS</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<style>
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
<a href="FlightSearch.jsp"class="btn btn-primary" style="font-style: italic"> Back </a> <br > <br />


    <h1 style="text-align: center;">
				<b>UPDATE  FLIGHT DETAILS</b></h1>
		<form name="addflight" action="UpdateFlight" method="post"  >
		
						    <input type="number"  name="Flightid" value="<%=request.getParameter("flightId")%>" readonly   placeholder="Flight_id"  
				style="position: relative; left:38px; height: 31px; top: -14px;width: 250px" />
		<br>
			
			<%
			
			String flightId = request.getParameter("flightId");
			
			int Flight_Id = Integer.parseInt(flightId);
			
			FlightSearchDao flightDao = new FlightSearchDao();
			Flight_list flight = flightDao.getRecordById(Flight_Id);
			int businessClassRate = flight.getBussiness_class();
			int economyClassRate = flight.getPremium_Economy_class();
			int firstClassRate = flight.getEconomy_class();
			String source = flight.getSource();
			String destination = flight.getDestination();
			String flightname = flight.getFlight_name();
			Date Arrival_date  = flight.getArrival_Time();
			Date Departure_date  = flight.getDeparture_time();
			

			
			%>
			
			
			<br /> <input type="text" name="Flightname" value="<%=flightname%>" 
				placeholder="FLIGHT_NAME"  autofocus
				style="position: relative; left: 40px; height: 30px; top: -2px; width: 230px" />
				
			<br> <input type="text" id="text" name="source" value="<%=source%>"  
				placeholder="Enter Source"  
				style="position: relative; left: 41px; height: 33px; top: 17px; width: 228px" />
			
			
			<br> <input type="text" name="Destination" value="<%=destination%>"  
			  placeholder="Enter Destination " 
				autofocus  
				style="position: relative; left: 40px; height: 30px; top: 39px; width: 230px" />
				<br>
				
				<input type="number" name="Economyclass"placeholder="ECONOMY_CLASS" value="<%=economyClassRate%>" 
				min = "0" pattern="[0-9]"  
				style="position: relative; left: 40px; height: 30px; top: 62px; width: 230px" />
				
			<br> <input type="number" name="PremiumEconomyclass" value="<%=businessClassRate%>"  
				placeholder="PREMIUM_ECONOMY_CLASS " 				min = "0" pattern="[0-9]"  
				style="position: relative; left: 40px; height: 30px; top: 77px; width: 230px" /><br>
				
			<input type="number"  name="Bussinessclass" placeholder="Bussinessclass" value="<%=firstClassRate%>"
							min = "0" pattern="[0-9]"    
				value="Male" style="position: relative; left: 39px;height: 31px; top: 99px;width: 229px">
				<br> 
				
							<input type="date"  name="ArrivalDate" id="arrivaldate" placeholder="Bussinessclass" value="<%=Arrival_date%>"  
				value="Male" style="position: relative; left: 39px;height: 31px; top: 124px;width: 229px">
				<br> 
				
							<input type="date"  name="DepartureDate" id="DepartureDate" placeholder="Bussinessclass" value="<%=Departure_date%>"  
				value="Male" style="position: relative; left: 39px;height: 31px; top: 156px;width: 229px">
				<br> 
				
			<input type="text"  name="Status" placeholder="status" value="Yet To Arrived"  
				value="Male" style="position: relative; left: 296px;height: 31px; top: -6px;width: 229px">
				<br> 
				
				
				
				
			<br> 
			
			
			
			
               



			<div style="text-align: center">
				<button type="Submit"  class="btn btn-primary" 
					style="position: relative; left: 40px; height: 36px; top: 99px; width: 230px">
				SUBMIT	</button>
			</div>
			
		</form>
		
    <script>
    
    
    
    
    today();
    function today(){
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();
        var yyyy1= today.getFullYear()+10;
    maxdate =yyyy1 + '-' + mm + '-'+ dd  ;
    mindate =yyyy + '-' + mm + '-'+ dd  ;
    document.getElementById("arrivaldate").setAttribute("max",maxdate);
    document.getElementById("arrivaldate").setAttribute("min",mindate);


}
</script>
<script>
today();
function today(){
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = today.getFullYear();
    var yyyy1= today.getFullYear()+10;
maxdate =yyyy1 + '-' + mm + '-'+ dd  ;
mindate =yyyy + '-' + mm + '-'+ dd  ;
document.getElementById("DepartureDate").setAttribute("max",maxdate);
document.getElementById("DepartureDate").setAttribute("min",mindate);


}

</script>

</body>
</html>

