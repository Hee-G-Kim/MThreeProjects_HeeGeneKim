<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- http://www.springframework.org/tags/form
     -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Form</title>
</head>
<body>
	<a href="changeLocale.htm?lang=en">English</a>
	&nbsp;&nbsp;
	<a href="changeLocale.htm?lang=es">Spanish</a>
	
	<form method="POST">
			<br/>
			ID: <input type="text" name="empid"/> <br/>
			FirstName: <input type="text" name="fname"/> <br/>
			LastName: <input type="text" name="lname"/> <br/>
			<input type="submit" value="submit"/> <br/>
			
	</form>
	<!-- <input type="submit" value="Submit"/> <br/>
			 -->

</body>
</html>