<%@page import="com.airlinereservationsystemapp.Models.Flight_list"%>
<%@page import="com.airlinereservationsystemapp.DaoImpl.FlightSearchDao"%>
<%@page import="Services.FlightService"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>FlightApp - Add Passengers details</title>

</head>
<body>
   
 <style>
body {
	background-image: url(https://images.unsplash.com/photo-1604484384465-fbc304d466ec?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzJ8fGpldHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60);
	background-repeat: no-repeat;
	background-size: cover;
}
form {
  border: 3px solid #f1f1f1;
  width:41%;
  align:"center";
}
/* form {
  border: 3px solid #f1f1f1;
  width:41%;
  align:"center";
} */
/* input[type=text], input[type=password],input[type=date],input[type=number],input[type=tel] {
  width: 40%;
  padding: 7px 20px;
  left:80px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
  position : relative;
}
input[type=radio] {
  width: 18%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
 */
 /* button {
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
.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: red;
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
  lable{
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
  background-color:red;
}
  */

</style>
 
 <c:set var="loggedinadmin"     value="${LOGGED_IN_ADMIN}"/> 

<c:set var="loggedinuser"    value="${LOGGED_IN_USER}"/>  

    
   	<main class="container-fluid">
		<div align="center">
		
<!-- 		<a href="flightSearch.jsp"class="btn btn-primary" style="font-style: italic"> Back </a> <br > <br />
 -->		
		       <a href="Sourcedestination"  class="btn btn-warning"   style="font-style: italic"> Back </a> <br > <br />
		
		
		
		
   		<form action="ConfirmDetails" method="post">
			<h2>Booking Details</h2>
			
			<label for="flightId" style="font-family: serif;font-size: 18px; position:relative;width: 250px;top:6px;left: -113px;height: 20px; " >Flight Id:</label> 
<%-- 			<input type="text"
				name="flightId" id="flightId"style="position: relative; left: 65px; height: 23px; top: 6px; width: 229px"
				value="${param.flightId}"  
				readonly /> <br /> <br />  --%>
				    <input type="text" class="form-control" name = "flightId"   id="flightId" value="${param.flightId}" readonly
				    style="position: relative;width: 238px;top:-26px;left: 99px;height: 32px;"  >
				
				<label for="source"style="font-family: serif;font-size: 18px; position:relative;width: 250px;top:3px;left: -111px;height: 20px; ">Source:</label> 
<%-- 			<input type="text"
				name="source" id="source" style="position: relative; left: 70px; height: 24px; top: 1px; width: 230px"
				value="${param.source}"
				readonly /> <br /> <br />  --%>
					<input type="text" class="form-control" name = "source"   id="source" value="${param.source}" readonly
				    style="position: relative;width: 238px;top:-26px;left: 99px;height: 32px;"  >
				
				<label for="destination"style="font-family: serif;font-size: 18px; position:relative;width: 250px;top:3px;left: -120px;height: 20px; ">Destination:</label> 
<%-- 			<input type="text"
				name="destination" id="destination"style="position: relative; left: 54px; height: 24px; top: 3px; width: 230px"
				 value="${param.destination}"
				readonly /> <br /> <br /> --%> 
				<input type="text" class="form-control" name = "destination"   id="destination" value="${param.destination}" readonly
				  style="position: relative;width: 238px;top:-26px;left: 99px;height: 32px;"  >
				
				<label for="departuredate" style="font-family: serif;font-size: 18px; position:relative;width: 250px;top:4px;left: -113px;height: 20px; ">Departure Date:</label> 
<%-- 			<input type="text"
				name="departuredate" id="destination" style="position: relative; left: 41px; height: 24px; top: 2px; width: 230px"
				 value="${param.Departure_Date}"
				readonly /> <br /> <br />  --%>
				
				<input type="text" class="form-control" name = "departuredate"   id="departuredate" value="${param.Departure_Date}" readonly
				  style="position: relative;width: 238px;top:-26px;left: 99px;height: 32px;"  >
				
				
				
				
				
			
			<input type="hidden"
				name="Economy_class" id="Economy" 
				readonly /> 
			
			
				
				<input type="hidden"
				name="PremiumEconomyclass" id="PremiumEconomy" 
				readonly  /> 
				
								
				
				<input type="hidden"
				name="Bussinessclass" id="Bussiness" 
				readonly /> 
				
				
			<input type="hidden"
				name="Economyclass" id="Economyclass" 
				value="${param.Economy_class}"
				readonly /> 
			
			
				
				<input type="hidden"
				name="PremiumEconomyclass" id="PremiumEconomyclass" 
				 value="${param.Premium_Economy_class}"
				readonly  />  
				
								
				
				<input type="hidden"
				name="Bussinessclass" id="Bussinessclass" 
			 value="${param.Bussiness_class }"
				readonly />  
				
				
				<label for="username" style="font-family: serif;font-size: 18px; position:relative;width: 250px;top:5px;left: -113px;height: 20px; ">Passenger
				Name:</label> 
<!-- 				<input type="text" name="username" id="username" style="position: relative; left: 35px; height: 24px; top: 1px; width: 230px"
				required autofocus pattern = "[A-Z  a-z]{3,20}"  /> <br />
				 <br /> <br />  -->
				 <input type="text" class="form-control" name = "username"   id="username" required autofocus pattern = "[A-Z  a-z]{3,20}" placeholder="Enter PassengerName"
				  style="position: relative;width: 238px;top:-26px;left: 99px;height: 32px;"  >
				 
				<label for="MobileNumber" style="font-family: serif;font-size: 18px; position:relative;width: 250px;top:6px;left: -113px;height: 20px; ">Mobile No:</label> 
				<!-- <input
				type="tel" name="MobileNumber" required pattern = "[6-9][0-9]{9}" placeholder="Enter mobile number"style="position: relative; left: 52px; height: 25px; top: -6px; width: 230px"
				 required autofocus /> <br /> <br /> -->
				  <input type="tel" class="form-control" name = "MobileNumber"   id="MobileNumber" required pattern = "[6-9][0-9]{9}" placeholder="Enter mobileno"
				  style="position: relative;width: 238px;top:-26px;left: 99px;height: 32px;"  >
				 
				 				<label for="coach" style="position: relative; left: -4px; height: 25px; top: 0px; width: 230px"
				 				
				 				>Coach:</label> 
				  
				  <c:set var="ecoseats" value="${param.Economy_class}"/>
				    
				      <fmt:parseNumber var="economy" type="number" integerOnly="true"  value="${ecoseats}" />  
				  			
				  				  <c:set var="preseats" value="${param.Premium_Economy_class}"/>
				    
				      <fmt:parseNumber var="premium" type="number" integerOnly="true"  value="${preseats}" />  
				  
				  	  <c:set var="busseats" value="${param.Bussiness_class}"/>
				    
				      <fmt:parseNumber var="bussiness" type="number" integerOnly="true"  value="${busseats}" />  
				  
				<c:choose>  
				  
				   <c:when test ="${economy==0}">  
				  				
				    	<select name="coach" id="coach" style="position: relative; left: 66px; height: 26px; top: -6px; width: 230px">
                
                <option value="Bussiness">Business Class</option>
                <option value="premium">Premium Economy</option>
              </select>
				</c:when>       
 <c:when test ="${premium==0}">
					   	<select name="coach" id="coach" style="position: relative; left: 66px; height: 26px; top: -6px; width: 230px">
                
                <option value="Bussiness">Business Class</option>
                <option value="Economy">economy</option>
              </select>
</c:when>

 <c:when test ="${bussiness==0}">
 
 	<select name="coach" id="coach" style="position: relative; left: 66px; height: 26px; top: -6px; width: 230px">
           <option value="Economy">economy</option>
           <option value="premium">Premium Economy</option>
           </select>
</c:when>

    <c:otherwise>  
			   <select class="form-select"  name="coach" id="coach" style="position:relative; width: 238px;top:-3px;left: -17px;height: 32px;">
                
                <option value="Bussiness">Business Class</option>
                <option value="Economy">economy</option>
                <option value="premium">Premium Economy</option>
              </select>
          </c:otherwise>    
              </c:choose>
		 <br>
		 <c:choose>
		 
		 
		     <c:when test="${fn:containsIgnoreCase(loggedinuser,'Guest')}"> 
		      
		 			<label for="numberOfPassengers" style="font-family: serif;font-size: 18px; position:relative;width: 250px;top:11px;left: -140px;height: 20px; ">Number of passengers:</label>
			<!-- <input type="number" id="numberOfPassengers" style="position: relative; left: 14px; height: 24px; top: 3px; width: 230px"
			
				name="numberOfPassengers"  min="1" max="8" pattern="[1-8]"
				placeholder="Enter passengers count" oninput="calculation()" required autofocus /> </br>
				
			<br /> -->
				 <input type="number" class="form-control" name = "numberOfPassengers"   id="numberOfPassengers" min="1" max="8" pattern="[1-8]"
				  placeholder="Enter passengers count" oninput="calculation()"  required
				  style="position: relative;width: 238px;top:-15px;left: 99px;height: 32px;"  >
			
		 
		 </c:when>
		 <c:otherwise>
			  
			<label for="numberOfPassengers" style="font-family: serif;font-size: 18px; position:relative;width: 250px;top:11px;left: -140px;height: 20px; ">Number of passengers:</label>
			<!-- <input type="number" id="numberOfPassengers" style="position: relative; left: 14px; height: 24px; top: 3px; width: 230px"
			
				name="numberOfPassengers"  min="1" max="8" pattern="[1-8]"
				placeholder="Enter passengers count" oninput="calc()" required autofocus /> </br>
				
			<br /> -->
							 <input type="number" class="form-control" name = "numberOfPassengers"   id="numberOfPassengers" min="1" max="8" pattern="[1-8]"
				  placeholder="Enter passengers count" oninput="calc()"  required
				  style="position: relative;width: 238px;top:-15px;left: 99px;height: 32px;"  >
			
		</c:otherwise>
			 </c:choose>
			
						
		 <c:set var="eco" value="${param.Economyrate}" ></c:set>
		 
		 				      <fmt:parseNumber var="economy" value="${eco}" />  
		 
		 		 <c:set var="pre" value="${param.Premiumrate}" ></c:set>
		 
		 				      <fmt:parseNumber var="premium" value="${pre}" />  
		 
		 		 <c:set var="bus" value="${param.Business}" ></c:set>
		 
		 				      <fmt:parseNumber var="business" value="${bus}" />  
		 
			  
					<label for="firstClassPrice" style="font-family: serif;font-size: 18px; position:relative;width: 250px;top:9px;left: -126px;height: 20px; ">Economy Price :</label>
			
<%-- 			<input type="text" id="firstClassPrice"style="position: relative; left: 41px; height: 25px; top: -1px; width: 230px" onkeyup="validlogin()"
			
			 value="${economy}"  readonly /> <br /> <br />  --%>
			 
			 	<input type="text" class="form-control" name = "firstClassPrice"   id="firstClassPrice" value="${economy}" readonly
				  style="position: relative;width: 238px;top:-19px;left: 99px;height: 32px;"  >
			 
				
					<label for="numberOfPassengers" style="font-family: serif;font-size: 18px; position:relative;width: 250px;top:9px;left: -140px;height: 20px; ">  Premium Economy Price :</label>
<%-- 				<input
				type="text" id="economyClassPrice" style="position: relative; left: 13px; height: 25px; top: 3px; width: 230px"
				
				value= "${premium}"
				readonly /> <br /> <br /> --%>
				
					<input type="text" class="form-control" name = "economyClassPrice"   id="economyClassPrice" value="${premium}" readonly
				  style="position: relative;width: 238px;top:-19px;left: 99px;height: 32px;"  >
				
				 
					<label for="Businessclass" style="font-family: serif;font-size: 18px; position:relative;width: 250px;top:9px;left: -126px;height: 20px; ">Business Class Price:</label>
<%-- 				<input type="text"
				id="businessClassPrice"style="position: relative; left: 27px; height: 25px; top: 0px; width: 230px"
				
				 value="${business}" readonly />
			<br /> <br />  --%>
			
					<input type="text" class="form-control" name = "businessClassPrice"   id="businessClassPrice" value="${business}" readonly
				  style="position: relative;width: 238px;top:-19px;left: 99px;height: 32px;"  >
			
			
			<label for="price" style="font-family: serif;font-size: 18px; position:relative;width: 250px;top:9px;left: -126px;height: 20px; ">Price:</label> 
<!-- 			<input
				type="number" id="price" name="price" style="position: relative; left: 74px; height: 25px; top: -6px; width: 230px"
				 readonly /> <br /> <br />
 -->			
 					<input type="number" class="form-control" name = "price"   id="price"  readonly
				  style="position: relative;width: 238px;top:-19px;left: 99px;height: 32px;"  >
 
 
            <div style="text-align: center">
			 
               	 
			<button type="submit" class="btn btn-primary" style="position: relative; left: 11px; height: 39px; top: -6px; width: 214px"  
			 >ConfirmDetails</button>
			
		</div>
			
		</form>
		</div>
		</main>
   	<script>
	function calc() 
	{
		event.preventDefault();


			
			let coach = document.getElementById("coach").value;
				console.log(coach);
				
				
				
			let numberOfPassengers = document.getElementById("numberOfPassengers").value;
			let economyClassPrice = document.getElementById("economyClassPrice").value;
			let businessClassPrice = document.getElementById("businessClassPrice").value;
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
				seats  = premiumseats-numberOfPassengers;
				document.getElementById("PremiumEconomy").value = seats;
               console.log(seats);
				
				break;
			}
			case "Economy": {
				totalprice = numberOfPassengers * firstClassPrice;
				price = totalprice - (totalprice * 8/ 100)

				document.getElementById("price").value = price;
				
			
					  seats = economyseats - numberOfPassengers ;
					  console.log(seats);
				document.getElementById("Economy").value = seats;




				break;
			}
			case "Bussiness": {
				totalprice = numberOfPassengers * businessClassPrice;
				price = totalprice - (totalprice * 10/ 100)

				document.getElementById("price").value = price;
				seats  = Businesseats-numberOfPassengers;
			document.getElementById("Bussiness").value = seats;

				break;
			}
			}
	}
	
	function calculation() 
	{
	    event.preventDefault();
	    
	    let coach = document.getElementById("coach").value;
	        console.log(coach);
	        
	        
	        
	    let numberOfPassengers = document.getElementById("numberOfPassengers").value;
	    let economyClassPrice = document.getElementById("economyClassPrice").value;
	    let businessClassPrice = document.getElementById("businessClassPrice").value;
	    let firstClassPrice = document.getElementById("firstClassPrice").value;
	    let premiumseats = document.getElementById("PremiumEconomyclass").value;
	    let Businesseats = document.getElementById("Bussinessclass").value;
	    let economyseats = document.getElementById("Economyclass").value;
	    
	    let price = 0;
	    let seats = 0;
	    let pricevalue = 0;
	    let totalprice =0;
	    switch (coach) {
	    case "premium": {
	        totalprice = numberOfPassengers * economyClassPrice;
	        price  = totalprice+(totalprice*5/100) ;

	        console.log(totalprice);
	        console.log(price);




	        document.getElementById("price").value = price;
	        seats  = premiumseats-numberOfPassengers;
	        document.getElementById("PremiumEconomy").value = seats;
	       console.log(seats);
	        
	        break;
	    }
	    case "Economy": {
	    	totalprice = numberOfPassengers * firstClassPrice;
	        price  = totalprice+(totalprice*8/100) ;

	        document.getElementById("price").value = price;

	    
	              seats = economyseats - numberOfPassengers ;
	              console.log(seats);
	             // }
	        document.getElementById("Economy").value = seats;




	        break;
	    }
	    case "Bussiness": 
	    {
	    	totalprice = numberOfPassengers * businessClassPrice;
	        price  = totalprice+(totalprice*10/100) ;

	        document.getElementById("price").value = price;
	        seats  = Businesseats-numberOfPassengers;
	    document.getElementById("Bussiness").value = seats;

	        break;
	    }
	    }

	  }
	  
		 				   
	  
	</script>
</body>
</html>