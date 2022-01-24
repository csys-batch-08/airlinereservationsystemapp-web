<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Available Tickets</title>
</head>
<body>
	<input type="text"
				name="flightId" id="flightId" value="<%=request.getParameter("flightId")%>"
				readonly /> <br /> <br /> 
				
				<input type="text"
				name="Coachname" id="Coach" value="<%=request.getParameter("coach")%>"
				readonly /> <br /> <br /> 
</body>
</html>