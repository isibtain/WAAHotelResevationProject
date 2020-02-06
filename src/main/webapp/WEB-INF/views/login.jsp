<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginServlet</title>
    <link href="resources/css/login.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="resources/js/login.js"></script>
</head>
<body>

<div id="container">

    <div class="top">
      <h1><spring:message code="home.hotel.name" /></h1>
      <nav>
        <ul>
          <li><a href="<spring:url  value="/index" />" ><spring:message code="home" /></a></li>
          <li><a href="<spring:url  value="/admin" />" ><spring:message code="admin" /></a></li>
          <li><a href="<spring:url  value="/search" />" ><spring:message code="search" /></a></li>
          <li><a href="<spring:url  value="/review" />" ><spring:message code="reviews" /></a></li>
          <li><a href="<spring:url  value="/signup" />" ><spring:message code="sign.up" /></a></li>  
          <li><a href="<spring:url  value="/login" />" class="active"><spring:message code="sign.in" /></a></li>     
        </ul>
      </nav>
    </div>
    <p style="text-align: right;">
    <spring:message code="home.language" /> : <a href="?language=en_US">English</a>|<a href="?language=am_ET">አማርኛ</a>
    </p>

    <div id="content">
        <h1>Login Credentials</h1>
        <form id="input" method="post" action="login">
            <%
                String value = "", checkbox = "";
                Cookie[] cookies = request.getCookies();
                if(cookies != null){
                    for(Cookie c : cookies){
                        if(c.getName().equals("userCookie")){
                            value = c.getValue();
                            checkbox = "checked";
                            break;
                        }
                    }
                }
                //  value = request.getCookies()[0].getValue();
            %>
            User Name:
            <input id="userName" name="userName" required value='<%=value%>'/></br></br>
            Password:
            <input id="password" name="password" type='password' required/></br></br>
            <div id="warn">

            </div>
            <button id="btn" type="button">Login</button>
            <input id="submitBtn" type="submit" hidden>
            <label><input id="cb" type='checkbox' name='remember' value="on" <%=checkbox%>/> Remember Me</label>
        </form>
    </div>

    <footer>Copyright 2019</footer>
</div>

</body>
</html>
