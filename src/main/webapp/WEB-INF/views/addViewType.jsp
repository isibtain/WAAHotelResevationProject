<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>Add View Type</title>
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
          <li class="mid"><a href="<spring:url  value="/addUser" />" ><spring:message code="admin.manage.user" /></a></li>
          <li class="mid"><a href="<spring:url  value="/addRoomType" />" ><spring:message code="admin.manage.type" /></a></li>
          <li class="mid"><a href="<spring:url  value="/addViewType" />" class="active"><spring:message code="admin.manage.view" /></a></li>
        </ul>
      </nav>
    </div><br>
    
    <div class="banner">
        <form:form id="searchForm" modelAttribute="viewType" action="addViewType" method="post">
	    	<fieldset>
	        	<legend>Add a View Type</legend>
		        	        
		        	<label for="name">View Type Name</label><form:input   path="name"/>	  	   				           
		        	<label for="price">Base Price</label><form:input   path="price"/><br>
	   				<form:errors class="texterror" path="name" />	 
	   				<form:errors class="texterror" path="price" />         
		        
		        <p id="buttons">
		            <input id="reset" type="reset"  value="RESET" />
		            <input id="submit" type="submit"  value="SUBMIT" />
		        </p>
	    	</fieldset>
	    	<fieldset>
	        	<legend>List of View Types</legend>
	        	<p style="color: red;">${deleteError }</p>	        	
	            <table id="itemsList">
					<tr style="width: 100%;">
						<th style="width: 20%; text-align: center;">Name</th>
						<th style="width: 20%; text-align: center;">Price</th>
						<th style="width: 20%; text-align: center;">Actions</th>
					</tr>
					<c:forEach var="viewType" items = "${viewTypes}">
						<tr>
							<td align="center">${viewType.name}</td>
							<td align="center">${viewType.price}</td>
							<td align="center">
								<spring:url value="/deleteViewType/{viewTypeName}"  var="delete" >
   									<spring:param name="viewTypeName" value="${viewType.name}" />
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