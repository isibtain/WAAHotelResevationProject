<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  	<head>
    	<title>Login</title>
    	<link href="resources/css/style.css" rel="stylesheet">
	</head>



<body>
<div id="container">
	<div class="top">
      	<h1><spring:message code="home.hotel.name" /></h1>
      	<nav>
        	<ul>
	          <li><a href="<spring:url  value="/index" />" ><spring:message code="home" /></a></li>
	          <%-- <li><a href="<spring:url  value="/admin" />" ><spring:message code="admin" /></a></li> --%>
	          <li><a href="<spring:url  value="/search" />" ><spring:message code="search" /></a></li>
	          <li><a href="<spring:url  value="/review" />" ><spring:message code="reviews" /></a></li>
	       	<c:if test="${alias eq null}">
          		<li><a href="<spring:url  value="/signup" />" ><spring:message code="sign.up" /></a></li>  
          	</c:if>          
          	<c:if test="${alias eq null}">
          		<li><a href="<spring:url  value="/login" />" class="active"><spring:message code="sign.in" /></a></li>
          	</c:if> 
          	<c:if test="${alias ne null}">
          		<li><a href="<spring:url  value="/logout" />" class="active"><spring:message code="sign.out" /></a></li>
          	</c:if>             
        	</ul>
      	</nav>
    </div>

	<div class="banner">
		<h1>${success }</h1>
        <h1>Login Credentials</h1>
        <div class="panel-body">
				
			<form:form id="searchForm" modelAttribute="credentials" action="login"  method="post" >
 			   	<security:csrfInput/> 	
 			   	<form:input class="form:input-large" id="username" path="username" type="text" size="20" placeholder="User Name" />
		    	<br><br>
		    	<form:input class="form:input-large" id="password" path="password" type="password" size="20" placeholder="Password"/>
		    	<br><br>
		    	<input class="btn btn-lg btn-success btn-mini" type="submit" value="Login">			    
			</form:form>	
			<form:errors class="texterror" path="*" />	
			<p style="color: red;">${loginmessage }</p>
		</div>
	</div>
</div>

    <footer class="foot">    	   	
    	<spring:message code="home.language" /> : <a href="?language=en_US">English</a>|<a href="?language=am_ET">አማርኛ</a>|<a href="?language=ur_PK">Urdu</a>   	
    </footer>

  </body>
</html>

	

