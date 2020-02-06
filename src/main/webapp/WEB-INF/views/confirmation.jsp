<%--
  Created by IntelliJ IDEA.
  User: ozbud
  Date: 7/14/2019
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
    <link href="resources/css/confirmation.css" rel="stylesheet">
</head>

<body>

<div id="container">

    <div class="top">
        <h1>My Luxury Hotel</h1>
        <nav>
            <ul>
                <li><a href="index.jsp" class="active">Home</a></li>
                <li><a href="searchInput.jsp">Search rooms</a></li>
                <li><a href="review.jsp">Reviews</a></li>
                <li ${logged}><a href="login.jsp">Login</a></li>
                <%--                <li><a href="#">SignUp</a></li>--%>
                <li><a href="#">Contact</a></li>
            </ul>
        </nav>
    </div>

    <div id="content1">
        <h1>BOOKING CONFIRMATION</h1>
        <h3> Thank you for choosing us! </h3>
        <p> A ${room.type} bed room is reserved for you starting from ${checkIn} to ${checkOut}.</p>
        <p> Don't hesitate to give a call for any questions at 641 455 65 75 or email at booking@hotel.com</p>
    </div>

    <footer>Copyright 2019</footer>
</div>



</body>
</html>
