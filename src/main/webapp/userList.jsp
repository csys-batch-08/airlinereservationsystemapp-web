<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.airlinereservationsystemapp.Models.Flight"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>USER LIST</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

	
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
	<a href="flightSearch.jsp" class="btn btn-danger"> Back </a>
	<br>
	<br />


	<table border="2" class="table" id="table_id">
		<h1 align="center">
			<strong>Registered User List</strong>
		</h1>
		<thead>
			<tr class="table-primary">
				<th>S.no</th>
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
			<c:forEach items="${Flight}" var="reg" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${reg.getName()}</td>
					<td class="table-warning">${reg.getEmailid()}</td>
					<td>${reg.getUsername()}</td>
					<td>${reg.getPassword()}</td>
					<td>${reg.getGender()}</td>
					<td>${reg.getPhonenumber()}</td>
					<fmt:parseDate value="${reg.getRegisterDate()}"
					pattern="yyyy-MM-dd" var="registered" type="date" />
					<td class="table-danger"><fmt:formatDate value="${registered}"
                    pattern="dd-MM-yyyy" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<script>

$(document).ready(function() {
	$('#table_id').DataTable();
});


</script>
</body>
</html>