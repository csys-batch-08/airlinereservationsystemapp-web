<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
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

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 23%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

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
<a href="FlightSearch.jsp"class="btn btn-primary" style="font-style: italic;"> Back </a> <br > <br />; 

     
		<%
String loggedInAsAdmin = (String) session.getAttribute("LOGGED_IN_ADMIN");
String loggedInAsUser = (String) session.getAttribute("LOGGED_IN_USER");

%>		
<main class="container-fluid">
		<h3 align="center">Forget Password</h3>
		<div align="center">
				<form  action="ForgetPassword" name="loginform" method="post" onsubmit = "return passwordvalidation()" >
				
				
				<div class="container"> 
				    <label for="username"><b>Username</b></label>
    <input type="text" id="username" placeholder="Enter Username" name="username" value="<%=request.getParameter("username") %>"  required>
<br></br>
    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
<br></br>
<label for="username"><b>Confirm Password</b></label>
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