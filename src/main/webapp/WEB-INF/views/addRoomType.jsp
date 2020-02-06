<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Add Room Type</title>
    <link href="resources/css/searchInput.css" rel="stylesheet">
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
		        	        
		        	<label for="name">Room Type Name</label>
	   				<form:input   path="name"/>
	   				<form:errors path="name" cssClass="text-danger"/>	          
		                
		        	<label for="price">Base Price</label>
	   				<form:input   path="price"/>
	   				<form:errors path="price" cssClass="text-danger"/>	          
		        
		        <p id="buttons">
		            <input id="reset" type="reset"  value="RESET" />
		            <input id="submit" type="submit"  value="SUBMIT" />
		        </p>
	    	</fieldset>
		</form:form>   
    </div>
    
    <div class="banner">
        <form:form id="searchForm">
            <fieldset>
	        	<legend>List of Room Types</legend>	        	
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
							<td align="center"><button >Edit</button><button >Delete</button></td>
						</tr>
					</c:forEach>
				</table>
	    	</fieldset>                   
        </form:form>   
    </div>
    

    <footer><spring:message code="home.copyright" /> 2019</footer>
  </div>

  </body>
</html>