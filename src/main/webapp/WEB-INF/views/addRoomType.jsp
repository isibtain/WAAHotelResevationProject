<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Add Room Type</title>
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
          <li><a href="<spring:url  value="/signup" />" ><spring:message code="sign.up" /></a></li>  
          <li><a href="<spring:url  value="/login" />" ><spring:message code="sign.in" /></a></li>     
        </ul>
      </nav>
    </div>   
    
    <div class="top">
      <nav>
        <ul>
          <li class="mid"><a href="<spring:url  value="/addRoomType" />" class="active"><spring:message code="admin.manage.type" /></a></li>
          <li class="mid"><a href="<spring:url  value="/addViewType" />" ><spring:message code="admin.manage.view" /></a></li>
          <li class="mid"><a href="<spring:url  value="/addRoom" />" ><spring:message code="admin.manage.room" /></a></li>
        </ul>
      </nav>
    </div><br>
    
    <div class="banner">
        <form:form id="searchForm" modelAttribute="roomType" action="addRoomType" method="post">
	    	<fieldset>
	        	<legend>Add a Room Type</legend>
		        	        
		        	<label for="name">Room Type Name</label><form:input   path="name"/>	   			     
		        	<label for="price">Base Price</label><form:input   path="price"/><br>
	   				<form:errors path="name" class="text-error"/>
	   				<form:errors path="price" class="text-error"/>	          
		        
		        <p id="buttons">
		            <input id="reset" type="reset"  value="RESET" />
		            <input id="submit" type="submit"  value="SUBMIT" />
		        </p>
	    	</fieldset>
	    	<fieldset>
	        	<legend>List of Room Types</legend>	   
	        	<p style="color: red;">${deleteError }</p>     	
	            <table id="itemsList">
					<tr style="width: 100%;">
						<th style="width: 20%; text-align: center;">Name</th>
						<th style="width: 20%; text-align: center;">Price</th>
						<th style="width: 20%; text-align: center;">Actions</th>
					</tr>
					<c:forEach var="roomType" items = "${roomTypes}">
						<tr>
							<td align="center">${roomType.name}</td>
							<td align="center">${roomType.price}</td>
							<td align="center">
								<spring:url value="/deleteRoomType/{roomTypeName}"  var="delete" >
   									<spring:param name="roomTypeName" value="${roomType.name}" />
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