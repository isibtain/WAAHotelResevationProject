<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title>Hotel</title>
    <link href="resources/css/style.css" rel="stylesheet">
    <script type="text/javascript" src="resources/js/review.js"></script>
  </head>
  <body>
  <div id="container">
    <div class="top">
      <h1><spring:message code="home.hotel.name" /></h1> 
      <nav>
        <ul>
          <li><a href="<spring:url  value="/index" />" ><spring:message code="home" /></a></li>
          <li><a href="<spring:url  value="/search" />" ><spring:message code="search" /></a></li>
          <li><a href="<spring:url  value="/review" />" class="active"><spring:message code="reviews" /></a></li>
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
    <div id="reviewSummary">
	    <span class="averageScore">Average RATING: <fmt:formatNumber type="number" maxFractionDigits="2" value="${avg}" /></span>
	    <span class="reviewCount">Total ${size} reviews</span>
	    <span class="reviewButton" align="left"><button id="btn_add_review" type="button"> + Please Add a Review </button></span>
	    <span class="averageStars"></span> 
    </div>
    
    <div class="reviewinput" id="myreviewform" ${formHidden }>           
       	<form:form id="fill" modelAttribute="review"  method="post" >
       		<fieldset>
    			<legend>Add Review</legend>
   				<p>
		            Reviewer First Name: <form:input id="firstName" path="firstName" type="text" size="15" />
		            Reviewer Last Name:<form:input id="lastName" path="lastName" type="text" size="15" />
		            Rating: 
		            <form:select id="rating" path="rating">
		 				<form:option value="5" label="5 STARS"/>
		 				<form:option value="4" label="4 STARS"/>
		 				<form:option value="3" label="3 STARS"/>
		 				<form:option value="2" label="2 STARS"/>
		 				<form:option value="1" label="1 STAR"/>
					</form:select>
			        Comment: <form:input id="comment" path="comment" type="text" size="60"/>
			        <br>
		            <form:errors path="*" class="texterror"/><br>
   				</p>
   
   				<p id="buttons" align="center">
       				<input id="reset" type="reset"  value="RESET" />
       				<input id="submit" type="submit"  value="SUBMIT" />
   				</p>
			</fieldset>  
   		</form:form>                                      
  	</div>
  	
  	<c:forEach items="${reviews}" var="review">
        <div class="review">
            <div class="score"><c:out value="${review.rating}" />/5</div>
            <div class="name"><c:out value="${review.firstName}" /></div>
            <div class="text">
                <span><c:out value="${review.comment}" /></span>
            </div>
        </div>
    </c:forEach>
  	
	<footer class="foot">    	   	
    	<spring:message code="home.language" /> : <a href="?language=en_US">English</a>|<a href="?language=am_ET">አማርኛ</a>|<a href="?language=ur_PK">Urdu</a>   	
    </footer>
</div>
</body>
</html>
