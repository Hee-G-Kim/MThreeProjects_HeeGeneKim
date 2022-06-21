<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First page</title>
</head>

<body>
	<%
		String uname= request.getParameter("uname");
		String message= "Welcome " + uname;
		application.setAttribute("msg", message);
		
	%>
	<jsp:forward page="second.jsp" />
	
</body>
</html>