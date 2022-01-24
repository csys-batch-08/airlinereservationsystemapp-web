<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GUESTLOGIN</title>
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
 
  width:30%;
  align:"center";
}

/* Full-width inputs */
input[type=tel], input[type=email] {
  width: 63%;
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
  width: 62%;
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
<%

String loggedguest = (String)session.getAttribute("LOGGED");
String role = (String)session.getAttribute("ROLE");
String error =   (String)session.getAttribute("Errorvalue");


%>


<a href="FlightSearch.jsp"class="btn btn-primary" style="font-style: italic"> Back </a> <br > <br />; 

<main class="container-fluid">
		<h3 align="center">Guest Login </h3>
		<div align="center">


    		<form name="GuestForm" action="GuestLogin" method="post" >
    		
    			<div class="imgcontainer">
				<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQIwMIGTutu1jpkhgNCLM-Rd2gz3d0MRSXuPw&usqp=CAU
" alt="Avatar" class="avatar">
				</div>
				
    		      <input type="tel" id="phoneNumber" name="phoneNumber" pattern = "[6-9][0-9]{9}" 
				 placeholder="Enter Mobile Number" required  pattern = "[6-9][0-9]{9}"
				 />
				
				
			<br> 
			
			
			 <input type="email" id="email" name="email" pattern = "[a-zA-z][A-Za-z0-9]+[@][a-zA-Z]+[.][A-Za-z]{2,3}" 
 placeholder="Enter email address" required 
				 />
			
						<div style="text-align: center" >
				<button type="Submit"  required   onkeyup ="validlogin()" >Submit
					
					
				
			</div>
								<p id="guestresponse"  style="font-style: italic; color: red; font-size: 20px;"></p>
			
					<a href="FlightSearch.jsp"class="btn btn-primary" style="font-style: italic"> Back </a> <br > <br />
			
			</form>
		<div>	
			<%
			if (error!= null) {
			%>
					<p id="value"   style="font-size: 20px; color: red;"><%=error%> </p>
					
				<% }
			
			
   			%>
   </div>
			
    		
    </div>
    <script>
    
    function validlogin()
    {
	    console.log("called");
        let mail =document.getElementById("email").value;
        let phone =document.getElementById("phoneNumber").value;

        console.log(mail);

        console.log(phone);
   var url="GuestCheck.jsp?phone="+phone+'&mail='+mail;

    console.log(url);

    if(window.XMLHttpRequest){  
    request=new XMLHttpRequest();  
    }  
    else if(window.ActiveXObject){  
    request=new ActiveXObject("Microsoft.XMLHTTP");  
    }  
    try  
    {  
    request.onreadystatechange=getInfo;  
    request.open("GET",url,true); 
    request.send();
    }  
    catch(e)  
    {  
    alert("Unable to connect to server"); 
    }
        

    }
    
    function getInfo()
    {  
    	if(request.readyState==4){  
    	var response =request.responseText; 
    	if(response.includes("Phone Number Already Registered"))
    		{
    	document.getElementById('guestresponse').innerHTML=response;  
       
  document.getElementById("phoneNumber").value="";


    		}
    	}  
    }  


	document.getElementById("phoneNumber").onkeydown = function() {myfunction()};
	
	function myfunction()
	{
		document.getElementById("guestresponse").innerHTML = "";
	}

    
    
    </script>
    </main>




</body>
</html>