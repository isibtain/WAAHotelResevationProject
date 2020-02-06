<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Reviews</title>
    <script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/review.js"></script>
    <link rel="stylesheet" type="text/css" href="resources/css/review.css">
</head>
<body>
    <div id="container">
        <header>
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
            
            
            <div class="banner">
                <h2>Indoor&Outdoor</h2>
                <h1>ENJOY A LUXURY EXPERIENCE!</h1>
            </div>
        </header>

        <div id="content">

            <div id="reviewSummary">
                    <span class="averageStars"></span>
                    <span class="averageScore">  <fmt:formatNumber type="number" maxFractionDigits="2" value="${avg}" />
                       </span>
                    <span class="reviewCount">Total ${size} reviews</span>
                    <span id="btn_add_review"> + Add Review </span> 
            </div>
         
            <div id="reviewForm">
            
            <form:form id="reviewForm" modelAttribute="review"  method="post" >
            <fieldset>
	        	<legend>Add Review</legend>
	        	
	        	<p>
	                Reviewer First Name: <form:input id="firstName" path="firstName" type="text" size="20" />
	                Reviewer Last Name:<form:input id="lastName" path="lastName" type="text" size="20" /><br>
	                <form:errors path="firstName" cssClass="text-danger"/>
	                <form:errors path="lastName" cssClass="text-danger"/>
            	</p>
	        	
		        <p>
		            <label for=rating>Rating</label>
					Rating: <form:input id="rating" path="rating" type="text" size="20"/>
		 				
					<form:errors path="rating" cssClass="text-danger"/>
		        </p>
		        
		        <p>
		            <label for="comment">Comment</label>
		            Comment: <form:input id="comment" path="comment" type="text" size="20"/>
					
					<form:errors path="comment" cssClass="text-danger"/>
		        </p>
	         
		        <p id="buttons">
		            <input id="reset" type="reset"  value="RESET" />
		            <input id="submit" type="submit"  value="SUBMIT" />
		        </p>
	    	</fieldset>  
        </form:form>   
            

                <!-- <div>
                    <label for="reviewer_name">Name</label>
                    <input type="text" id="reviewer_name" placeholder="Your Name" />
                </div>
                <div>
                    <label for="review_score">Score</label>
                    <select id="review_score" placeholder="Your Score" >
                        <option value="1">1 star - Hated it</option>
                        <option value="2">2 stars - Disliked it </option>
                        <option value="3" selected>3 stars - It was ok</option>
                    </select>
                </div>
                <div>
                    <label for="review_text">Review</label>
                    <textarea id="review_text" placeholder="Tell us your opinion"></textarea>
                </div>

                <div>
                    <input id="btn_add" type="submit" value="Submit" />
                </div>
            </div>
            
 -->            
            
            
            <c:forEach items="${reviews}" var="review">
                <div class="review">
                    <div class="score"><c:out value="${review.rating}" />/5</div>
                    <div class="name"><c:out value="${review.firstName}" /></div>
                    <!-- <div class="date">2019.07.12</div> -->
                    <div class="text">
                        <span><c:out value="${review.comment}" /></span>
                    </div>
                </div>
            </c:forEach>

        </div>
        <footer>Copyright 2020</footer>
    </div>
</body>
</html>
