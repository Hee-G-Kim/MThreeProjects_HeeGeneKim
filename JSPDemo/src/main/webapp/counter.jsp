<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter Mechanism</title>
</head>


<body>
	<!-- declaration now a instance variable instead of local variable-->
	<%! int i =0; 
		public String sayHello(String name){
			return"Hello" +name;
		}
	%>
	<% 	
		i++;
		List<String> list = new ArrayList<>();
	
	%>
	you are visitor number: <%=i %>
	Greetings <%= sayHello("Amit")%>
	
	
</body>


</html>