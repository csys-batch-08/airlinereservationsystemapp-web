<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Flight</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
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
  background-color: red;
}



</style>
<body>

<a href="FlightSearch.jsp"class="btn btn-primary" style="font-style: italic;"> Back </a> <br > <br />

 
  		<form name="addflight.form" action="DeleteFlight" method="post"  >
			
			<br /> <input type="number" name="Flight_id" value= "<%=request.getParameter("flightId")%>" readonly
				placeholder="FLIGHT_ID" required autofocus
				style="position: relative; left: 40px; height: 30px; top: -2px; width: 230px" />
				
				
				<button type="Submit"  class="btn btn-danger" 
					style="position: relative; left: -194px; height: 35px; top: 68px; width: 230px">
				DELETE	</button>
				
  
 
 
</body>
</html>