<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginPage</title>
</head>

<body>

     <form method='post' action='auth'>
	     username: <input type='text' name='username'/><br>
	     password: <input type='password' name='password'/><br>
     <input type='submit' value='Submit'/>
     </form>
     
     <!--  -->
     <!--  -->
     
     <% 
     	int items = (int)application.getAttribute("tshirts");
     %>
     You have purchased <%=items%> things.
     
 
</body>

</html>