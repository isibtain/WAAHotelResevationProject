<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Room</title>
    <link href="resources/css/searchInput.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="resources/js/searchInput.js"></script>
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
          <li class="mid"><a href="<spring:url  value="/addRoomType" />" ><spring:message code="admin.manage.type" /></a></li>
          <li class="mid"><a href="<spring:url  value="/addViewType" />" ><spring:message code="admin.manage.view" /></a></li>
          <li class="mid"><a href="<spring:url  value="/addRoom" />" class="active"><spring:message code="admin.manage.room" /></a></li>
          <li class="mid"><a href="<spring:url  value="/addBooking" />" ><spring:message code="admin.manage.bookings" /></a></li>
          <li class="mid"><a href="<spring:url  value="/addUser" />" ><spring:message code="admin.manage.user" /></a></li>
        </ul>
      </nav>
    </div><br>

    <div class="banner">
        <form:form id="searchForm" modelAttribute="room" action="addRoom" method="post" >
            <fieldset>
	        	<legend>Add a Room</legend>
		        
		            <label for="type">Room Type</label>
					<form:select id="type" path="type.name">
		 				<form:option value="0" label="--Select Room Type"/>
		 				<form:options items="${roomTypes}" itemLabel="name" itemValue="name"/> 
					</form:select>
					<form:errors path="type.name" cssClass="text-danger"/>
		        
		            <label for="view">View Type</label>
					<form:select id="view" path="view.name">
		 				<form:option value="0" label="--Select Room View"/>
		 				<form:options items="${viewTypes}" itemLabel="name" itemValue="name"/> 
					</form:select>
					<form:errors path="view.name" cssClass="text-danger"/>
	         
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
	        	<legend>List of Rooms</legend>	        	
	            <table id="itemsList">
					<tr style="width: 100%;">
						<th style="width: 20%; text-align: center;">Room Type</th>
						<th style="width: 20%; text-align: center;">View</th>
						<th style="width: 20%; text-align: center;">Price</th>
						<th style="width: 20%; text-align: center;">Action</th>
						<th style="width: 20%; text-align: center;">Action</th>
					</tr>
					<c:forEach var="room" items = "${rooms}">
						<tr>
							<td align="center">${room.type.name}</td>
							<td align="center">${room.view.name}</td>
							<td align="center">${room.price}</td>
							<td align="center"><button >Edit</button></td>
							<td align="center"><button >Delete</button></td>
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
