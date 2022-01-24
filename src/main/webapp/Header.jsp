<link rel="stylesheet" href="Assets/css/bootstrap.min.css">
<link rel="stylesheet" href="Assets/css/fontawesome.min.css">
<link rel="stylesheet" href="Assets/css/style.css">
<header>

<%
String loggedInAsAdmin = (String) session.getAttribute("LOGGED_IN_ADMIN");
String loggedInAsUser = (String) session.getAttribute("LOGGED_IN_USER");
String loggedguest = (String)session.getAttribute("LOGGED_IN_USER");
String role = (String)session.getAttribute("ROLE");
%>
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
				<%
				if (loggedInAsAdmin == null && loggedInAsUser == null ) {
				%>
				<li class="nav-item active"><a class="nav-link"
					href="login.jsp">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="Register.jsp">Register</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="GuestLogin.jsp">Guest Login</a>
				</li>
				<%
				} else if (loggedInAsUser == null && loggedInAsAdmin != null ) {
				%>
				<li class="nav-item"><a class="nav-link" href="#">Welcome <%=loggedInAsAdmin%></a>
				</li>
				<li class="nav-item"><a class="nav-link" href ="LogoutServlet">Logout</a>
				</li>
				
				<%
				} 
				else if(loggedInAsUser != null && loggedInAsAdmin == null )
				
				{
				%>
				<li class="nav-item"><a class="nav-link" href="#">Welcome <%=loggedInAsUser%></a>
				</li>
				<li class="nav-item"><a class="nav-link" href="LogoutServlet">Logout</a>
				</li>
				<%
				if(loggedInAsUser.equalsIgnoreCase("Guest") )
				{
					%>
						<li class="nav-item"input type="text"  readonly><a class="nav-link" href= #>My Wallet</a>
				</li>
						 <li class="nav-item"><a class="nav-link" href=Guestcancel>Cancel Booking</a>
				</li> 
				<%}
				
				
				else
				{
					%>
					<li class="nav-item"input type="text"  ><a class="nav-link" href= "Mywallet.jsp">My Wallet</a>
			</li>
				<li class="nav-item"><a class="nav-link" href="CancelTicket">Cancel Booking</a>
				</li>

				<% }%>
					
				
<!--  				<li class="nav-item"><a class="nav-link" href="CancelTicket">Cancel Booking</a>
				</li>
 -->			
 	<%
				}
				
				%>
			</ul>
		</div>
	</nav>
</header>


