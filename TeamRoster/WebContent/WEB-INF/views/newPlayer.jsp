<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Player</title>
</head>
<body>
<p>Create new player</p>
<form method="post" action="/TeamRoster/teams?id=<%= request.getParameter("id") %>">
<p>First Name: <input type="text" name="first_name"></p>
<p>Last Name: <input type = "text" name = "last_name"></p>
<p>Age: <input type="number" name="age"></p>
<button>Add</button>
</form>
</body>
</html>