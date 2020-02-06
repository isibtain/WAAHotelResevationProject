<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 7/14/2019
  Time: 4:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome page</title>
    <link href="resources/css/userPage.css" rel="stylesheet">
</head>
<body>

    <div id="container">

        <div class="top">
            <h1>My Luxury Hotel</h1>
            <nav>
                <ul>
                    <li><a href="index.jsp" class="active">Home</a></li>
                    <li><a href="searchInput.jsp">Search rooms</a></li>
                    <li><a href="#">Reviews</a></li>
<%--                    <li><a href="login.jsp">Logout</a></li>--%>
                    <%--                <li><a href="#">SignUp</a></li>--%>
                    <li><a href="#">Contact</a></li>
                </ul>
            </nav>
        </div>

        <div id="logged">
            Logged in as ${name}
            <form action="logout" method="post">
                <input type="submit" value="logout">
            </form>
        </div>

        <div id="content">
            <div class="my-div">
                <h1 id="welcome">Welcome to your Homepage ${name}</h1><br>
            </div>
            <div class="my-div">
                <a href="searchInput.jsp">Book Your Room</a> and enjoy your membership discount
            </div>
        </div>

        <footer>Copyright 2019</footer>
    </div>

</body>
</html>
