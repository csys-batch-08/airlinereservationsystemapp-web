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

String username =request.getParameter("username");  
try
{  
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
PreparedStatement ps=con.prepareStatement("select * from register where User_name=? ");  
ps.setString(1,username);  
ResultSet rs=ps.executeQuery();  
if(rs.next())
{
	System.out.println("nvfhfh");
	PrintWriter Write = response.getWriter();
   Write.println("User Name already Registered");
	System.out.println("catch");

}  

}
catch(Exception e)
{
	e.printStackTrace(); 
	System.out.println(e);


}
 


%>
</body>
</html>