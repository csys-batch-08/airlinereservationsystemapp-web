<%@page import="com.airlinereservationsystemapp.Models.Passenger_details"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<style>
body {
     background-image : url(image/flih.jpg);
	background-repeat: no-repeat;
	background-size: cover;
}
form {
  border: 3px solid #f1f1f1;
  width:30%;
  align:"center";
}

input[type=text], input[type=password],input[type=email],input[type=radio],input[type=tel] {
  width: 43%;
  padding: 12px 20px;
  margin: 5px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

input[type=radio] {
  width: 18%;
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
  width: 62%;
}

button:hover {
  opacity: 0.8;
}

.container {
  padding: 16px;
}

button:hover, button:active {
  background-color:lime;
}



</style>

 
 <c:set  var="passengers" value="${Passenger_Deatils}" />
		
		<main class="container-fluid">
		<h3 align="center">Confirm Details</h3>
		<div align="center">
		
		   		<form action="AddPassenger" method="post">
		
 
            <label for="username" style="position: relative; left: 20px; height: 25px; top: 4px; width: 230px"
            >PassengerName</label> 
				<input type="text" name="username" id="username" style="position: relative; left: 29px; height: 25px; top: 5px; width: 210px"
				 value="${passengers.getPassenger_name()}"  readonly /> 
				<br/>
				<br>
				<br>
            
				
				
				 <label for="coach"style="position: relative; left: 23px; height: 25px; top: -6px; width: 230px"
				 >CoachDetails</label> 
            
			<input type="text"
				name="coach" id="flightId"  style="position: relative; left: 38px; height: 25px; top: -6px; width: 210px"
			  value="${passengers.getClass_details()}"  
				readonly /> <br /> <br /> 
				
				
				 <label for="MobileNumber"style="position: relative; left: 23px; height: 25px; top: -6px; width: 230px"
				 >MobileNumber</label> 
            
			<input type="number"
				name="MobileNumber" id="MobileNumber" style="position: relative; left: 32px; height: 25px; top: -6px; width: 210px"
				  value="${passengers.getMobile_number()}" 
				readonly /> <br /> <br /> 
				
				
				 <label for="source" style="position: relative; left: 22px; height: 25px; top: -6px; width: 230px"
				 >Source</label> 
            
			<input type="text"
				name="source" id="flightId"style="position: relative; left: 61px; height: 25px; top: -6px; width: 210px"
				  value="${passengers.getSource()}" 
				readonly /> <br /> <br /> 
				
				
				 <label for="destination" style="position: relative; left: 29px; height: 25px; top: -6px; width: 230px"
				 >Destination</label> 
            
			<input type="text"
				name="destination" id="flightId"style="position: relative; left: 47px; height: 25px; top: -6px; width: 210px"
				  value="${passengers.getDestination()}"
				readonly /> <br /> <br /> 
				
				 <label for="bookingDate" style="position: relative; left: 38px; height: 25px; top: -6px; width: 230px"
				 >BookingDate</label> 
            
			<input type="text"
				name="bookingDate" id="flightId"style="position: relative; left: 44px; height: 25px; top: -6px; width: 210px"
				    value="${passengers.getArrival_date()}"
				readonly /> <br /> <br /> 
				
				 <label for="numberOfPassengers" style="position: relative; left: 25px; height: 25px; top: -6px; width: 230px"
				 >NoOfPassengers</label> 
            
			<input type="text"
				name="numberOfPassengers" id="flightId"style="position: relative; left: 34px; height: 25px; top: -6px; width: 210px"
				  value="${passengers.getNoOfPassengers()}"
				readonly /> <br /> <br /> 
				
				
				            <label for="flightId" style="position: relative; left: 26px; height: 25px; top: -6px; width: 230px"
				            >Flight Id</label>
			<input type="text"
				name="flightId" id="flightId" style="position: relative; left: 55px; height: 25px; top: -6px; width: 210px"
				value="${passengers.getFlight_id()}"
				readonly /> <br /> <br /> 
				
				<input type="hidden"
				name="Economyclass" id="Economyclass"  value="${passengers.getEconomyseat()}"
				readonly /> 
			
			
				
				<input type="hidden"
				name="PremiumEconomyclass" id="PremiumEconomyclass" 
				value="${passengers.getPremiumeconomyseats()}"
				readonly  /> 
				
								
				
				<input type="hidden"
				name="Bussinessclass" id="Bussinessclass"  value="${passengers.getBusinessseats()}"
				readonly />  
				
				<input type="hidden"
				name="ticketno" id="ticketno"   value="${passengers.getTicketNo()}"
				readonly /> 
				
			<input type="hidden"
				name="amount" id="amount"  value="${passengers.getAmount()}"
				readonly /> <br /> <br /> 
				
							<input type="hidden"
				name="seatno" id="amount"  value="${passengers.getSeatno()}"
				readonly /> <br /> 
				
								  <button type="submit" >Submit</button>
				
				
				
				
				
				
				
				
				
		</form>		
				</div>
				</main>
				
				
</body>
</html>