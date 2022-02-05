<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login Screen</title>
</head>
<body>
	<style>
body {
	background-image: url(https://wallpapercave.com/wp/wp2574353.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	font-family: Arial, Helvetica, sans-serif;
	align: "center";
}

form {
	border: 3px solid #f1f1f1;
	width: 90%;
	align: "left";
}

input[type=text], input[type=password] {
	width: 63%;
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



	<c:set value="${LOGGED_IN_ADMIN}" var="loggedInAsAdmin" />
	<c:set value="${LOGGED_IN_USER}" var="loggedInAsUser" />
	<c:set value="${Error}" var="error" />
	<main class="container-fluid">

		<div style="margin-right: 900px; margin-top: 70px;">
			<h1 align="center" style="color: white;">Login</h1>
			<div align="center">
				<c:if test="${param.success eq 1}">
					<h2 id="register">
						<c:out value="${Valid}" />
					</h2>
				</c:if>
				<form action="Loginservlet" method="post">


					<div class="container">
						<label for="username" style="color: white;"><strong>Username</strong>></label>
						<input type="text" id="username" placeholder="Enter Username"
							name="username" required> <b></b> <label for="password"
							style="color: white;"><b>Password</b></label> 
							<input type="password" id="Password" placeholder="Enter Password"
							name="password" required onkeyup="validlogin()">


						<div id="fads">
							<c:if test="${error!=null}">
								<p id="value" style="font-size: 20px; color: red;">${error}
								</p>

							</c:if>


						</div>
						<button type="submit" id="submit">Login</button>
					</div>

					<p id="loginresponse"></p>


					<c:set value="${param.username}" var="username" />


					<div class="container" style="background-color: #f1f1f1">
						<button type="button" class="cancelbtn">
							<a href="Sourcedestination" style="text-decoration: blink;">BACK</a>
						</button>
						<c:if test="${error!=null}">

							<a href="forgotpassword.jsp?username=${param.username}"
								class="btn btn-primary">Forget password?</a>
						</c:if>

					</div>
				</form>
			</div>
		</div>

		<script>
			function validation() {
				let username = document.getElementById("username").value;

				if (username == "") {
					alert("Please enter the username");

				} else {
					return true;
				}

				return false;

			}

			function validlogin() {
				console.log("called");
				let uname = document.getElementById("username").value;

				console.log(uname);
				var url = "Uservalid?uname=" + uname;

				console.log(url);

				if (window.XMLHttpRequest) {
					request = new XMLHttpRequest();
				} else if (window.ActiveXObject) {
					request = new ActiveXObject("Microsoft.XMLHTTP");
				}
				try {
					request.onreadystatechange = getInfo;
					request.open("POST", url, true);
					request.send();
				} catch (e) {
					alert("Unable to connect to server");
				}

			}

			function getInfo() {
				if (request.readyState == 4) {
					var loginresponse = request.responseText;
					if (loginresponse.includes("User Name Not Valid")) {
						document.getElementById('loginresponse').innerHTML = loginresponse;
						document.getElementById('username').value = '';
					}

				}
			}

			window.onload = function() {
				window.setTimeout(fadeout, 3000); //8 seconds
			}

			function fadeout() {
				document.getElementById('value').style.opacity = '0';
			}

			document.getElementById("username").onkeyup = function() {
				myfunction()
			};

			function myfunction() {
				document.getElementById("register").innerHTML = "";
			}
			document.getElementById("submit").onkeyup = function() {
				usernamefunction()
			};

			function usernamefunction() {
				document.getElementById("loginresponse").innerHTML = "";
			}
		</script>
	</main>
</body>
</html>