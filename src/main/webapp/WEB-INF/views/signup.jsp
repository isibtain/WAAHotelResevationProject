<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
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
          	<li><a href="<spring:url  value="/signup" />" class="active"><spring:message code="sign.up" /></a></li>  
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
    
    <div class="banner">
      <h1><spring:message code="signup.welcome" /></h1>
      <h2><spring:message code="signup.fill" /></h2>
    </div>
    
    <br><br>

    <div class="banner">
        <form:form id="searchForm" modelAttribute="user" action="signup" method="post" >
            <fieldset><br><br>
            		<label for="firstName">First Name</label><form:input   path="firstName" value="${addedUser.firstName }"/>	   			       		        		 	               
		        	<label for="lastName">Last Name</label><form:input   path="lastName" value="${addedUser.lastName }"/>	    				
	   				<label for="address.email">Email Address</label><form:input   path="address.email" value="${addedUser.address.email }"/>	          	                
		        	<label for="address.street">Street</label><form:input   path="address.street" value="${addedUser.address.street }"/><br><br>	 	              
		        	<label for="address.city">City</label><form:input   path="address.city" value="${addedUser.address.city }"/>	          	                
		        	<label for="address.state">State</label><form:input   path="address.state" value="${addedUser.address.state }"/>	         	               
		        	<label for="address.zip">Zip Code</label><form:input   path="address.zip" value="${addedUser.address.zip }"/>	          	      	        		     
		        	<label for="address.phone">Phone Number</label><form:input   path="address.phone" value="${addedUser.address.phone }"/><br><br>	  		        		                 
		        	<label for="userName">User Name</label><form:input   path="credentials.username" value="${addedUser.credentials.username }"/>  
		        	<label for="password">Password</label><form:input   type="password" path="credentials.password" />
		        	<label for="verifyPassword">Confirm Password</label><form:input   type="password" path="credentials.verifyPassword"/> <br><br>         
	   				<form:errors class="texterror" path="*" />	
	   				<h2 style="color: red;" >${credmessage }</h2>			  		       
	    	</fieldset><br><br>
	    	
		            <input id="submit" type="submit"  value="SIGN UP" /><br><br>
		                   
        </form:form>   
    </div>
    
	<footer class="foot">    	   	
    	<spring:message code="home.language" /> : <a href="?language=en_US">English</a>|<a href="?language=am_ET">አማርኛ</a>|<a href="?language=ur_PK">Urdu</a>   	
    </footer>
</div>
</body>
</html>
