<link rel="stylesheet" href="Assets/css/bootstrap.min.css">
<link rel="stylesheet" href="Assets/css/fontawesome.min.css">
<link rel="stylesheet" href="Assets/css/style.css">

                     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                     <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<header>


<c:set value="${LOGGED_IN_ADMIN}" var="loggedInAsAdmin"/>
<c:set value="${LOGGED_IN_USER}" var="loggedInAsUser"  />
<c:set value="${LOGGED_IN_USER}" var="loggedguest"  />
<c:set value="${ROLE}" var="role"  />

	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand">Air Line Reservation
			System</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="FlightSearch.jsp">Home <span class="sr-only">(current)</span></a></li>
					</ul>
		
<ul class="navbar-nav ml-auto mt-2 mt-lg-0">

<c:if test="${loggedInAsAdmin == null && loggedInAsUser == null}">
				<li class="nav-item active"><a class="nav-link"
					href="login.jsp">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="Register.jsp">Register</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="GuestLogin.jsp">Guest Login</a>
				</li>
</c:if>
<c:if test="${loggedInAsUser == null && loggedInAsAdmin != null}">

				<li class="nav-item"><a class="nav-link" href="#">Welcome ${loggedInAsAdmin}</a>
				</li>
				<li class="nav-item"><a class="nav-link" href ="LogoutServlet">Logout</a>
				</li>
</c:if>
<c:choose>
<c:when test="${loggedInAsUser != null && loggedInAsAdmin == null}">

				<li class="nav-item"><a class="nav-link" href="#">Welcome ${loggedInAsUser}</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="LogoutServlet">Logout</a>
				</li>

<%-- <c:when test="${loggedInAsUser.equals('Guest')}">
 --%>
 <c:choose>
 <c:when test="${loggedInAsUser== Guest}">

						<li class="nav-item"input type="text"  readonly><a class="nav-link" href= #>My Wallet</a>
				</li>
						 <li class="nav-item"><a class="nav-link" href=Guestcancel>Cancel Booking</a>
				</li> 
</c:when>
<c:otherwise>

					<li class="nav-item"input type="text"  ><a class="nav-link" href= "Mywallet.jsp">My Wallet</a>
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


