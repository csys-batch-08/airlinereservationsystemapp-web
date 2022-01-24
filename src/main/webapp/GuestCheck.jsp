<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.sql.*"%> 
    <%@page import="java.io.PrintWriter"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exception</title>
</head>
<body>
<%
String mobile =request.getParameter("phone"); 
long phone = Long.parseLong(mobile);
String email = request.getParameter("mail");
System.out.println(email);
System.out.println(phone);

try
{  
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
	if(phone!=0)
	{
PreparedStatement ps=con.prepareStatement("select * from register where  Phone_number = ?");  
ps.setLong(1,phone);
ResultSet rs=ps.executeQuery();  
if(rs.next())
{
	System.out.println(email);
	PrintWriter Write = response.getWriter();
   Write.println("Phone Number Already Registered");
	System.out.println("fhfh"+email);

}  
	
else
{
	PreparedStatement stmt=con.prepareStatement("select * from Guestvalid where  Phone_number = ? and Email_id = ?");  
	stmt.setLong(1,phone);
	stmt.setString(2,email);
	ResultSet rs2=stmt.executeQuery();  
	if(rs2.next())
	{
		System.out.println("Login errorrororororororo errorr r "+email);

	}  

}
	}

	

}
catch(Exception e)
{
	e.printStackTrace(); 
	System.out.println("khhgfhfjgfhffhf"+e);

}
 

%>
</body>
</html>