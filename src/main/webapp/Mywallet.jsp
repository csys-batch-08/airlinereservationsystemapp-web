<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Services.FlightService"%>
                         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                     <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
                 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wallet Deposit</title>
</head>
<body>
<style>
body {
	background-image: url(image/flih.jpg);
	background-repeat: no-repeat;
	background-size: cover;
}
form {
  
  width:50%;
  align:"center";
  height:50%;
}
form {
 
  width:50%;
  align:"center";
}

/* Full-width inputs */
input[type=text], input[type=password],input[type=email],input[type=radio],input[type=tel] {
  width: 6%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

input[type=number] {
  width: 31%;
  left: 15%;
  padding: 2px 20px;
  margin: 3px 0;
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
  width: 25%;
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
a:link, a:visited {
  background-color: white;
  color: black;
  border: 2px solid green;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: green;
  color: white;
}

</style>

<%-- <% String loggedInAsAdmin = (String) session.getAttribute("LOGGED_IN_ADMIN");
String loggedInAsUser = (String) session.getAttribute("LOGGED_IN_USER");

FlightService flightService = new FlightService();
int Closingbalance = flightService.getclosingbalance(loggedInAsUser);

%> --%>

<c:set value="${Closingvalue}" var="closebalance"/>
<c:set value="${LOGGED_IN_ADMIN}" var="loggedInAsAdmin"/>
<c:set value="${LOGGED_IN_USER}" var="loggedInAsUser"  />

    <jsp:include page="Header.jsp"></jsp:include>
    <main class="container-fluid">
    <h1 style="text-align: center;"> eWallet Deposit</h1>
        <div >
       
            <form  id="form" name ="amountvalid" action="Wallet" method="post"  onsubmit="return validation()" >
            <div class="container">
                  <label for="closingbalance" ><b>Closing Balance</b></label>
                  <input type="number" name="closingbalance" value="${Closingvalue}"
				style="position: relative; top: -1px; left: 100px;"      required autofocus  readonly
				/>
			<br></br>
				 <label for="depositamount"><b>Deposit Amount</b></label>
			 <input type="number" id="depositamount" name="depositamount"  
				min = "1" pattern="[1-9]+" required style="position: relative; top: -5px; left: 94px;"
				 />
			<br></br>
			 <label for="confirmdepositamount"><b> Confirm Deposit Amount</b></label>
			 <input type="number" id="confirmdepositamount" name="confirmdepositamount"  
				min = "1"  pattern="[1-9]+" required style="position: relative; top: -8px; left: 27px;"
				 />
				 <br></br>
				  <label for="mode" required  ><b> Payment Mode *</b></label>
				 <input type="radio" id="debit" name="debit" style="position: relative; top: -2px; left:81px; "
				value="DebitCard"  > 
				<label for="debit" style="position: relative; top: -3px; left: 72px;"  >DebitCard</label> 
				
				<input type="radio" id="net" name="net" value="NetBanking"  style="position: relative; top: -2px; left: 96px;" > 
				<label for="net"  style="position: relative; top: -4px; left: 88px;">Net Banking</label> 
				
				<br></br>
				<label for="bankname" style=" display: inline-block;"><b>Select Bank</b></label>

<select name="bankname" id="bankname"  style="position: relative; top: -8px; left: 131px;"  required>
  <option value="hdfc">HDFC</option>
  <option value="sbi">SBI</option>
  <option value="standard">Standard Chartered Bank</option>
  <option value="icici">ICICI</option>
</select>

<br></br>
<div style="text-align: center">
				<button type="Submit"  required  style="position: relative; top: 47px; left: 40px;"
					>
				Submit	</button>
			</div>
			<a href="FlightSearch.jsp"class="btn btn-primary" style="font-style: italic; position: relative; top: 10px; left: 50px;"   > Back </a> <br > <br />
			
            </div>
           </form>
            </div>
            </main>
            		   <script>
		    function validation()
		    {
		     var amount=document.amountvalid.depositamount.value 
		    var confirmamount = document.amountvalid.confirmdepositamount.value
		    if(amount==confirmamount)
		    {
                 return true;
                 
		    }
		    else 		    {
		        alert("Amount must be same!");  

		    return false;  

		    }
		}
		    	
	 
		    



		  

   </script>
            
</body>

</html>