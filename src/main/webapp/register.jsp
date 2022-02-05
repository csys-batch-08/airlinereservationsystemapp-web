<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>REGISTER FORM</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>

</head>
<body>
	<style>
body {
	background-image: url(image/878641.jpg);
	background-repeat: no-repeat;
	background-size: cover;
}
form {
  border: 3px solid #f1f1f1;
  width:30%;
  align:"center";
}
/* form {
  border: 3px solid #f1f1f1;
  width:30%;
  align:"center";
} */
 input[type=text], input[type=password],input[type=email],input[type=radio],input[type=tel] {
  width: 63%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
input[type=radio] {
  width: 18%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
  
}
button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 62%;
}
button:hover {
  opacity: 0.8;
}
 .container {
  padding: 16px;
} 
</style>
			
			<main class="container-fluid">
		<h3 align="center">New User Registration Form </h3>
		
		<h1>  <c:out value="${invalid}"   />             </h1>
		
		<div align="center">	
	<form name="RegisterForm" action="FlightRegister" method="post"  > 
				
		
		<div class="container">
			
			<br /> <input type="text" name="name" id="name"   pattern="[A-Za-z]{3,20}" 
				placeholder="Enter name" required autofocus
				/>
				<br>
				
			<br> <input type="text"  id="email" name="email" onkeyup = "sendemail()" 
				placeholder="Enter email address" style="position: relative;top: -8px" required/>	
				  
				  
				 	
				<br>
				 
			
			
			<br> <input type="text" id="username" name="username"  onkeyup=" validuser()"
				pattern="[A-Za-z\s]{3,8}"  placeholder="Enter User name" style="position: relative;top: -10px"  required
				autofocus  
				/>	
				
				<br>			 
				
			
				<br>
				
				
				<input type="password" name="password" id="password" placeholder="Enter new password" 
					style="position: relative;top: -8px"
				required
				/><br>
				<br>
				
				
			<br> <input type="password" name="password1"style="position: relative;top: -25px" id="Confirm"
				required  placeholder="Confirm Password "  
				 /><br>
				<br>
				
<div id="phonere">
               		 <input type="tel" id="phoneNumber" name="phoneNumber" pattern = "[6-9][0-9]{9}" 
				 placeholder="Enter Mobile Number" style="position: relative;top: -25px" required  onkeydown="return validation()"
				 />
				
				</div>
			<br> 
			
						<input type="radio" id="Male" name="Gender"
				value="Male"  onkeyup="phonenumber()"  > 
				<label for="Male" style="color: white;">Male</label> 
				
				<input type="radio" id="Female" name="Gender" value="Female"> 
				<label for="Female" style="color: white;">Female</label> 
				<input type="radio" id="Others"
				name="Gender" value="Others" > <label
				for="Others"style="color: white;" >Others</label>
			
            
			<div style="text-align: center">
							<button type="Submit"  style="position: relative;top: 4px">
				Register	</button>
			
			</div>
			<div id="messages" style="text-align: center;color: white;font-family:cursive; font-style: inherit   ;font-size: 18px;">
		 				  	
		 				  	 <p  id = "emailresponse"></p> 
		 
			
			<p id = "userresponse"></p>
			<p id = "phoneresponse"></p>
			</div>
			
			</div>
		</form>
		  </div>
		   <script>
		    function validation()
		    {
		     var password=document.RegisterForm.password.value 
		    var password1 = document.RegisterForm.password1.value
		    if(password==password1)
		    {
                 return true;
                 
		    }
		    else 		    {
		        alert("password must be same!");  
		    return false;  
		    }
		}
		    
 function sendemail(){
     let email=document.getElementById('email').value;
     console.log(email);
		$.ajax({
			type:'POST',
	 url:'Emailcheck',
	data:'email='+email,    
	cache:false,
	 success:function(response){
	 	if(response.includes("Email id Already Registered"))
	    {
		document.getElementById("emailresponse").innerHTML=response;
		document.getElementById('email').value = '';  
		}
	 }
		});
			    }
 
 function validuser(){
 let username=document.getElementById("username").value;
		    console.log(username);
	$.ajax({
		type:'POST',
 url:'checkusername',
data:'username='+username,    
cache:false,
 success:function(response){
 	if(response.includes("User Name already Registered"))
    {
	document.getElementById("userresponse").innerHTML=response;
	document.getElementById('username').value = '';  
	}
 }
	});
		    }
	
		    function phonenumber(){
                  let phoneno = document.getElementById("phoneNumber").value;
		    		$.ajax({
		    			type:'POST',
		    	 url:'phonevalid',
		    	data:'phoneno='+phoneno,    
		    	cache:false,
		    	 success:function(response){
		    	 	if(response.includes("Mobile Number Already Present"))
		    	    {
		    		document.getElementById("phoneresponse").innerHTML=response;
		    		document.getElementById('phoneNumber').value = '';  
		    		}
		    	 }
		    		});
		    			    } 
		    		

		    
	    	document.getElementById("email").onkeydown = function() {validfunction()};
	    	function validfunction()
	    	{
	    		document.getElementById("emailresponse").innerHTML = "";
	    	}
		    
		    	document.getElementById("password").onkeydown = function() {userfunction()};
		    	
		    	function userfunction()
		    	{
		    		document.getElementById("userresponse").innerHTML = "";
		    	}
		    	document.getElementById("Male").onkeydown = function() {myfunction()};
		    	
		    	function myfunction()
		    	{
		    		document.getElementById("phoneresponse").innerHTML = "";
		    	}
		    	
		    	
		    	

		    	
		    	
 	  
 </script>
</main>
</body>
</html>