<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>second page</title>
</head>
	<body>
		<%
			String message = (String)application.getAttribute("msg");%>
			
			Good afternoon <%= message %>
	</body>
</html>