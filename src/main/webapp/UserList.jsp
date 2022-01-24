<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.airlinereservationsystemapp.Models.Flight"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FLIGHT LIST</title>
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
  background-color: blue;
  color: white;
}




</style>
<body>

<a href="FlightSearch.jsp"class="btn btn-danger"> Back </a> <br > <br />

<%  
		List<Flight> regobject = (List<Flight>)request.getAttribute("Flight");
 
		%>
	
   		<table border="2" class="table">
			<h1 align="center"><b>Registered User  List</b></h1>
			<thead>
				<tr class="table-primary">
				   <th >S.no</th>
					<th>Registered Name</th>
					<th>Email_id</th>
					<th>User_name</th>
					<th>Password</th>
					<th>Gender</th>
					<th>Phone Number</th>
					<th>Registered_Date</th>
					</tr>
			</thead>
			<br>
			<br>
			<tbody>
				<%
					int i = 0;
					for (Flight register : regobject) {
						i++;
				%>
				<tr>
				
					
					<td><%=i%></td>
					<td><%=register.getName()%></td>
					<td class="table-warning"><%=register.getEmailid()%></td>
					<td><%=register.getUsername()%></td>
					<td><%=register.getPassword()%></td>
					
					<td> <%=register.getGender()%></td>
					<td> <%=register.getPhonenumber()%></td>
					<td class="table-danger"> <%=register.getRegisterDate()%></td>
					
			</tr>
					
					<%
				}
				%>
					</tbody>
		           </table>
			

</body>
</html>