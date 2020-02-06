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
          <li><a href="<spring:url  value="/index" />" class="active"><spring:message code="home" /></a></li>
          <li><a href="<spring:url  value="/admin" />" ><spring:message code="admin" /></a></li>
          <li><a href="<spring:url  value="/search" />" ><spring:message code="search" /></a></li>
          <li><a href="<spring:url  value="/review" />" ><spring:message code="reviews" /></a></li>
          <li><a href="<spring:url  value="/signup" />" ><spring:message code="sign.up" /></a></li>  
          <li><a href="<spring:url  value="/login" />" ><spring:message code="sign.in" /></a></li>     
        </ul>
      </nav>
    </div>
    <p style="text-align: right; ">
    <spring:message code="home.language" /> : <a href="?language=en_US">English</a>|<a href="?language=am_ET">አማርኛ</a>
    </p>
	
    <div class="banner">
      <h2>Indoor&Outdoor</h2>
      <h1><spring:message code="home.hotel.banner" /></h1>
    </div>

    <footer><spring:message code="home.copyright" /> 2019</footer>
  </div>

  </body>
</html>
