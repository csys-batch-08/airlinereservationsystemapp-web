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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<style>
body {
	background-image: url(image/flih.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	overflow-x:hidden

}
form {
  
  width:100%;
  align:"center";
  height:100%;
}
form {
 
  width:50%;
  align:"center";
}

 /* Full-width inputs */
/*input[type=text], input[type=password],input[type=email],input[type=radio],input[type=tel] {
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
/*button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 25%;
}

/* Add a hover effect for buttons */
/*button:hover {
  opacity: 0.8;
}

/* Extra style for the cancel button (red) */
/*.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

/* Add padding to containers */
/*.container {
  padding: 16px;
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
} */

</style>

<c:set value="${LOGGED_IN_ADMIN}" var="loggedInAsAdmin"/>
<c:set value="${LOGGED_IN_USER}" var="loggedInAsUser"  />

    <jsp:include page="headerfile.jsp"></jsp:include>
    
    <main class="container-fluid">
    <h1 style="text-align: center;"> eWallet Deposit</h1>
        <div >
       
<form action="Wallet" method="post">
            
            <div class="container">
            
                  <label for="closingbalance" style="font-family: serif;font-size: 21px; position:relative;width: 250px;top:33px;left: 3px;height: 20px;"
                   ><b>Closing Balance</b></label>
                 
                  <input type="hidden" name="closingbalance"  id="closingbalance" value="${Closingvalue}"
				style="position: relative; top: -1px; left: 100px;"      required autofocus  
				/> 
				
				<h3  style="position: relative;top: -8px; left: 220px;" id="closing"  ></h3>
				
			<br></br>
				 <label for="depositamount"style="font-family: serif;font-size: 21px; position:relative;width: 214px;top:-30px;left: 3px;height: 32px;" ><b>Deposit Amount</b></label>
<!-- 			 <input type="number" id="depositamount" name="depositamount"  
				min = "1" pattern="[1-9]+" required style="position: relative; top: -5px; left: 94px;"
				 /> -->
				<input type="number" class="form-control" name = "depositamount"   id="depositamount" min = "1" pattern="[1-9]+"  required
				    style="position: relative;width: 214px;top:-72px;left: 206px;height: 32px;"  >
			 
			<br></br>
			 <label for="confirmdepositamount" style="font-family: serif;font-size: 20px; position:relative;width: 250px;top:-73px;left: -20px;height: 20px;" ><b> Confirm Deposit Amount</b></label>
<!-- 			 <input type="number" id="confirmdepositamount" name="confirmdepositamount"  
				min = "1"  pattern="[1-9]+" required style="position: relative; top: -8px; left: 27px;"
				 />
 -->
 				<input type="number" class="form-control" name = "confirmdepositamount"   id="confirmdepositamount" min = "1" pattern="[1-9]+" required
				    style="position: relative;width: 218px;top:-102px;left: 204px;height: 32px;"  >
 
 
 				 <br></br>
 				 
				  <label for="mode" class="radio-inline"  onkeydown="return validation()"
				  style="font-family: serif;font-size: 20px; position:relative;width: 250px;top:-109px;left: -20px;
				  height: 20px;" ><b> Payment Mode *</b></label>
<!-- 				 <input type="radio" id="debit" name="debit" style="position: relative; top: -2px; left:81px; "
				value="DebitCard"  checked  > 
				<label for="debit" style="position: relative; top: -3px; left: 72px;"  >DebitCard</label> 
				
				<input type="radio" id="net" name="net" value="NetBanking"  style="position: relative; top: -2px; left: 96px;" > 
				<label for="net"  style="position: relative; top: -4px; left: 88px;">Net Banking</label>  -->
				
				<label class="radio-inline" style="position: relative;width: 210px;top:-102px;
				left: -64px;height: 32px;font-size: 20px; "><input type="radio" name="optradio" checked style="font-size: 10px; position: relative;width: 26px;"  >Debit Card</label>
				<label class="radio-inline"  style="position: relative;width: 218px;top:-102px;
				left: -147px;height: 32px; font-size: 20px "><input type="radio" name="optradio" checked>Credit Card</label>
				
				
				<br></br>
        <div style="text-align: center">
				<button type="Submit"  class="btn btn-info"  id="submit"    style="position: relative; top: -52px; left: -252px; width: 112px;"  >
					Submit	</button>
			</div>
			<a href="Sourcedestination" class="btn btn-danger" style="font-style: italic; position: relative; top: -86px; left: 56px; width: 83px"   > Back </a> <br > <br />
			
            </div>

            
            
           </form>
            </div>
            </main>
            		   <script>
		    function validation()
		    {
		     var amount=document.amountvalid.depositamount.value 
		    var confirmamount = document.amountvalid.confirmdepositamount.value
		    console.log(amount);
		     console.log(confirmamount);
		    if(amount==confirmamount)
		    {
                 return true;
                 
		    }
		    else 		    {
		        alert("Amount must be same!");  

		    return false;  

		    }
		}
		    walletuser();
		    function walletuser()
		    {  		        
		    let closingbalance=document.getElementById('closingbalance').value;
		    var url="Walletajax?closingbalance="+closingbalance;  
		    if(window.XMLHttpRequest){  
		    request=new XMLHttpRequest();  
		    }  
		    else if(window.ActiveXObject){  
		    request=new ActiveXObject("Microsoft.XMLHTTP");  
		    }  
		    try  
		    {  
		    request.onreadystatechange=closingdetails;  
		    request.open("GET",url,true);  
		    request.send();  
		    }  
		    catch(e)  
		    {  
		    alert("Unable to connect to server");  
		    }
		        
		       }
		    function closingdetails(){  
		    	if(request.readyState==4){  
		    	var response =request.responseText;  
		    	document.getElementById('closing').innerHTML = response;  

		    }
		    }



		    
		    


		  

   </script>
            
</body>

</html>