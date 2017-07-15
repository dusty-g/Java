<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Random Word Generator</title>

</head>
<body>
<h2>You have generated a word <%= (Integer) request.getSession().getAttribute("count") %> times</h2>
<div class="wordbox"><h1><%= (String) request.getSession().getAttribute("randomWord") %></h1></div>
<form action="/RandomWord/Random" method="post"><button>Generate</button></form>
<h2>Last word generated at:</h2>
<div class="wordBox"><h2><%= (Date) request.getSession().getAttribute("createdAt") %></h2></div>
</body>
</html>