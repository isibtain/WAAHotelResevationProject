<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Room</title>
    <link href="resources/css/style.css" rel="stylesheet">
</head>
<body>
<div id="container">

    <div class="top">
      <h1><spring:message code="home.hotel.name" /></h1>
      <nav>
        <ul>
          <li><a href="<spring:url  value="/index" />" ><spring:message code="home" /></a></li>
          <li><a href="<spring:url  value="/admin" />" ><spring:message code="admin" /></a></li>
          <li><a href="<spring:url  value="/search" />" class="active"><spring:message code="search" /></a></li>
          <li><a href="<spring:url  value="/review" />" ><spring:message code="reviews" /></a></li>
          <li><a href="<spring:url  value="/signup" />" ><spring:message code="sign.up" /></a></li>  
          <li><a href="<spring:url  value="/login" />" ><spring:message code="sign.in" /></a></li>     
        </ul>
      </nav>
    </div>

    <div class="banner">
        <form:form id="searchForm" modelAttribute="booking" action="book" method="post" >
            <fieldset id="mainSearch" >
                Check In Date: <input id="checkIn" type="text" size="40" value="${checkIn }"/>
	            Check Out Date: <input id="checkOut" type="text" size="40" value="${checkOut }"/>
	            <form:input id="checkInDate" type="text" size="40" path="checkInDate" value="12-12-1212"/>
	            <form:input id="checkOutDate" type="text" size="40" path="checkOutDate" value="12-12-1212"/>
	            <p hidden="true"></p>
	            <form:input id="roomID" path="room.roomID" type="text" size="20" value="${roomID }" hidden="true"/>          
            </fieldset>
            <fieldset>
	        	Price Info and Picture of Room
	    	</fieldset>
            <fieldset id="mainSearch" >
                <label for="gym">Gym Included</label>
				<form:select id="gym" path="gym">
	 				<form:option value="true" label="Yes"/>
	 				<form:option value="false" label="No"/> 
				</form:select>
				     
				<label for="gym">Parking Included</label>
				<form:select id="parking" path="parking">
	 				<form:option value="true" label="Yes"/>
	 				<form:option value="false" label="No"/> 
				</form:select>
				     
            </fieldset><br>
            <fieldset id="mainSearch" >
                <label for="firstName">First Name</label><form:input   path="customer.firstName"/>                          		               
		        <label for="lastName">Last Name</label><form:input   path="customer.lastName"/><br>
		        <form:errors path="customer.firstName" class="texterror"/><br>
	   			<form:errors path="customer.lastName" class="texterror"/>
	   			<br>
	   			<label for="customer.address.street">Street</label><form:input path="customer.address.street"/>	          		          
		        <label for="customer.address.city">City</label><form:input path="customer.address.city"/>	          		        
		        <label for="customer.address.state">State</label><form:input path="customer.address.state"/>	          		        
		        <label for="customer.address.zip">Zip Code</label><form:input path="customer.address.zip"/>	          		         	
		        <label for="customer.address.phone">Phone Number</label><form:input path="customer.address.phone"/>	          		        
		        <label for="customer.address.email">Email Address</label><form:input path="customer.address.email"/><br>
		        <form:errors path="customer.address.phone" class="texterror"/><br>
		        <form:errors path="customer.address.zip" class="texterror"/><br>
		        <form:errors path="customer.address.state" class="texterror"/><br>
		        <form:errors path="customer.address.city" class="texterror"/><br>
		        <form:errors path="customer.address.street" class="texterror"/><br>	          
		        <form:errors path="customer.address.email" class="texterror"/>	
		        <form:errors path="checkInDate" class="texterror"/>	
		        <form:errors path="checkOutDate" class="texterror"/>	       
            </fieldset><br>
            <h2 style="color: ${color};" >${roomMessage }</h2>
            <p id="buttons" align="center">
		            <input id="submit" type="submit"  value="SUBMIT" />
		   	</p>                   
        </form:form>
    </div>
    
    <footer class="foot">    	   	
    	<spring:message code="home.language" /> : <a href="?language=en_US">English</a>|<a href="?language=am_ET">አማርኛ</a>|<a href="?language=ur_PK">Urdu</a>   	
    </footer>
</div>
</body>
</html>
