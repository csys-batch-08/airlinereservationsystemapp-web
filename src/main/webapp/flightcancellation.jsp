<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Flight Cancel</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
</head>
<style>

body {
    background-image: url(image/flight.jpg);
    background-repeat: no-repeat;
    background-size: cover;
}

a:link, a:visited {
  background-color: #f44336;
  color: white;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: red;
}





</style>
<body>

<a href="Sourcedestination"class="btn btn-primary" style="font-style: italic;"> Back </a> <br > <br />

<form name="cancelflight.form" action="FlightCancellation" method="post"  >
			
			<br /> <input type="number" name="seatno" id="seatno"  value= "${param.seatno}" readonly
				 required autofocus
				style="position: relative; left: 40px; height: 30px; top: -2px; width: 230px" />
				
				<input type="number" name="Flightid" id="Flightid" value= "${param.Flightid}" readonly
				 required autofocus
				style="position: relative; left: -196px; height: 30px; top: 212px; width: 230px" /><br><br>
				
				<input type="date" name="DepartureDate" id="DepartureDate" value= "${param.Departuredate}" readonly
				 required autofocus
				style="position: relative; left: 40px; height: 30px; top: -2px; width: 230px" /><br><br>
				
								<input type="text" name="Class" id="Class" value= "${param.Class}" readonly
				 required autofocus
				style="position: relative; left: 40px; height: 30px; top: -2px; width: 230px" /><br><br>
				
					<input type="text" name="amount" id="amount" value= "${param.Amount}" readonly
				 required autofocus
				style="position: relative; left: 40px; height: 30px; top: -2px; width: 230px" /><br><br>
				
				
				
				
				
				<button type="Submit"  required class="btn btn-warning"
					style="position: relative; left: 40px; height: 30px; top: 110px; width: 230px">
				Cancel	</button>
				
  </form>
 
</body>
</html>