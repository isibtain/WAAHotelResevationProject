<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hotel</title>
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
          <li class="mid"><a href="<spring:url  value="/addUser" />" ><spring:message code="admin.manage.user" /></a></li>
        </ul>
      </nav>
    </div>

    <footer><spring:message code="home.copyright" /> 2019</footer>
  </div>

  </body>
</html>
