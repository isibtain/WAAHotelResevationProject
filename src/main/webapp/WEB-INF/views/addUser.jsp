<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Room</title>
    <link href="resources/css/style.css" rel="stylesheet">
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
    <div class="banner">
		<h1>Welcome to Your Admin Page ${alias }</h1>
	</div> 
    
    <div class="top">
      <nav>
        <ul>
          <li class="mid"><a href="<spring:url  value="/addBooking" />" ><spring:message code="admin.manage.bookings" /></a></li>
          <li class="mid"><a href="<spring:url  value="/addRoom" />" ><spring:message code="admin.manage.room" /></a></li>          
          <li class="mid"><a href="<spring:url  value="/addUser" />" class="active"><spring:message code="admin.manage.user" /></a></li>
          <li class="mid"><a href="<spring:url  value="/addRoomType" />" ><spring:message code="admin.manage.type" /></a></li>
          <li class="mid"><a href="<spring:url  value="/addViewType" />" ><spring:message code="admin.manage.view" /></a></li>
        </ul>
      </nav>
    </div><br>

    <div class="banner">
        <form:form id="searchForm" modelAttribute="user" action="addUser" method="post" >
            <fieldset>
	        	<legend>Add User Details</legend>
		        	        
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
		        	<label for="verifyPassword">Confirm Password</label><form:input   type="password" path="credentials.verifyPassword"/>		        	
		        	<label for="authority">Authority</label>
					<form:select id="authority" path="credentials.authority.authority">
		 				<form:option value="ADMIN" label="ADMIN"/>
		 				<form:option value="CUSTOMER" label="CUSTOMER"/> 
					</form:select><br><br>
		        	
		        	<label for="gym">Enable?</label>
					<form:select id="enabled" path="credentials.enabled">
		 				<form:option value="true" label="Yes"/>
		 				<form:option value="false" label="No"/> 
					</form:select>  <br><br>   
	   				<form:errors class="texterror" path="*" />	
	   				<p style="color:red;">${credmessage }</p>			  		       
	    	</fieldset>  
	    	<h2 style="color: red;" >${message }</h2> 
	    	
		            <input id="reset" type="reset"  value="RESET" />
		            <input id="submit" type="submit"  value="SUBMIT" /><br><br>
		     
		    <fieldset>
	        	<legend>List of Users</legend>	 
	        	<p style="color: red;">${deleteError }</p>       	
	            <table id="itemsList">
					<tr style="width: 100%;">
						<th style="width: 12%; text-align: center;">User ID</th>
						<th style="width: 12%; text-align: center;">First Name</th>
						<th style="width: 12%; text-align: center;">Last Name</th>
						<th style="width: 12%; text-align: center;">Street</th>
						<th style="width: 12%; text-align: center;">City</th>
						<th style="width: 12%; text-align: center;">State</th>
						<th style="width: 12%; text-align: center;">Email</th>
						<th style="width: 12%; text-align: center;">Phone</th>
						<th style="width: 12%; text-align: center;">Actions</th>
					</tr>
					<c:forEach var="user" items = "${users}">
						<tr>
							<td align="center">${user.userID}</td>
							<td align="center">${user.firstName}</td>
							<td align="center">${user.lastName}</td>
							<td align="center">${user.address.street}</td>
							<td align="center">${user.address.city}</td>
							<td align="center">${user.address.state}</td>
							<td align="center">${user.address.email}</td>
							<td align="center">${user.address.phone}</td>
							<td align="center">
								<spring:url value="/deleteUser/{userID}"  var="delete" >
   									<spring:param name="userID" value="${user.userID}" />
 								</spring:url>
								<a href="${delete}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
	    	</fieldset>                        
        </form:form>   
    </div>
    
	<footer class="foot">    	   	
    	<spring:message code="home.language" /> : <a href="?language=en_US">English</a>|<a href="?language=am_ET">አማርኛ</a>|<a href="?language=ur_PK">Urdu</a>   	
    </footer>
</div>
</body>
</html>
