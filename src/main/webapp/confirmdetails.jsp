<%@page import="com.airlinereservationsystemapp.Models.Passenger_details"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Confirm Details</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

<style>
body {
	background-image: url(image/flih.jpg);
	background-repeat: no-repeat;
	background-size: contain;
	overflow-y:hidden

}



form {
  border: 3px solid #f1f1f1;
  width:35%;
  height : 50%;
 align:"center";
}

/* input[type=text], input[type=password],input[type=email],input[type=radio],input[type=tel] {
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

 */

</style>

 
 <c:set  var="passengers" value="${Passenger_Deatils}" />
		
		<main class="container-fluid">
		<h3 align="center">Confirm Details</h3>
		<div align="center" style="position: relative;height: 1200px;margin: 0px;" >
		
		   		<form action="AddPassenger" method="post"  >
		
 
            <label for="username" style="font-family: serif;font-size: 18px; position:relative;width: 250px;top:33px;left: -117px;height: 20px;"
            >PassengerName </label> 
				<%-- <input type="text" name="username" id="username" style="position: relative; left: 29px; height: 25px; top: 5px; width: 210px"
				 value="${passengers.getPassenger_name()}"  readonly />  --%>
				 
				 <input type="text" class="form-control" name = "username"   id="username" value="${passengers.getPassenger_name()}" readonly
				    style="position: relative;width: 214px;top:7px;left: 73px;height: 32px;"  >
				<br/>
				<br>
				<br>
            
				
				
				 <label for="coach" style="font-family: serif;font-size: 18px; position:relative;width: 250px;top:-29px;left: -117px;height: 20px; "
				 >CoachDetails </label> 
            
<%-- 			<input type="text"
				name="coach" id="v"  style="position: relative; left: 38px; height: 25px; top: -6px; width: 210px"
			  value="${passengers.getClass_details()}"  
				readonly /> --%>
				 <input type="text" class="form-control" name = "coach"   id="coach" value="${passengers.getClass_details()}" readonly
				    style="position: relative;width: 214px;top:-60px;left: 73px;height: 32px;"  >
				 <br /> <br /> 
				
				
				 <label for="MobileNumber" style="font-family: serif;font-size: 18px; position:relative;width: 250px;top:-74px;left: -117px;height: 20px; "
				 >MobileNumber </label> 
            
<%-- 			<input type="number"
				name="MobileNumber" id="MobileNumber" style="position: relative; left: 32px; height: 25px; top: -6px; width: 210px"
				  value="${passengers.getMobile_number()}" 
				readonly />  --%>
				 <input type="text" class="form-control" name = "MobileNumber"   id="MobileNumber" value="${passengers.getMobile_number()}" readonly
				    style="position: relative;width: 214px;top:-99px;left: 73px;height: 32px;"  >
				
				<br /> <br /> 
				
				
				 <label for="source" style="font-family: serif;font-size: 18px; position:relative;width: 250px;top:-110px;left: -117px;height: 20px; "
				 >Source </label> 
            
<%-- 			<input type="text"
				name="source" id="flightId"style="position: relative; left: 61px; height: 25px; top: -6px; width: 210px"
				  value="${passengers.getSource()}" 
				readonly /> --%>
				
					 <input type="text" class="form-control" name = "source"   id="source" value="${passengers.getSource()}" readonly
				    style="position: relative;width: 214px;top:-138px;left: 73px;height: 32px;"  >
				
				 <br /> <br /> 
				
				
				 <label for="destination" style="font-family: serif;font-size: 18px; position:relative;width: 250px;top:-146px;left: -117px;height: 20px; "
				 >Destination </label> 
            
<%-- 			<input type="text"
				name="destination" id="flightId"style="position: relative; left: 47px; height: 25px; top: -6px; width: 210px"
				  value="${passengers.getDestination()}"
				readonly />  --%>
					 <input type="text" class="form-control" name = "destination"   id="destination" value="${passengers.getDestination()}" readonly
				    style="position: relative;width: 214px;top:-177px;left: 73px;height: 32px;"  >
				
				<br /> <br /> 
				
				 <label for="bookingDate" style="font-family: serif;font-size: 18px; position:relative;width: 250px;top:-189px;left: -117px;height: 20px; "
				 >Departed Date </label> 
            
<%-- 			<input type="text"
				name="bookingDate" id="flightId"style="position: relative; left: 44px; height: 25px; top: -6px; width: 210px"
				    value="${passengers.getArrival_date()}"
				readonly />  --%>
					 <input type="text" class="form-control" name = "bookingDate"   id="bookingDate" value="${passengers.getArrival_date()}" readonly
				    style="position: relative;width: 214px;top:-216px;left: 73px;height: 32px;"  >
				
				<br /> <br /> 
				
				 <label for="numberOfPassengers" style="font-family: serif;font-size: 18px; position:relative;width: 250px;top:-228px;left: -117px;height: 20px; "
				 >NoOfPassengers </label> 
            
			<%-- <input type="text"
				name="numberOfPassengers" id="flightId"style="position: relative; left: 34px; height: 25px; top: -6px; width: 210px"
				  value="${passengers.getNoOfPassengers()}"
				readonly />  --%>
				 <input type="text" class="form-control" name = "numberOfPassengers"   id="numberOfPassengers" value="${passengers.getNoOfPassengers()}" readonly
				    style="position: relative;width: 214px;top:-255px;left: 73px;height: 32px;"  >
	
				
				<br /> <br /> 
				
				
				            <label for="flightId" style="font-family: serif;font-size: 18px; position:relative;width: 250px;top:-264px;left: -117px;height: 20px; "
				            >Flight Id</label>
<%-- 			<input type="text"
				name="flightId" id="flightId" style="position: relative; left: 55px; height: 25px; top: -6px; width: 210px"
				value="${passengers.getFlight_id()}"
				readonly />  --%>
				
				 <input type="text" class="form-control" name = "flightId"   id="flightId" value="${passengers.getFlight_id()}" readonly
				    style="position: relative;width: 214px;top:-294px;left: 73px;height: 32px;"  >
				
				<br /> <br /> 
				
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
				
								  
								  <label class="visually-hidden" for="button">Name</label>
								  <button type="submit"  class="btn btn-outline-primary" id="button"
								  style="position:relative ;top: -397px;left: -6px; width: 99px;height: 35px; " >Submit</button>
				
				
				
				
				
				
				
				
				
		</form>		
				</div>
				</main>
				
				
</body>
</html>