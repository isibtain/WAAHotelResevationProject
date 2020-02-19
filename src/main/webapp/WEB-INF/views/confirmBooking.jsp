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
		<h1>Confirm Your Booking ${alias }</h1>
	</div>
	<br><br>
    <div class="banner" id="hide" ${visible }>
        <div id="searchForm">
 
                Check In Date: <input id="checkIn" type="text" name="checkIn" size="40" value="${checkIn }"/><br><br>               			   
                Check Out Date: <input id="checkOut" type="text" name="checkOut"size="40" value="${checkOut }"/><br><br>
                Room Type: <input id="room" type="text" size="20" name="type"value="${roomTypeName }"/><br><br>
                Total Price: <input id="price" type="text" size="20" name="price"value="${bookingPrice }"/><br><br>       		     
		       	
		       	<button><a href="<c:url value="/bookConfirm" />" class="btn btn-danger btn-mini pull-right">CONFIRM BOOKING</a></button>
		                       
        </div>
    </div>
    <footer class="foot">    	   	
    	<spring:message code="home.language" /> : <a href="?language=en_US">English</a>|<a href="?language=am_ET">አማርኛ</a>|<a href="?language=ur_PK">Urdu</a>   	
    </footer>
</div>
</body>
</html>
