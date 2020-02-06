<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Room Added</title>
</head>
<body>
	<div>
		<h3>View Type Added</h3>
		<p>View Name: ${addedView.name }</p>
		<p>View Price: ${addedView.price }</p>
	</div>	
</body>
</html>