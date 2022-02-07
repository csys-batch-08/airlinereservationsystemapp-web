<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login Screen</title>
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
  border: 3px solid #f1f1f1;
  width:43%;
  align:"center";
}
input[type=text], input[type=password] {
  width: 50%;
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
.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}
.container {
  padding: 16px;
}
</style>
<a href="Sourcedestination"class="btn btn-primary" style="font-style: italic;"> Back </a> <br > <br />; 
 <main class="container-fluid">
		<h3 align="center">Forget Password</h3>
		<div align="center">
				<form  action="ForgetPassword" name="loginform" method="post" onsubmit = "return passwordvalidation()" >
				<div class="container"> 
				    <label for="username"><strong>Username</strong></label>
    <input type="text" id="username" placeholder="Enter Username" name="username" value="${param.username}"required>
<br></br>
    <label for="password"><strong>Password</strong></label>
    <input type="password" placeholder="Enter Password" name="password" id="password" required>
<br></br>
<label for="username"><strong>Confirm Password</strong>></label>
    <input type="password" id="confirmpassword" placeholder="Enter password" name="confirmpassword" required>
    <br></br>
    <button type="submit">Login</button>
				</div>
   </form>
   </div>
     <script>
		    function passwordvalidation()
		    {
			     var password=document.loginform.password.value 
				    var password1 = document.loginform.confirmpassword.value
		    if(password==password1)
		    {
                 return true;
                 
		    }
		    else 		    {
		        alert("password must be same!");  

		    return false;  

		    }
		}
		    





		  

   </script>
   </main>
</body>
</html>