<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	
	<c:out value="Welcome to core tags"></c:out>
	
	<br>
	
	<c:set var="salary" scope = "session" value="${4000*12}"> 
	</c:set>
	
	<c:set var="salary" scope = "request" value="${3000*12}"> 
	</c:set>
	
	<c:out value ="${requestScope.salary}"></c:out>
	
	<c:catch var ="myException">  
   		<% int x = 2/0;%>  
	</c:catch>
	
	<c:if test="${myException != null}">  
	   <p>The type of exception is : ${myException} <br />  
	   There is an exception: ${myException.message}</p>  
	</c:if>
	
	<c:forEach begin="1" end="10" step="1"  var="myValue">
	<c:out value="${myValue}"></c:out>
	</c:forEach>
	
</body>
	
	

</html>