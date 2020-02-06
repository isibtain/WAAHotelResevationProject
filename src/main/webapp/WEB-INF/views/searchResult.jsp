<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
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
        <h1>My Luxury Hotel</h1>
        <nav>
            <ul>
 				<li><a href="<spring:url  value="/index" />" >Home</a></li>
	          	<li><a href="<spring:url  value="/search" />" >Search Rooms</a></li>
	          	<li><a href="<spring:url  value="/review" />" >Reviews</a></li>
	          	<li><a href="<spring:url  value="/login" />" >Login</a></li>
	          	<li><a href="<spring:url  value="/#" />" >SignUp</a></li>
	          	<li><a href="<spring:url  value="/#" />" >Contact</a></li>
            </ul>
        </nav>
    </div>

    <div class="banner">
        <c:forEach var="room" items = "${rooms}">
			<tr>
				<td>${room.type.name}</td>
				<td>${room.view.name}</td>
				<td>${room.price}</td>
			</tr>
		</c:forEach>        
    </div>
    <footer>Copyright 2019</footer>
</div>
</body>
</html>