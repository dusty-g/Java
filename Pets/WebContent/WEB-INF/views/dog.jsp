<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.dusty.pets.models.Dog" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/Pets/style.css">
<title>Insert title here</title>
</head>
<body>
<% Dog dog = (Dog) request.getAttribute("dog");%>
	<p>Your <%= dog.getBreed()%> dog's name is <%= dog.getName() %>. <%=dog.showAffection() %> </p>
</body>
</html>