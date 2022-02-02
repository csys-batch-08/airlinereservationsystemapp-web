<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DELETE FLIGHT</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<style>
body
{
  background-image: url(image/1264514.jpg);
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

 
  		<form name="addflight.form" action="DeleteFlight" method="post"  >
			
			<br /> 
									<input type="number" class="form-control " name="Flight_id"  value="${param.flightId}" readonly
style="position: relative;width: 228px;left: 58px; top: -5px;height: 41px; ">
				
				<br>
				
				<button type="Submit"  class="btn btn-danger" 
					style="position: relative; left:62px; height: 41px; top: 38px; width: 172px">
				DELETE	</button>
				
</form>
</body>
</html>