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

String phone = request.getParameter("phoneno");
System.out.println("phone"+phone);
long mobile   = Long.parseLong(phone);
System.out.println("mobile"+mobile);


try
{  
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
PreparedStatement ps=con.prepareStatement("select * from register where Phone_number=? ");  
ps.setLong(1,mobile); 
System.out.println("jfgfdh");
System.out.println("mobile ");


ResultSet rs=ps.executeQuery();  
if(rs.next())
{
	PrintWriter Write = response.getWriter();
   Write.println("Invalid Mobile "+mobile);
   System.out.println("3");
   System.out.println("4");

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