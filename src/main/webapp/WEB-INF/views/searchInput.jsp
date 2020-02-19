<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
          <li><a href="<spring:url  value="/search" />" class="active"><spring:message code="search" /></a></li>
          <li><a href="<spring:url  value="/review" />" ><spring:message code="reviews" /></a></li>
          <c:if test="${alias eq null}">
          	<li><a href="<spring:url  value="/signup" />" ><spring:message code="sign.up" /></a></li>  
          </c:if>          
          <c:if test="${alias eq null}">
          	<li><a href="<spring:url  value="/login" />" ><spring:message code="sign.in" /></a></li>
          </c:if> 
          <c:if test="${alias ne null}">
          	<li><a href="<spring:url  value="/logout" />" class="active"><spring:message code="sign.out" /></a></li>
          </c:if>    
        </ul>
      </nav>
    </div>
    <c:if test="${alias ne null}">
          	<p style="color: red; padding-left: 30px;" align="left">Logged in as ${alias }</p>
    </c:if>
    <div class="banner" ${display }>
		<h1>Welcome ${alias }</h1>
	</div>
	<br><br>
    <div class="banner" id="hide" ${visible }>
        <form:form id="searchForm" modelAttribute="booking" action="search" method="post" >
            <br>
                Check In Date: <form:input id="checkIn" path="checkInDate" type="text" size="20" />&nbsp;&nbsp;&nbsp;
                			   
                Check Out Date: <form:input id="checkOut" path="checkOutDate" type="text" size="20" /><br>
                <form:errors class="texterror" path="checkInDate" /><br>
                <form:errors class="texterror" path="checkOutDate" />
            <br>
            
		            <input id="submit" type="submit"  value="GET MY ROOMS" />
		            
		   	<h2 align="center" style="color: ${color};" >${roomMessage }</h2>                  
        </form:form>
    </div>
    <div class="banner" ${hidden }>
    	<h2 align="center" style="color: ${color};" >${roomMessage }</h2>
        <form:form id="searchForm">
            <fieldset>
	        	<legend>List of Rooms</legend>	        	
	            <table id="itemsList">
					<tr style="width: 100%;">
						<th style="width: 20%;">Room Type</th>
						<th style="width: 20%;">View</th>
						<th style="width: 20%;">Price</th>
						<th style="width: 20%;">ACTION</th>
					</tr>
					<c:forEach var="room" items = "${rooms}">
						<tr>
							<td align="center">${room.type.name}</td>
							<td align="center">${room.view.name}</td>
							<td align="center">${room.price}</td>
							<c:if test="${alias eq null}">
          						<td align="center"><button><a href="<c:url value="/book/${room.roomID}" />" class="btn btn-danger btn-mini pull-right">Select</a></button></td>												  
          					</c:if>          
          					<c:if test="${alias ne null}">
          						<td align="center"><button><a href="<c:url value="/memberBook/${room.roomID}" />" class="btn btn-danger btn-mini pull-right">Select</a></button></td>												
          					</c:if>							
						</tr>
					</c:forEach>
				</table>
	    	</fieldset>                  
        </form:form>   
    </div>
    <br><br>
    <div class="banner">
    	<c:if test="${alias ne null}">
          	<button onclick="window.location.href = 'http://localhost:8080/courseProject/manage';">MANAGE AN EXISTING BOOKING</button>
        </c:if><br>
        <h2 style="color: red;" >${noBooking }</h2>
        <c:if test="${myBookings ne null}">
          	<form:form id="searchForm" modelAttribute="booking" action="addBooking" method="post" >            	    	 
		    	<fieldset>
		        	<legend>Your Bookings</legend>	        	
		            <table id="itemsList">
						<tr style="width: 100%;">
							<th style="width: 12%; text-align: center;">Booking Number</th>
							<th style="width: 12%; text-align: center;">Room Type</th>
							<th style="width: 12%; text-align: center;">Check In Date</th>
							<th style="width: 12%; text-align: center;">Check Out Date</th>
							<th style="width: 12%; text-align: center;">Total Price</th>
							<th style="width: 12%; text-align: center;">Actions</th>
						</tr>
						<c:forEach var="booking" items = "${bookings}">
							<tr>
								<td align="center">${booking.bookingID}</td>
								<td align="center">${booking.room.type.name}</td>
								<td align="center">${booking.checkInDate}</td>
								<td align="center">${booking.checkOutDate}</td>
								<td align="center">${booking.price}</td>
								<td align="center">
									<spring:url value="/deleteMemberBooking/{bookingID}"  var="delete" >
	   									<spring:param name="bookingID" value="${booking.bookingID}" />
	 								</spring:url>
									<a href="${delete}">Cancel</a>
								</td>
							</tr>
						</c:forEach>
					</table>
		    	</fieldset>                                   
        	</form:form>           
        </c:if>      
    </div>
    <footer class="foot">    	   	
    	<spring:message code="home.language" /> : <a href="?language=en_US">English</a>|<a href="?language=am_ET">አማርኛ</a>|<a href="?language=ur_PK">Urdu</a>   	
    </footer>
</div>
</body>
</html>
