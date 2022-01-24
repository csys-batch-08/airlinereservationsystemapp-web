<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>  
        <%@page import="java.io.PrintWriter"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EXCEPTION FILE</title>
</head>
<body>
<%
String source = request.getParameter("source");
String destination  =request.getParameter("destination");


System.out.println("Source"+source);
System.out.println("Destination"+destination);


try
{  
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
PreparedStatement ps=con.prepareStatement("select * from flight_details where SOURCE = ? and DESTINATION = ?");  
ps.setString(1,source); 
ps.setString(2,destination);
System.out.println("Set Sourecce "+source);
System.out.println("Set Destination "+destination);



ResultSet rs=ps.executeQuery();  
if(rs.next())
{

}  
else
{
	System.out.println(source);
	PrintWriter Write = response.getWriter();
   Write.println("The Source and Destination not found");
	System.out.println("fhfh"+source);

}
}
catch(Exception e)
{e.printStackTrace();
System.out.println("Source");
System.out.println("Exception  "+e);


}  
 





%>
</body>
</html>