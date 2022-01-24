<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.io.PrintWriter"%>
            <%@ page import="java.sql.*"%> 
        
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String email =request.getParameter("email");  

if (email.matches("[a-z0-9]+[@][a-z]+[.][a-z]+")&&email!="")
{
    
}
else
{
	PrintWriter Write = response.getWriter();
	   Write.println("mention Email id in correct format");
}


%>
</body>
</html>