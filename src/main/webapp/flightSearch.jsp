<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FLIGHT SEARCH PAGE</title>
</head>
<style>
body {
   background-image: url(image/254381.jpg);
   background-repeat: no-repeat;
   background-size:  cover;
   }

<body>

form {
left:40px;
 height:40%;
  width:30%;
  align:"center";
}
/* Full-width inputs */
input[type=text], input[type=date] {
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
</style>
 <jsp:include page="header.jsp"></jsp:include>
       <marquee style="color: red"><i style="font-size: 30px">LET  &nbsp &nbsp &nbsp YOUR  &nbsp &nbsp &nbsp DREAMS  &nbsp &nbsp &nbsp TAKE  &nbsp &nbsp &nbsp FLIGHT</i></marquee>
 
        <div style="margin-left: 918px;margin-top: 30px">
        
            <form  id="form" action="SearchFlight"   method="post"  style="text-align: center; color: black; left:40px; width: 380px;" >
                     
              <input type="text"  
              id="fightsource" list="source" name="source" placeholder="Source" required>  
 <datalist id="source" >  

                        <c:forEach items="${Sourcelist}" var="source">
          
         <option>
         
      
                       ${source.getSource()}
      
      </option>
            </c:forEach>
      
 </datalist>
    
   <input type="text"  
              id="fightdestination" list="destination" name="destination" placeholder="Destination"  required
>  
 <datalist id="destination">  

           <c:forEach items="${Sourcelist}" var="destination">
      
      <option>
      ${destination.getDestination()}
      
      </option>
      </c:forEach>
      </datalist>

                   <input  type="date" name="date" id  = "date" max="2022-10-26"  >
              
              
              <br><br>
              
              
            
            <button  type="submit"  onclick="return validation()">Submit </button><br><br>

           	 <a href="FlightSearch"  class="btn btn-primary">List All Flight Details</a>


	        </form>
	
	
           	 
           	 
   
            
      
    
    </div>
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
}
    function validation()
    {
     var source=document.getElementById("fightsource").value.toUpperCase();
    var destination = document.getElementById("fightdestination").value.toUpperCase();
    console.log("fbjdfbjdjfdjfdjfjfdjhfjhfdhjdf");
    console.log(source);
    if(source!=destination)
    {
         return true;
         
    }
    else 		    {
        alert("Source and Destination  must not be same!");  
    return false;  
    }
}
    
    </script>

   
</body>
</html>