<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Add Booking</title>
    <link href="resources/css/style.css" rel="stylesheet">
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
    
    <div class="top">
      <nav>
        <ul>
          <li class="mid"><a href="<spring:url  value="/addRoom" />" ><spring:message code="admin.manage.room" /></a></li>
          <li class="mid"><a href="<spring:url  value="/addBooking" />" class="active"><spring:message code="admin.manage.bookings" /></a></li>
          <li class="mid"><a href="<spring:url  value="/addUser" />" ><spring:message code="admin.manage.user" /></a></li>
        </ul>
      </nav>
    </div><br>
    
    <div class="banner">
        <form:form id="searchForm" modelAttribute="booking" action="addBooking" method="post" >
            <fieldset id="mainSearch">
	        	<legend>Add Booking</legend>	        	
	        	<p>
	                Check In Date: <form:input id="checkIn" path="checkInDate" type="text" size="20" />
	                Check Out Date: <form:input id="checkOut" path="checkOutDate" type="text" size="20" />
	                
	                <label for="customer">Customer</label>
					<form:select id="customer" path="customer.userID">
		 				<form:option value="0" label="--Select Customer"/>
		 				<form:options items="${users}" itemLabel="firstName" itemValue="userID"/> 
					</form:select><br><br>
					
					<form:input id="firstName" path="customer.firstName" type="text" size="20" value="existing" hidden="true"/>
					<form:input id="lastName" path="customer.lastName" type="text" size="20" value="customer" hidden="true"/>
									
					<label for="room">Room</label>
					<form:select id="room" path="room.roomID">
		 				<form:option value="0" label="--Select Room"/>
		 				<form:options items="${rooms}" itemLabel="type.name" itemValue="roomID"/> 
					</form:select>
					
					<label for="gym">Gym Included</label>
					<form:select id="gym" path="gym">
		 				<form:option value="true" label="Yes"/>
		 				<form:option value="false" label="No"/> 
					</form:select>
									     
					<label for="gym">Parking Included</label>
					<form:select id="parking" path="parking">
		 				<form:option value="true" label="Yes"/>
		 				<form:option value="false" label="No"/> 
					</form:select><br><br>
					
	                <form:errors path="checkInDate" class="text-error"/>
	                <form:errors path="checkOutDate" class="text-error"/>
	                <form:errors path="customer.userID" class="text-error"/>
	                <form:errors path="room.roomID" class="text-error"/><br>
	                <form:errors path="customer.firstName" class="text-error"/>
	                <form:errors path="customer.lastName" class="text-error"/>
            		         	       
		            <input id="submit" type="submit"  value="SUBMIT"/>
		        
	    	</fieldset>  
	    	<h2 style="color: red;" >${message }</h2> 
	    	<fieldset>
	        	<legend>List of Bookings</legend>	        	
	            <table id="itemsList">
					<tr style="width: 100%;">
						<th style="width: 12%; text-align: center;"><u>Booking ID</u></th>
						<th style="width: 12%; text-align: center;">Customer Name</th>
						<th style="width: 12%; text-align: center;">Room Id</th>
						<th style="width: 12%; text-align: center;">Room Type</th>
						<th style="width: 12%; text-align: center;">Check In</th>
						<th style="width: 12%; text-align: center;">Check Out</th>
						<th style="width: 12%; text-align: center;">Total Price</th>
						<th style="width: 12%; text-align: center;">Actions</th>
					</tr>
					<c:forEach var="booking" items = "${bookings}">
						<tr>
							<td align="center">${booking.bookingID}</td>
							<td align="center">${booking.customer.firstName}</td>
							<td align="center">${booking.room.roomID}</td>
							<td align="center">${booking.room.type.name}</td>
							<td align="center">${booking.checkInDate}</td>
							<td align="center">${booking.checkOutDate}</td>
							<td align="center">${booking.price}</td>
							<td align="center">
								<spring:url value="/deleteBooking/{bookingID}"  var="delete" >
   									<spring:param name="bookingID" value="${booking.bookingID}" />
 								</spring:url>
								<a href="${delete}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
	    	</fieldset>                                   
        </form:form>                
    </div>

    <footer class="foot">    	   	
    	<spring:message code="home.language" /> : <a href="?language=en_US">English</a>|<a href="?language=am_ET">አማርኛ</a>|<a href="?language=ur_PK">Urdu</a>   	
    </footer>
  </div>

  </body>
</html>