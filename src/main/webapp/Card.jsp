<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
body {
background-image: url(image/bg9.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	
	font-family: Arial, Helvetica, sans-serif;
	align:"center";
	
}



form {
  
  width:50%;
  align:"center";
}

/* Full-width inputs */
input[type=text] {
  width: 40%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
 input[type=radio] {
  width: 10%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

/* Set a style for all buttons */
button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 32%;
}

/* Add a hover effect for buttons */
button:hover {
  opacity: 0.8;
}

/* Extra style for the cancel button (red) */
.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

/* Center the avatar image inside this container */
.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

/* Avatar image */
img.avatar {
  width: 23%;
  border-radius: 50%;
}

/* Add padding to containers */
.container {
  padding: 16px;
}

/* The "Forgot password" text */
span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
    display: block;
    float: none;
  }
  .cancelbtn {
    width: 100%;
  }
}
</style>

 <main class="container-fluid">
		<h3 align="center">Card Details </h3>
		<div align="center">
				<form  action="Loginservlet" method="post" >
				
				
				
				<div class="container">
				   
<br></br>
    <label for="cardno"><b>Card No</b></label>
    <input type="text"  name="cardno" readonly min = "0">
    <br></br>
    
  
    <label for="cardtype"><b>Card Type</b></label>
    <input type="text"  name="cardtype" readonly  >
<br></br>
    <label for="holdername"><b>Holder Name</b></label>
    <input type="text"  name="holdername" readonly >
    <br></br>
    
    <label for="bankname"><b>Bank Name</b></label>
    <input type="text"  name="bankname" readonly>
    <br></br>
    
      <label for="expirydate"><b>Expiry Date</b></label>
    <input type="date"  name="expirydate" readonly>
    <br></br>
    
     <br></br>
    <button type="submit"><a href="FlightSearch.jsp">PAY</a></button>
   
				</div>
					
   </form>
   </div>
   
   <script>
   setTimeout(function(){
       window.location.href = 'FlightSearch.jsp';
    }, 50000);
</script>
<script>

today();
function today(){
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = today.getFullYear();
    var yyyy1= today.getFullYear()+10;
maxdate =yyyy1 + '-' + mm + '-'+ dd  ;
mindate =yyyy + '-' + mm + '-'+ dd  ;
document.getElementById("date").setAttribute("max",maxdate);
document.getElementById("date").setAttribute("min",mindate);



</script>
   </main>


</body>
</html>