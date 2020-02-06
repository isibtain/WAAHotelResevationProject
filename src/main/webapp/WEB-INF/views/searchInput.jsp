<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Room</title>
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
          <li><a href="<spring:url  value="/admin" />" ><spring:message code="admin" /></a></li>
          <li><a href="<spring:url  value="/search" />" class="active"><spring:message code="search" /></a></li>
          <li><a href="<spring:url  value="/review" />" ><spring:message code="reviews" /></a></li>
          <li><a href="<spring:url  value="/signup" />" ><spring:message code="sign.up" /></a></li>  
          <li><a href="<spring:url  value="/login" />" ><spring:message code="sign.in" /></a></li>     
        </ul>
      </nav>
    </div>
    <p style="text-align: right;">
    <spring:message code="home.language" /> : <a href="?language=en_US">English</a>|<a href="?language=am_ET">አማርኛ</a>
    </p>

    <div class="banner">
        <form:form id="searchForm" modelAttribute="booking" action="search" method="post" >
            <fieldset id="mainSearch">
                Check In Date: <form:input id="checkIn" path="checkInDate" type="text" size="20" />
                Check Out Date: <form:input id="checkOut" path="checkOutDate" type="text" size="20" />
            </fieldset><br>
            <h2 style="color: ${color};" >${roomMessage }</h2>
            <p id="buttons">
		            <input id="submit" type="submit"  value="SUBMIT" />
		   	</p>                   
        </form:form>
    </div>
    <div class="banner" ${hidden }>
        <form:form id="searchForm">
            <fieldset>
	        	<legend>List of Rooms</legend>	        	
	            <table id="itemsList">
					<tr style="width: 100%;">
						<th style="width: 20%;">Room Type</th>
						<th style="width: 20%;">View</th>
						<th style="width: 20%;">Price</th>
						<th style="width: 20%;">Select</th>
					</tr>
					<c:forEach var="room" items = "${rooms}">
						<tr>
							<td align="center">${room.type.name}</td>
							<td align="center">${room.view.name}</td>
							<td align="center">${room.price}</td>
							<td align="center"><button >Select</button></td>
						</tr>
					</c:forEach>
				</table>
	    	</fieldset>                  
        </form:form>   
    </div>
    <footer>Copyright 2019</footer>
</div>
</body>
</html>
