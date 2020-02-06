<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Add Booking</title>
    <link href="resources/css/searchInput.js" rel="stylesheet">
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
          <li class="mid"><a href="<spring:url  value="/addBooking" />" class="active"><spring:message code="admin.manage.bookings" /></a></li>
          <li class="mid"><a href="<spring:url  value="/addUser" />" ><spring:message code="admin.manage.user" /></a></li>
        </ul>
      </nav>
    </div><br>
    
    <div class="banner">
    
    
        <form:form id="searchForm" modelAttribute="booking" action="addBooking" method="post" >
            <fieldset>
	        	<legend>Add Booking</legend>
	        	
	        	<p>
	                Check In Date: <form:input id="checkIn" path="checkInDate" type="text" size="20" />
	                Check Out Date: <form:input id="checkOut" path="checkOutDate" type="text" size="20" /><br>
	                <form:errors path="checkInDate" cssClass="text-danger"/>
	                <form:errors path="checkOutDate" cssClass="text-danger"/>
            	</p>
	        	
		        <p>
		            <label for="customer">Customer</label>
					<form:select id="customer" path="customer.userID">
		 				<form:option value="0" label="--Select Customer"/>
		 				<form:options items="${users}" itemLabel="firstName" itemValue="userID"/> 
					</form:select>
					<form:errors path="customer.userID" cssClass="text-danger"/>
		        </p>
		        
		        <p>
		            <label for="room">Room</label>
					<form:select id="room" path="room.roomID">
		 				<form:option value="0" label="--Select Room"/>
		 				<form:options items="${rooms}" itemLabel="type.name" itemValue="roomID"/> 
					</form:select>
					<form:errors path="room.roomID" cssClass="text-danger"/>
		        </p>
	         
		        <p id="buttons">
		            <input id="reset" type="reset"  value="RESET" />
		            <input id="submit" type="submit"  value="SUBMIT" />
		        </p>
	    	</fieldset>  
	    	<h2 style="color: red;" >${message }</h2>                 
        </form:form>   
    </div>
    
    <div class="banner">
        <form:form id="searchForm">
            <fieldset>
	        	<legend>List of Bookings</legend>	        	
	            <table id="itemsList">
					<tr style="width: 100%;">
						<th style="width: 12%; text-align: center;">Booking ID</th>
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
							<td align="center">${booking.customer.name}</td>
							<td align="center">${booking.room.roomID}</td>
							<td align="center">${booking.room.type.name}</td>
							<td align="center">${booking.checkInDate}</td>
							<td align="center">${booking.checkOutDate}</td>
							<td align="center">${booking.price}</td>
							<td align="center"><button >Edit</button><button >Delete</button></td>
						</tr>
					</c:forEach>
				</table>
	    	</fieldset>                   
        </form:form>   
    </div>

    <footer><spring:message code="home.copyright" /> 2019</footer>
  </div>

  </body>
</html>