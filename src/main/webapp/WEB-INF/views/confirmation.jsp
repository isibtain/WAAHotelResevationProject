<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hotel</title>
    <link href="resources/css/style.css" rel="stylesheet">
  </head>
  <body>
  <div id="container">

    <div class="top">
      <h1><spring:message code="home.hotel.name" /></h1>
      <nav>
        <ul>
          <li><a href="<spring:url  value="/index" />" class="active"><spring:message code="home" /></a></li>
          <li><a href="<spring:url  value="/search" />" ><spring:message code="search" /></a></li>
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
	
    <div id="confirmation">
        <h1>BOOKING CONFIRMATION</h1>
        <p> Dear <b>${customerName }</b><b>${alias }</b>, Thank you for choosing our Hotel! </p>
        <p> A <b>${roomType}</b><b>${roomTypeName}</b> room is reserved for you starting from <b>${checkIn}</b> to <b>${checkOut}</b>.</p>
        <p> For any questions about your reservation, please call us at 641 455 6575 or send an email to booking@hotel.com</p>
        <br>
        <button onclick="window.location.href = 'http://localhost:8080/courseProject/index';">EXIT TO HOME</button>&nbsp;&nbsp;&nbsp;
        <c:if test="${alias ne null}">
          	<button onclick="window.location.href = 'http://localhost:8080/courseProject/logout';">LOG OUT</button>
        </c:if><br>
    </div>
	<footer class="foot">    	   	
    	<spring:message code="home.language" /> : <a href="?language=en_US">English</a>|<a href="?language=am_ET">አማርኛ</a>|<a href="?language=ur_PK">Urdu</a>   	
    </footer>
  </div>

  </body>
</html>