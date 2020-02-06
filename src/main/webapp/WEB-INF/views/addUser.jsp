<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>Add User</title>
    <link href="resources/css/index.css" rel="stylesheet">
  </head>
  <body>
  <div id="container">

    <div class="top">
      <h1><spring:message code="home.hotel.name" /></h1>
      <nav>
        <ul>
          <li><a href="<spring:url  value="/index" />" ><spring:message code="home" /></a></li>
          <li><a href="<spring:url  value="/admin" />" class="active"><spring:message code="admin" /></a></li>
          <li><a href="<spring:url  value="/search" />" ><spring:message code="search" /></a></li>
          <li><a href="<spring:url  value="/review" />" ><spring:message code="reviews" /></a></li>
          <li><a href="<spring:url  value="/signup" />" ><spring:message code="sign.up" /></a></li>  
          <li><a href="<spring:url  value="/login" />" ><spring:message code="sign.in" /></a></li>     
        </ul>
      </nav>
    </div>
    <p style="text-align: right;">
    <spring:message code="home.language" /> : <a href="?language=en_US">English</a>|<a href="?language=am_ET">አማርኛ</a>
    </p>
    
    <div class="top">
      <nav>
        <ul>      
          <li class="mid"><a href="<spring:url  value="/addRoom" />" ><spring:message code="admin.manage.room" /></a></li>
          <li class="mid"><a href="<spring:url  value="/addBooking" />" ><spring:message code="admin.manage.bookings" /></a></li>
          <li class="mid"><a href="<spring:url  value="/addUser" />" class="active"><spring:message code="admin.manage.user" /></a></li>
        </ul>
      </nav>
    </div><br>
    
    <div>
  		<form:form modelAttribute="user" action="addUser" method="post">
	    	<fieldset>
	        	<legend>Add User Details</legend>
		        	        
		        	<label for="firstName">First Name</label>
	   				<form:input   path="firstName"/>	          
		               
		        	<label for="lastName">Last Name</label>
	   				<form:input   path="lastName"/>	          
		                
		        	<label for="userName">User Name</label>
	   				<form:input   path="userName"/>	          
		               
		        	<label for="password">Password</label>
	   				<form:input   path="password"/>	          
		        
	    	</fieldset>
	    	
	    	<fieldset>
	        	<legend>Add User Address</legend>
		        <p>        
		        	<label for="address.street">Street</label>
	   				<form:input   path="address.street"/>	          
		              
		        	<label for="address.city">City</label>
	   				<form:input   path="address.city"/>	          
		                
		        	<label for="address.state">Stste</label>
	   				<form:input   path="address.state"/>	          
		               
		        	<label for="address.zip">Zip Code</label>
	   				<form:input   path="address.zip"/>	          
		      	</p>        
		        	<label for="address.email">Email Address</label>
	   				<form:input   path="address.email"/>	          
		             
		        	<label for="address.phone">Phone Number</label>
	   				<form:input   path="address.phone"/>	          
	   						  		       
	    	</fieldset>
	    	<p id="buttons">
		            <input id="reset" type="reset"  value="RESET" />
		            <input id="submit" type="submit"  value="SUBMIT" />
		    </p>
		</form:form> 
    </div>

    <footer><spring:message code="home.copyright" /> 2019</footer>
  </div>

  </body>
</html>