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
		<h3>Room Type Added</h3>
		<p>Type Name: ${addedType.name }</p>
		<p>Type Price: ${addedType.price }</p>
	</div>	
</body>
</html>