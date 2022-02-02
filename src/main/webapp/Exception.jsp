<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%> 
    <%@page import="java.io.PrintWriter"%>

     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String email =request.getParameter("email"); 
try
{  
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
PreparedStatement ps=con.prepareStatement("select * from register where Email_id=? ");  
ps.setString(1,email);  
ResultSet rs=ps.executeQuery();  
if(rs.next())
{
	System.out.println(email);
	PrintWriter Write = response.getWriter();
   Write.println("Email id Already Registered");
	System.out.println("fhfh"+email);

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