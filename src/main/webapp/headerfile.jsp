<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
                         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                     <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>HEADER FILE</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<style>
.nav-item{

  font-family: Tahoma, sans-serif;
  font-size: 18px;
 }
.nav-link {
  color: white;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  }
  
  

</style>
<header>

<c:set value="${LOGGED_IN_ADMIN}" var="loggedInAsAdmin"/>
<c:set value="${LOGGED_IN_USER}" var="loggedInAsUser"  />
<c:set value="${LOGGED_IN_USER}" var="loggedguest"  />
<c:set value="${ROLE}" var="role"  />


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand">Airline Reservation System</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active" style="position: relative;left: 30px;font-size: 18px"><a  href="Sourcedestination">Home</a></li>
    </ul>
   
   <ul class="nav navbar-nav navbar-right">
    
    <c:if test="${loggedInAsAdmin == null && loggedInAsUser == null}">
      <li class="nav-item" ><a href="login.jsp"><span class="glyphicon glyphicon-user"></span> Login</a></li>
      <li class="nav-item"><a href="register.jsp"><span class="glyphicon glyphicon-log-in"></span> Register</a></li>
      <li class="nav-item"><a href="guestlogin.jsp"><span class="glyphicon glyphicon-log-in"></span> Guest Login</a></li>
   </c:if>
   <c:if test="${loggedInAsUser == null && loggedInAsAdmin != null}">
   				<li class="nav-item"><a class="nav-link" href="#">Welcome ${loggedInAsAdmin}</a>
				</li>
				<li class="nav-item"><a class="nav-link" class="btn btn-warning" href ="LogoutServlet">Logout</a>
				</li>
	 </c:if>
	 <c:choose>
    <c:when test="${loggedInAsUser != null && loggedInAsAdmin == null}">
	 				<li class="nav-item"><a class="nav-link" href="#">Welcome ${loggedInAsUser}</a>
				</li>
				<li class="nav-item"><a class="nav-link"  href="LogoutServlet">Logout</a>
				</li>
	  <c:choose>
      <c:when test="${loggedInAsUser== 'Guest'}">

						<li class="nav-item"><a class="nav-link" href= #>My Wallet</a>
				</li>
						 <li class="nav-item"><a class="nav-link" href=Guestcancel>Cancel Booking</a>
				</li> 
   </c:when>
   <c:otherwise>

					<li class="nav-item"><a class="nav-link" href= "mywallet.jsp">My Wallet</a>
			</li>
				<li class="nav-item"><a class="nav-link" href="CancelTicket">Cancel Booking</a>
				</li>
</c:otherwise>
</c:choose>
</c:when>
 </c:choose> 
 </ul> 
 </div>
</nav>
  
</header>
</html>