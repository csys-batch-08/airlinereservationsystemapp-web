<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.sql.*"%> 
    <%@page import="java.io.PrintWriter"%>
        <%@page import="java.util.*"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

String uname  =request.getParameter("uname");
String password  = request.getParameter("Password");
System.out.println("Passeord : " +password);


 
try
{  
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
PreparedStatement ps=con.prepareStatement("select * from register where User_name=? and Password = ? ");  
ps.setString(1,uname); 
ps.setString(2,password);
System.out.println("1");
System.out.println("2");


ResultSet rs=ps.executeQuery();  
if(rs.next())
{
	PrintWriter Write = response.getWriter();
   Write.println("Welcome"+"  "+uname);
   System.out.println("3");
   System.out.println("4");

}
else
{
	PrintWriter Write = response.getWriter();
	   Write.println("Invalid Credientals");

	
}
}
catch(Exception e)
{
	PrintWriter Write = response.getWriter();
	   Write.println("Please LOgin and Come ");
	   System.out.println(e);
	   System.out.println("7");
	   System.out.println("8");

	e.printStackTrace();  
}
 

%>

</body>
</html>