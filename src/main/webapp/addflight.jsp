<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>ADD FLIGHT</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<style>
a:link, a:visited {
  background-color: #f44336;
  color: white;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}
a:hover, a:active {
  background-color: red;
}
</style>

<body>

       <a href="Sourcedestination"   class="btn btn-danger"> Back </a> <br > <br />

       
    <h1 style="text-align: center;">
				<strong>ADD FLIGHT DETAILS</strong></h1>
		<form name="addflight" action="AddFlightservlet" method="post"  >
			
			<label class="visually-hidden" for="Flightname"></label>
			<br /> <input type="text" name="Flightname"  id="Flightname"
				placeholder="FLIGHT_NAME" required autofocus pattern="[A-Z a-z]{3,120}" 
				style="position: relative; left: 40px; height: 30px; top: -2px; width: 230px" />
			
			<label class="visually-hidden" for="text"></label>
			<br> <input type="text" id="text" name="source" 
				placeholder="Enter Source" required pattern="[A-Z a-z]{3,120}"
				style="position: relative; left: 41px; height: 33px; top: 17px; width: 228px" />
			
						<label class="visually-hidden" for="Destination"></label>
			<br> <input type="text" name="Destination" id="Destination"
			  placeholder="Enter Destination " required
				autofocus  pattern="[A-Z a-z]{3,120}"
				style="position: relative; left: 40px; height: 30px; top: 39px; width: 230px" />
				<br>
				
				<label class="visually-hidden" for="Economyclass"></label>
				<input type="number" name="Economyclass"  id="Economyclass"  placeholder="ECONOMY_CLASS"  min = "1" required pattern="[1-9]+"
				style="position: relative; left: 40px; height: 30px; top: 62px; width: 230px" />
				
			<label class="visually-hidden" for="PremiumEconomyclass"></label>
			<br> <input type="number" name="PremiumEconomyclass" id="PremiumEconomyclass" min = "1" pattern="[1-9]+"
				placeholder="PREMIUM_ECONOMY_CLASS " required
				style="position: relative; left: 40px; height: 30px; top: 77px; width: 230px" /><br>
				
							<label class="visually-hidden" for="Bussinessclass"></label>
			<input type="number"  name="Bussinessclass" - id="Bussinessclass" placeholder="Bussinessclass" min = "1" pattern="[1-9]+"
				value="Male" style="position: relative; left: 39px;height: 31px; top: 99px;width: 229px">
				<br> 
											<label class="visually-hidden" for="Arrivaldate"></label>
								<input type="date" name="ArrivalDate" id="Arrivaldate" placeholder = "ArrivalDate" required
				style="position: relative; left: 40px; height: 30px; top:120px; width: 230px" />
				<br>
															<label class="visually-hidden" for="DepartureDate"></label>
								<input type="date" name="DepartureDate" id="DepartureDate" placeholder = "DepartureDate" required
				style="position: relative; left: 45px; height: 30px; top: 151px; width: 230px" />
				<br>
				<label class="visually-hidden" for="Arrivaltime"></label>
				<input type="time" name="Arrivaltime" id="Arrivaltime" placeholder = "ArrivalTime" required
				style="position: relative; left: 382px; height: 30px; top:-153px; width: 230px" />
				<br>
								<label class="visually-hidden" for="Departuretime"></label>
				<input type="time" name="Departuretime" id="Departuretime" placeholder = "Departure TIme" required
				style="position: relative; left: 382px; height: 30px; top: -114px; width: 230px" />
				<br>
				
				
				
												<label class="visually-hidden" for="ecomomy_seats"></label>
				<input type="number" name="ecomomy_seats" id="ecomomy_seats" placeholder = "ecomomy_seats" min = "1"  required pattern="[1-9]+"
				style="position: relative; left: 384px; height: 30px; top: -89px; width: 230px" />
				<br>
				
																<label class="visually-hidden" for="premium_economy_seats"></label>
				<input type="number" name="premium_economy_seats" id="premium_economy_seats" placeholder = "premium_economy_seats" min = "1"  required pattern="[1-9]+"
				style="position: relative; left: 384px; height: 30px; top: -62px; width: 230px" />
				<br>
												<label class="visually-hidden" for="business_seats"></label>
								<input type="number" name="business_seats" id="business_seats" placeholder = "business_seats" min = "1" pattern="[1-9]+" required
				style="position: relative; left: 384px; height: 30px; top: -37px; width: 230px" />
				<br>
				
			
               



			<div style="text-align: center">
				<button type="Submit"  class="btn btn-success" 
					style="position: relative; left: 40px; height: 37px; top: 8px; width: 230px">
				AddFlight	</button>
			</div>
		</form>
    <script>
    
    today();
    function today()
    {
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();
        var yyyy1= today.getFullYear()+10;
    maxdate =yyyy1 + '-' + mm + '-'+ dd  ;
    mindate =yyyy + '-' + mm + '-'+ dd  ;
    document.getElementById("Arrivaldate").setAttribute("max",maxdate);
    document.getElementById("Arrivaldate").setAttribute("min",mindate);
    }
    todaydate();
    function todaydate()
    {
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();
        var yyyy1= today.getFullYear()+10;
    maxdate =yyyy1 + '-' + mm + '-'+ dd  ;
    mindate =yyyy + '-' + mm + '-'+ dd  ;
    document.getElementById("DepartureDate").setAttribute("max",maxdate);
    document.getElementById("DepartureDate").setAttribute("min",mindate);
    }
    
    
    
    
    </script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>    

</body>
</html>