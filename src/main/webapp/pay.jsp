<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.airlinereservationsystemapp.Models.Source"%>
<%@page import="Services.FlightService"%>
    <%@page import="java.util.List.*"%>

            <%@page import="java.util.ArrayList"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment </title>
</head>
<%
String loggedInAsUser = (String) session.getAttribute("LOGGED_IN_USER");
String role = (String)session.getAttribute("ROLE");
 int flightid=  (int)session.getAttribute("Flightid");
int ticketno	=  (int)session.getAttribute("Ticketno");
String amount=  (String)request.getAttribute("Amount");


ArrayList<Integer> seatnumeric = (ArrayList<Integer>)session.getAttribute("Seatfield");

String seatvaluefield =  seatnumeric.toString();

System.out.println("seatvaluefield     :"+seatvaluefield);


String str = seatvaluefield.replaceAll("\\[", "").replaceAll("\\]", "");

str=str.replaceAll("\\s", "");
System.out.println(str); 
 %>





<body>

        <main class="container-fluid">
		  <h3 align="center">Payment Details </h3>
		<div align="center">
		
		
		
				
				
					<div class="Files" id="fun">
					
				<form action="Payment" method="Get">
					
				
				
				
				
				    <label for="flightid" ><b>Flight Id</b></label>
    <input type="text" id="flightid" name="flightid" value ="<%=flightid%>"  readonly>
<br></br>
    <label for="ticketno"><b>Ticket No</b></label>
    <input type="text"  name="ticketno" value="<%=ticketno%>" readonly>
<br></br>
    <label for="amount"><b>Amount</b></label>
    <input type="text"  name="Amount" value="<%=amount%>" readonly>
    <br></br>
    
        <label for="Seatno"><b>SEATNO</b></label>
    <input type="text"  name="seatno" value="<%=str%>" readonly>
    <br></br>
    
    
		<%
			if (loggedInAsUser.equalsIgnoreCase("Guest")) {
			%>
				      <label for="wallet""><b>Mode *</b></label>
    
    <input type="radio"  name="yesCheck" 
				value="Creditcard" required> 
				<label for="card" >Credit Card</label> 
				
				<input type="radio"  name="yesCheck" value="Debitcard" required > 
				<label for="card" >Debitcard</label> 
				    <br>
				    <br>
				         		
				        			<button type="Submit"  required 
					>
				SUBMIT	</button>
				         		
				
				<% }
			else
			{
				%>
				      <label for="wallet"><b>Mode *</b></label>
    
    <input type="radio"  name="yesCheck" value="Creditcard" required				 > 
				<label for="card" >Credit Card</label> 
				
				<input type="radio"  name="yesCheck"  value="Debitcard"  required > 
				<label for="card" >Debitcard</label> 
				
                    				<input type="radio"  
				name="yesCheck" value="Wallet"  required > 
				<label
				for="Wallet" >Wallet</label>
				<br>
				<br>
							<button type="Submit"   
					>
				SUBMIT	</button>
				
													
				
                    
			<% }
			
			%>
			
    		</form>
				
    		</div>
    		
   </main>


</body>
</html>